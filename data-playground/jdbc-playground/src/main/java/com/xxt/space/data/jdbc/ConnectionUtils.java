package com.xxt.space.data.jdbc;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接获取工具
 */
public class ConnectionUtils {

    /**
     * 通过DriverManager获取数据库链接
     *
     * @return conn
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnectionByDriverManager() throws IOException, ClassNotFoundException, SQLException {
        Properties dbInfo = getDbInfo();
        //jdbc4.0之后不用在手动进行driver的注册
        //通过java SPI机制，在mysql的驱动包中自动进行了注册 META-INF/services/java.sql.driver
        Class.forName(dbInfo.getProperty("db.driver"));
        String url = dbInfo.getProperty("db.url");
        String username = dbInfo.getProperty("db.username");
        String password = dbInfo.getProperty("db.password");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 通过MySQl提供的DataSource接口实现 获取Connection
     * @return conn
     * @throws IOException
     * @throws SQLException
     */
    public static Connection getConnectionByDataSource() throws IOException, SQLException {
        Properties dbInfo = getDbInfo();
        String url = dbInfo.getProperty("db.url");
        String username = dbInfo.getProperty("db.username");
        String password = dbInfo.getProperty("db.password");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource.getConnection();
    }

    /**
     * 通过连接池获取连接
     * @return conn
     * @throws IOException
     * @throws SQLException
     */
    public static Connection getConnectionByPooledDataSource() throws IOException, SQLException {
        Properties dbInfo = getDbInfo();
        String url = dbInfo.getProperty("db.url");
        String username = dbInfo.getProperty("db.username");
        String password = dbInfo.getProperty("db.password");
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.getPooledConnection().addConnectionEventListener(new ConnectionEventListener() {
            @Override
            public void connectionClosed(ConnectionEvent event) {
                System.out.println("connection close");
            }

            @Override
            public void connectionErrorOccurred(ConnectionEvent event) {
                System.out.println("connection error");
            }
        });
        return dataSource.getPooledConnection().getConnection();
    }

    /**
     * 从配置文件中获取到数据库连接信息
     *
     * @return
     * @throws IOException
     */
    private static Properties getDbInfo() throws IOException {
        InputStream resourceAsStream = ViewDataDemo.class.getClassLoader().getResourceAsStream("db.properties");
        Properties dbInfo = new Properties();
        dbInfo.load(resourceAsStream);
        return dbInfo;
    }
}
