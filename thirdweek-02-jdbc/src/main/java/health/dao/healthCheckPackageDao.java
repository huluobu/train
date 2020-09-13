package health.dao;

import health.entity.HealthCheckItem;
import health.entity.HealthCheckPackage;

import java.sql.Connection;
import java.util.List;

public interface healthCheckPackageDao {
    void insert(Connection conn, HealthCheckPackage healthCheckPackage);

    void update(Connection coon, HealthCheckPackage healthCheckPackage);

    HealthCheckPackage queryById(Connection coon, int id);

    HealthCheckPackage queryByItemName(Connection coon, String packName);

    List<HealthCheckPackage> getall(Connection coon);
}
