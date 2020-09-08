package com.carrot.train;

import java.util.*;

/**
 * @Author: carrot
 * @Date: 2020/9/8 20:24
 */
public class HealthCheckManagerImpl implements HealthCheckManager {
    //所有检查项检查项列表：
    private List<HealthCheckItem> itemList;
    //套餐列表key是套餐名，value是套餐
    private Map<String,HealthCheckPackage> map;

    @Override
    public void initial() {
        HealthCheckItem hcit1 = new HealthCheckItem("血常规", "检验血液",20);
        HealthCheckItem hcit2 = new HealthCheckItem("尿常规", "检验尿液", 20);
        HealthCheckItem hcit3 = new HealthCheckItem("肛肠科", "检验肛肠", 50);
        HealthCheckItem hcit4 = new HealthCheckItem("x胸透", "胸部检查", 60);
        HealthCheckItem hcit5 = new HealthCheckItem("心肺", "检验心肺功能",40 );
        itemList.add(hcit1);
        itemList.add(hcit2);
        itemList.add(hcit3);
        itemList.add(hcit4);
        itemList.add(hcit5);
        HashSet<HealthCheckItem> items1 = new HashSet<HealthCheckItem>();
        items1.add(hcit1);
        HealthCheckPackage hcpqu1 = new HealthCheckPackage("单享套餐1", 1, items1);
        items1.clear();
        items1.add(hcit2);
        HealthCheckPackage hcpqu2 = new HealthCheckPackage("单享套餐2", 1, items1);
        items1.clear();
        items1.add(hcit1);
        items1.add(hcit5);
        HealthCheckPackage hcpcon1 = new HealthCheckPackage("组合套餐1", 0.8, items1);
        items1.clear();
        items1.add(hcit1);
        items1.add(hcit2);
        HealthCheckPackage hcpcon2 = new HealthCheckPackage("组合套餐2", 0.8, items1);
        map.put(hcpqu1.getPackName(),hcpqu1);
        map.put(hcpqu2.getPackName(),hcpqu2);
        map.put(hcpcon1.getPackName(),hcpcon1);
        map.put(hcpcon2.getPackName(), hcpcon2);
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
            }
        }
    }

    @Override
    public void showPackageDetail(String packName) {
        if (map.containsKey(packName)) {
            map.get(packName).showDetail();
        } else {
            System.out.println("没有该套餐");
        }

    }

    @Override
    public boolean addItem(String packName, String itemName) {
        if (containlistitem(itemName)) {
        }

        if (map.containsKey(packName)) {
            map.get(packName).addHealthCheckItem();
        }
        return false;
    }

    @Override
    public boolean delItem(String packName, String itemName) {
        return false;
    }

    @Override
    public void updatePrice(String packName, float discount) {

    }

    @Override
    public boolean addPackage(String newpackName) {
        return false;
    }

    private boolean containlistitem(String itemName) {
        for (HealthCheckItem item:itemList) {
            if (item.getItemName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }
}
