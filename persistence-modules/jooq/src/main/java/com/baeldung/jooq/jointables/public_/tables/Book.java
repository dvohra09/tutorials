/*
 * This file is generated by jOOQ.
 */
package com.baeldung.jooq.jointables.public_.tables;


import com.baeldung.jooq.jointables.public_.Keys;
import com.baeldung.jooq.jointables.public_.Public;
import com.baeldung.jooq.jointables.public_.tables.records.BookRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Book extends TableImpl<BookRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.Book</code>
     */
    public static final Book BOOK = new Book();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookRecord> getRecordType() {
        return BookRecord.class;
    }

    /**
     * The column <code>public.Book.id</code>.
     */
    public final TableField<BookRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.Book.author_id</code>.
     */
    public final TableField<BookRecord, Integer> AUTHOR_ID = createField(DSL.name("author_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.Book.title</code>.
     */
    public final TableField<BookRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.Book.description</code>.
     */
    public final TableField<BookRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.Book.store_id</code>.
     */
    public final TableField<BookRecord, Integer> STORE_ID = createField(DSL.name("store_id"), SQLDataType.INTEGER, this, "");

    private Book(Name alias, Table<BookRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Book(Name alias, Table<BookRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.Book</code> table reference
     */
    public Book(String alias) {
        this(DSL.name(alias), BOOK);
    }

    /**
     * Create an aliased <code>public.Book</code> table reference
     */
    public Book(Name alias) {
        this(alias, BOOK);
    }

    /**
     * Create a <code>public.Book</code> table reference
     */
    public Book() {
        this(DSL.name("Book"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<BookRecord> getPrimaryKey() {
        return Keys.BOOK_PKEY;
    }

    @Override
    public Book as(String alias) {
        return new Book(DSL.name(alias), this);
    }

    @Override
    public Book as(Name alias) {
        return new Book(alias, this);
    }

    @Override
    public Book as(Table<?> alias) {
        return new Book(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(String name) {
        return new Book(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(Name name) {
        return new Book(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(Table<?> name) {
        return new Book(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Book where(Condition condition) {
        return new Book(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Book where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Book where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Book where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Book where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Book where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Book where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Book where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Book whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Book whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
