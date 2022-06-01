package com.xxt.space.data.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 进行数据增删改操作
 */
public class OperateDataDemo {

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = ConnectionUtils.getConnectionByPooledDataSource();
        insert(connection);
        update(connection);
        delete(connection);


    }

    private static void delete(Connection connection) {
    }

    private static void update(Connection connection) {

    }

    /**
     * 插入数据
     * @param connection
     */
    private static void insert(Connection connection) {

    }
}
