package health.dao.imp;

import health.dao.BaseDao;
import health.dao.healthCheckPackageDao;
import health.entity.HealthCheckItem;
import health.entity.HealthCheckPackage;

import java.sql.Connection;
import java.util.List;


public class healthCheckPackageDaoImp extends BaseDao implements healthCheckPackageDao {
    @Override
    public void insert(Connection conn, HealthCheckPackage healthCheckPackage) {
        String sql = "insert into HealthCheckPackage (packName,discount,totalPrice,items) values (?,?,?,?)";
        update(conn,sql,healthCheckPackage.getPackName(),healthCheckPackage.getDiscount(),healthCheckPackage.getTotalPrice(),healthCheckPackage.getItems());

    }

    @Override
    public void update(Connection conn, HealthCheckPackage healthCheckPackage) {
        String sql = "update HealthCheckPackage set discount = ?,totalPrice = ?,items = ? where packName = ?";
        update(conn,sql,healthCheckPackage.getDiscount(),healthCheckPackage.getTotalPrice(),healthCheckPackage.getItems(),healthCheckPackage.getPackName());
    }

    @Override
    public HealthCheckPackage queryById(Connection conn, int id) {
        String sql = "select packName,discount,totalPrice,items from HealthCheckPackage where pno = ?";
        HealthCheckPackage healthCheckPackage = getInstance(conn,HealthCheckPackage.class, sql,id);
        return healthCheckPackage;

    }

    @Override
    public HealthCheckPackage queryByItemName(Connection conn, String packName) {
        String sql = "select packName,discount,totalPrice,items from HealthCheckPackage where  packName = ?";
        HealthCheckPackage healthCheckPackage = getInstance(conn,HealthCheckPackage.class, sql,packName);
        return healthCheckPackage;
    }

    @Override
    public List<HealthCheckPackage> getall(Connection conn) {
        String sql = "select packName,discount,totalPrice,items from HealthCheckPackage  ";
        List<HealthCheckPackage> itemList=getForList(conn,HealthCheckPackage.class,sql);
        return itemList;
    }
}
