package com.xxt.space.data.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDemo {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = ConnectionUtils.getConnectionByPooledDataSource();
        showMySqlSupportedResultSetType(connection);
        showMySqlSupportedResultSetConcurrency(connection);
    }

    /**
     * 展示MySql支持的并发级别
     * @param connection conn
     */
    private static void showMySqlSupportedResultSetConcurrency(Connection connection) throws SQLException {
        //true
        System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));
        //ture
        System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
    }

    /**
     * 展示MySql支持的结果集类型
     * @param connection conn
     */
    private static void showMySqlSupportedResultSetType(Connection connection) throws SQLException {
        //true
        System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
        //true
        System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
        //false
        System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
    }
}
