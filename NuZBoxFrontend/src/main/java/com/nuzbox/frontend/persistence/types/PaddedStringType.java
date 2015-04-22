package com.nuzbox.frontend.persistence.types;

import java.io.Serializable;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Types;

import org.apache.commons.lang3.StringUtils;

import org.hibernate.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.BasicType;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

/**
 * Created by Farrell on 22/04/2015.
 */
public class PaddedStringType implements UserType {

    public int[] sqlTypes() {
        return new int[] {Types.CHAR};
    }

    public Class returnedClass() {
        return String.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return (x == y) || (x != null && y != null && (x.equals(y)));
    }

    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        String val = (String) StringType.INSTANCE.nullSafeGet(resultSet,strings,sessionImplementor,o);
        return StringUtils.trim(val);
    }

    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        String val = (String) o;
        preparedStatement.setString(i, val);
    }

    public Object deepCopy(Object o) throws HibernateException {
        if (o == null) {

            return null;

        }

        return new String(((String) o));
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    public Object replace(Object original, Object t, Object o) throws HibernateException {
        return original;
    }
}
