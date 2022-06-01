package com.xxt.space.data.jdbc;

import java.io.IOException;
import java.sql.*;

/**
 * 一个快速展示查询结果集的示例
 */
public class ViewDataDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Connection connection = ConnectionUtils.getConnectionByPooledDataSource();
        queryData(connection);
        connection.close();
    }

    /**
     * 利用prepareStatement构建查询
     * 利用ResultSet处理结果集
     *
     * @param connection
     * @throws SQLException
     */
    private static void queryData(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from city where id = ?");
        preparedStatement.setInt(1, 10);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
        }
        preparedStatement.close();
    }


}
