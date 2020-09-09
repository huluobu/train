package com.carrot.train;

/**
 * @Author: carrot
 * @Date: 2020/9/8 20:22
 */
public interface HealthCheckManager {
    //初始化套餐
    void initial();

//    显示所有检查项：循环调用所有检查项的showItem方法
    void showAllItems();

//    显示所有套餐：循环显示所有套餐的名字、折扣和总价
    void showAllPackages();

//    查看某套餐详情：根据套餐名字找到套餐，调用显示套餐详情的方法
    void showPackageDetail(String packName);

//    添加某套餐的检查项：根据套餐名找到套餐，若已经包括该检查项，则返回false表示不用重复添加，否则给套餐添加一个检查项，并更新总价
    boolean addItem(String packName,String itemName);

//    减少某套餐的检查项：根据套餐名找到套餐，循环该套餐的所有检查项，找到需要删除的检查项，删除，并更新总价
    boolean delItem(String packName,String itemName);

//    修改套某餐的折扣：根据套餐名找到套餐，更新该套餐的折扣，更新总价
    void updatePrice(String packName,double discount);

//    新增套餐：若所有套餐列表map中已经包括该套餐名，返回false表示套餐名不允许重复，否则添加一个空的新套餐
    boolean addPackage(String newpackName);

}
