package com.catnest.common.datasource.handler;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 参考链接
 * <a href="https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers">MyBatis Handers</a>
 */
public class EncryptHandler extends BaseTypeHandler<String> {

    public EncryptHandler() {
    }

    public EncryptHandler(String securityKey) {
        this.securityKey = securityKey;
    }

    /**
     * 加密密钥
     */
    private String securityKey = "12345678abcdefgh";


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        String encrypt = AES.encrypt(s, securityKey);
        preparedStatement.setString(i, encrypt);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String columnValue = resultSet.getString(s);
        return AES.decrypt(columnValue, securityKey);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String columnValue = resultSet.getString(i);
        return AES.decrypt(columnValue, securityKey);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String columnValue = callableStatement.getString(i);
        return AES.decrypt(columnValue, securityKey);
    }
}
