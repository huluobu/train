package health.dao.imp;

import health.entity.HealthCheckItem;
import health.entity.HealthCheckPackage;
import jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class healthCheckPackageDaoImpTest {
    private healthCheckPackageDaoImp daoImp=new healthCheckPackageDaoImp();

    @Test
    public void insert() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        HealthCheckPackage healthCheckPackage = new HealthCheckPackage();
        healthCheckPackage.setDiscount(1.0);
        healthCheckPackage.setPackName("单享套餐3");
        healthCheckPackage.setTotalPrice(0.0);
        healthCheckPackage.setItems("3");
        daoImp.insert(connection,healthCheckPackage);
        System.out.println(healthCheckPackage);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void update() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        HealthCheckPackage healthCheckPackage = new HealthCheckPackage();
        healthCheckPackage.setDiscount(1.0);
        healthCheckPackage.setPackName("单享套餐3");
        healthCheckPackage.setTotalPrice(0.0);
        healthCheckPackage.setItems("2,3");
        daoImp.update(connection,healthCheckPackage);
        System.out.println(healthCheckPackage);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void queryById() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        HealthCheckPackage healthCheckPackage = daoImp.queryById(connection, 2);
        System.out.println(healthCheckPackage);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void queryByItemName() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        HealthCheckPackage healthCheckPackage = daoImp.queryByItemName(connection,"单享套餐2");
        System.out.println(healthCheckPackage);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void getall() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        List<HealthCheckPackage> itemList = daoImp.getall(connection);
        System.out.println(itemList);
        JDBCUtils.closeResource(connection,null);
    }

    @Test
    public void getall1() throws Exception {
        String st1="1,,,3";
        String[] set=st1.split(",");
        System.out.println(set[1]);
    }
}