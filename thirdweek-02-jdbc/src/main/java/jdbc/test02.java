package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test02 {

    private Connection conn=null;
    private PreparedStatement ps=null;

    @Test
    public void updateHealthitem(){

        try {
            conn = jdbcUtils1.getConnection();
            String sql = "";
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils1.closeResource(conn,ps);
        }

    }
}
