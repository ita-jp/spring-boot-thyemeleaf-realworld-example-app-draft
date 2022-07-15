package com.pocotech.conduit.repository.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class URLTypeHandler extends BaseTypeHandler<URL> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, URL parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public URL getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (value != null) {
            try {
                return new URL(value);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
        return null;
    }

    @Override
    public URL getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (value != null) {
            try {
                return new URL(value);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
        return null;
    }

    @Override
    public URL getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (value != null) {
            try {
                return new URL(value);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
        return null;
    }

}
