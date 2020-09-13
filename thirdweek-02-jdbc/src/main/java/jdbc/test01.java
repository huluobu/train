package jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class test01 {
    @Test
    public void testConnection1() throws SQLException, ClassNotFoundException, IOException {
        InputStream is = null;

        is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("jdbc_driver");
        Class.forName(driverClass);
        Connection conn = null;
        conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

}
