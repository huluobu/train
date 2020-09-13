package health.dao.imp;

import health.dao.BaseDao;
import health.dao.healthCheckItemDao;
import health.entity.HealthCheckItem;

import java.sql.Connection;
import java.util.List;

public class healthCheckItemDaoImp extends BaseDao implements healthCheckItemDao {
    @Override
    public void insert(Connection conn, HealthCheckItem healthCheckItem) {
        String sql = "insert into HealthCheckItem (itemName,itemDesc,itemPrice) values (?,?,?)";
        update(conn,sql,healthCheckItem.getItemName(),healthCheckItem.getItemDesc(),healthCheckItem.getItemPrice());

    }

    @Override
    public void update(Connection conn, HealthCheckItem healthCheckItem) {
        String sql = "update HealthCheckItem set itemDesc = ?,itemPrice = ? where itemName = ?";
        update(conn,sql,healthCheckItem.getItemDesc(),healthCheckItem.getItemPrice(),healthCheckItem.getItemName());

    }

    @Override
    public HealthCheckItem queryById(Connection conn, int id) {
        String sql = "select itemName,itemDesc,itemPrice from HealthCheckItem where tno = ?";
        HealthCheckItem healthCheckItem = getInstance(conn,HealthCheckItem.class, sql,id);
        return healthCheckItem;
    }

    @Override
    public HealthCheckItem queryByItemName(Connection conn, String itemName) {
        String sql = "select itemName,itemDesc,itemPrice from HealthCheckItem where  itemName = ?";
        HealthCheckItem healthCheckItem = getInstance(conn,HealthCheckItem.class, sql,itemName);
        return healthCheckItem;
    }



    @Override
    public int getIndex(Connection conn, String itemName) {
        String sql = "select tno from HealthCheckItem where  itemName = ?";
        int index = getValue(conn,sql,itemName);
        return index;
    }

    @Override
    public List<HealthCheckItem> getall(Connection conn) {
        String sql = "select itemName,itemDesc,itemPrice from HealthCheckItem ";
        List<HealthCheckItem> itemList=getForList(conn,HealthCheckItem.class, sql);
        return  itemList;
    }

}
