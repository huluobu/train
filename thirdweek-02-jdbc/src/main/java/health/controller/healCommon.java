package health.controller;

import health.dao.imp.healthCheckItemDaoImp;
import health.dao.imp.healthCheckPackageDaoImp;
import health.entity.HealthCheckItem;
import health.entity.HealthCheckPackage;
import jdbc.JDBCUtils;
import lombok.Data;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@Data
public class healCommon {
    private healthCheckItemDaoImp healdaoitem = new healthCheckItemDaoImp();
    private healthCheckPackageDaoImp healdaopackage = new healthCheckPackageDaoImp();
    private HealthCheckPackage healthCheckPackage = new HealthCheckPackage();
    private  Set<HealthCheckItem> items = new HashSet<HealthCheckItem>();

    public void inithealCommon(String packName) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        healthCheckPackage= healdaopackage.queryByItemName(connection,packName);
        if (items==null||items.isEmpty()) {
            healthCheckPackage.setTotalPrice(0.0);
        }
        String[] set=healthCheckPackage.getItems().split(",");
        for (String s : set) {
            if(!s.equals("")){
                HealthCheckItem healthCheckItem=new HealthCheckItem();
                healthCheckItem = healdaoitem.queryById(connection, Integer.parseInt(s));
                items.add(healthCheckItem);
            }else{
                continue;
            }

        }
        JDBCUtils.closeResource(connection,null);
    }

    public void addHealthCheckItem(String packName,String name) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        int index = healdaoitem.getIndex(connection, name);
        healthCheckPackage.setItems(healthCheckPackage.getItems()+","+index);
        healdaopackage.update(connection,healthCheckPackage);
        System.out.println("添加成功");
        JDBCUtils.closeResource(connection,null);

    }

    public void calcTotalPrice() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        healthCheckPackage.setTotalPrice(0.0);
        if (items==null||items.isEmpty()) {
            healthCheckPackage.setTotalPrice(0.0);
        }
        if (items.size()>0) {
            Iterator<HealthCheckItem> it = items.iterator();
            while (it.hasNext()) {
                healthCheckPackage.setTotalPrice(healthCheckPackage.getTotalPrice()+it.next().getItemPrice()*healthCheckPackage.getDiscount());
            }
            healdaopackage.update(connection,healthCheckPackage);
            JDBCUtils.closeResource(connection,null);

        }
    }

    public void showPackge() throws Exception {
        this.calcTotalPrice();
        System.out.println("套餐名为："+healthCheckPackage.getPackName()+"\n"+"折扣为"+healthCheckPackage.getDiscount()+"\n"+"总价格"+healthCheckPackage.getTotalPrice()+"\n");
    }

    public void showDetail() throws Exception {
        showPackge();
        System.out.println(items.toString());
    }
}
