package health.serviceImp;

import health.controller.healCommon;
import health.entity.HealthCheckItem;
import health.entity.HealthCheckPackage;
import health.service.HealthCheckManager;
import jdbc.JDBCUtils;
import lombok.Data;
import lombok.Getter;


import java.sql.Connection;
import java.util.*;

/**
 * @Author: carrot
 * @Date: 2020/9/8 20:24
 */
@Data
@Getter
public class HealthCheckManagerImpl implements HealthCheckManager {
    private healCommon hc=null;
    //所有检查项检查项列表：
    private List<HealthCheckItem> itemList;
    //套餐列表key是套餐名，value是套餐
    private Map<String, HealthCheckPackage> map;

    @Override
    public void initial() throws Exception {
        hc=new healCommon();
        itemList=new ArrayList<HealthCheckItem>();
        map=new HashMap<String,HealthCheckPackage>();
        Connection connection = JDBCUtils.getConnection();
        itemList = hc.getHealdaoitem().getall(connection);
        List<HealthCheckPackage> packagelist = hc.getHealdaopackage().getall(connection);
        for (HealthCheckPackage healthCheckPackage:packagelist) {
            map.put(healthCheckPackage.getPackName(), healthCheckPackage);
        }
        JDBCUtils.closeResource(connection,null);
    }

    @Override
    public void showAllItems() {
        if (itemList==null||itemList.size()==0) {
            System.out.println("无体检检查项");
        }
        if (itemList.size()>0) {
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println("体检项"+i+"为："+itemList.get(i)+"\n");
            }
        }

    }

    @Override
    public void showAllPackages() {
        if (map==null||map.isEmpty()) {
            System.out.println("无体检套餐可选择");
        }
        if (map.size()>0) {
            for (String hcp:map.keySet()) {
                System.out.println("套餐："+map.get(hcp).getPackName()+"\n");
            }
        }
    }

    @Override
    public void showPackageDetail(String packName) throws Exception {
        hc=new healCommon();
        if (map.containsKey(packName)) {
            hc.inithealCommon(packName);
            hc.showDetail();
        } else {
            System.out.println("没有该套餐");
        }

    }

    @Override
    public boolean addItem(String packName, String itemName) throws Exception {
        hc=new healCommon();
        boolean flag=false;
        if (containlistitem(itemName)==false) {
            System.out.println("添加的检查项不在库中");
            return flag;
        }
        Connection connection = JDBCUtils.getConnection();
        if (map.containsKey(packName)) {
            int index = hc.getHealdaoitem().getIndex(connection,itemName);
            if (index > 0) {
                HealthCheckItem item = itemList.get(index);
                HealthCheckPackage checkPackage = map.get(packName);
                if (checkPackage.getItems().contains(String.valueOf(index))) {
                    System.out.println("添加的检查项已经在套餐中,添加失败");
                    return flag;
                } else {
                    checkPackage.setItems(checkPackage.getItems()+","+index);
                }
                checkPackage.setDiscount(0.8);
                map.put(checkPackage.getPackName(), checkPackage);
                hc.setHealthCheckPackage(checkPackage);
                hc.getHealdaopackage().update(connection,checkPackage);
                hc.inithealCommon(checkPackage.getPackName());
                System.out.println("添加检查项成功");
                hc.showDetail();

                flag = true;
                JDBCUtils.closeResource(connection,null);
            } else {
                System.out.println("库中不包含该套餐");
            }
        } else {
            System.out.println("添加的套餐名不存在,添加失败");
        }
        return flag;
    }

    @Override
    public boolean delItem(String packName, String itemName) throws Exception {
        hc=new healCommon();
        boolean flag=false;
        if (containlistitem(itemName) == false) {
            System.out.println("删除的检查项不在库中");
            return flag;
        }
        Connection connection = JDBCUtils.getConnection();
        if (map.containsKey(packName)) {
            int index = getindexitemlist(itemName)+1;
            if (index > 0) {
                HealthCheckItem item = itemList.get(index);
                HealthCheckPackage checkPackage = map.get(packName);
                if (checkPackage.getItems().indexOf(String.valueOf(index))!= -1) {
                    checkPackage.setItems(checkPackage.getItems().replace(String.valueOf(index),","));
                    checkPackage.setDiscount(1.0);
                    map.put(checkPackage.getPackName(), checkPackage);
                    hc.setHealthCheckPackage(checkPackage);
                    hc.getHealdaopackage().update(connection,checkPackage);
                    hc.inithealCommon(checkPackage.getPackName());
                    hc.showDetail();
                    System.out.println("删除检查项成功");
                    flag = true;
                    JDBCUtils.closeResource(connection,null);
                } else {
                    System.out.println("套餐中无该检查项，删除检查项失败");
                    return flag;
                }
            }

        } else {
            System.out.println("添加的套餐名不存在,添加失败");
        }


        return flag;
    }


    @Override
    public boolean updatePrice(String packName, double discount) throws Exception {
        hc=new healCommon();
        boolean flag=false;
        if(discount<0||discount>1){
            System.out.println("请输的折扣数非法");
            return flag;
        }
        Connection connection = JDBCUtils.getConnection();
        if (map.containsKey(packName)) {
            HealthCheckPackage checkPackage = map.get(packName);
            checkPackage.setDiscount(discount);
            map.put(checkPackage.getPackName(), checkPackage);
            hc.getHealdaopackage().update(connection,checkPackage);
            System.out.println("修改折扣成功");
            hc.setHealthCheckPackage(checkPackage);
            hc.inithealCommon(checkPackage.getPackName());
            hc.showDetail();
            flag=true;
            JDBCUtils.closeResource(connection,null);
            return flag;
            } else {
                System.out.println("库中不包含该套餐,修改折扣失败");
            return flag;
            }
    }


    @Override
    public boolean addPackage(String newpackName) throws Exception {
        hc=new healCommon();
        boolean flag=true;
        for (String key : map.keySet()) {
            if (key.equals(newpackName)) {
                System.out.println("输入的套餐名存在");
                flag = false;
                break;
            }
        }
        Connection connection = JDBCUtils.getConnection();
        if (flag) {
            HealthCheckPackage checkPackage = new HealthCheckPackage();
            checkPackage.setPackName(newpackName);
            map.put(newpackName, checkPackage);
            hc.getHealdaopackage().insert(connection,checkPackage);
            System.out.println("添加套成功");
            JDBCUtils.closeResource(connection,null);
            return flag;
        } else {
                System.out.println("添加套餐失败");
            }
        return flag;
    }

    private boolean containlistitem(String itemName) {
        for (HealthCheckItem item:itemList) {
            if (item.getItemName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    private int getindexitemlist(String itemName) {
        int index=-1;
        for (int i=0;i<itemList.size();i++) {
            if (itemList.get(i).getItemName().equals(itemName)) {
                index = i;
                return index;
            }
        }
        return index;

    }
}
