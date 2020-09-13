package health.dao;



import health.entity.HealthCheckItem;

import java.sql.Connection;
import java.util.List;

public interface healthCheckItemDao {

    void insert(Connection conn, HealthCheckItem healthCheckItem);

    void update(Connection coon, HealthCheckItem healthCheckItem);

    HealthCheckItem queryById(Connection coon, int id);

    HealthCheckItem queryByItemName(Connection coon, String itemName);

    int getIndex(Connection connection,String itemName);

    List<HealthCheckItem> getall(Connection connection);
}
