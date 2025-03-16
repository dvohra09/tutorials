package com.baeldung.hibernate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.id.IdentifierGenerationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.baeldung.hibernate.pojo.BaseballPlayer;
import com.baeldung.hibernate.pojo.Course;
import com.baeldung.hibernate.pojo.OrderEntry;
import com.baeldung.hibernate.pojo.OrderEntryIdClass;
import com.baeldung.hibernate.pojo.OrderEntryPK;
import com.baeldung.hibernate.pojo.Product;
import com.baeldung.hibernate.pojo.Student;
import com.baeldung.hibernate.pojo.TennisPlayer;
import com.baeldung.hibernate.pojo.User;
import com.baeldung.hibernate.pojo.UserProfile;

public class IdentifiersIntegrationTest {

    private Session session;

    private Transaction transaction;

    @Before
    public void setUp() throws IOException {
        session = HibernateUtil.getSessionFactory()
            .openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void tearDown() {
        transaction.rollback();
        session.close();
    }

    @Test
    public void whenSavingTennisPlayerWithoutAnId_thenSavingEntityOk() {
        TennisPlayer tennisPlayer = new TennisPlayer("Tom");
        session.save(tennisPlayer);
        assertThat(tennisPlayer.getPlayerId()).isEqualTo(0L);
    }

    @Test
    public void whenSavingBaseballPlayerWithoutAnId_thenSavingEntityFails() {
        BaseballPlayer baseballPlayer = new BaseballPlayer("Jerry");
        assertThatThrownBy(() -> session.save(baseballPlayer)).isInstanceOf(IdentifierGenerationException.class)
            .hasMessageContaining("ids for this class must be manually assigned before calling save()");
    }
    @Test
    public void whenSavingBaseballPlayerWithAManualId_thenSavingEntityOK() {
        BaseballPlayer baseballPlayer = new BaseballPlayer("Jerry");
        baseballPlayer.setPlayerId(42L);
        session.save(baseballPlayer);
    }

    @Test
    public void whenSaveSequenceIdEntities_thenOk() {
        Student student = new Student();
        session.save(student);
        User user = new User();
        session.save(user);

        assertThat(student.getStudentId()).isEqualTo(1L);
        assertThat(user.getUserId()).isEqualTo(4L);

        Course course = new Course();
        session.save(course);

    }

    @Test
    public void whenSaveCustomGeneratedId_thenOk() {
        Product product = new Product();
        session.save(product);
        Product product2 = new Product();
        session.save(product2);

        assertThat(product2.getProdId()).isEqualTo("prod-2");
    }

    @Test
    public void whenSaveCompositeIdEntity_thenOk() {
        User user = new User();

        OrderEntryPK entryPK = new OrderEntryPK();
        entryPK.setOrderId(1L);
        entryPK.setProductId(30L);
        entryPK.setUser(user);

        OrderEntry entry = new OrderEntry();
        entry.setEntryId(entryPK);
        session.save(entry);

        assertThat(entry.getEntryId()
            .getOrderId()).isEqualTo(1L);
    }

    @Test
    public void whenSaveIdClassEntity_thenOk() {
        User user = new User();

        OrderEntryIdClass entry = new OrderEntryIdClass();
        entry.setOrderId(1L);
        entry.setProductId(30L);
        entry.setUser(user);
        session.save(entry);

        assertThat(entry.getOrderId()).isEqualTo(1L);
    }

    @Test
    public void whenSaveDerivedIdEntity_thenOk() {
        User user = new User();
        session.save(user);

        UserProfile profile = new UserProfile();
        profile.setUser(user);
        session.save(profile);

        assertThat(profile.getProfileId()).isEqualTo(user.getUserId());
    }

}