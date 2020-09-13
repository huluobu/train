package health.dao.imp;

import health.entity.HealthCheckItem;
import jdbc.JDBCUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class healthCheckItemDaoImpTest {
    private healthCheckItemDaoImp daoImp = new healthCheckItemDaoImp();

    @Test
    public void queryById() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        int i=1;
        HealthCheckItem item=daoImp.queryById(connection, i);
        System.out.println(item);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void queryByItemName() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String name="x胸透";
        HealthCheckItem item=daoImp.queryByItemName(connection,name);
        System.out.println(item);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void getIndex() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String name="x胸透";
        int item = daoImp.getIndex(connection, name);
        System.out.println(item);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void getall() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        List<HealthCheckItem> itemList = daoImp.getall(connection);
        System.out.println(itemList);
        JDBCUtils.closeResource(connection,null);
    }
}