package com.carrot.train;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;

import java.util.Iterator;
import java.util.Set;
@Data
@AllArgsConstructor
public class HealthCheckPackage {
    //套餐名
    private String packName;
//    折扣名
    private float discount = 1;
//    套餐价格
    private float totalPrice;
//    套餐的检查项
    private Set<HealthCheckItem> items = new HashSet<HealthCheckItem>();

    public void calcTotalPrice() {
//        无检查项判断
        if (items==null||items.isEmpty()) {
            totalPrice=0;
        }
//        有检查项判断
        if (items.size()>0) {
            Iterator<HealthCheckItem> it = items.iterator();
            while (it.hasNext()) {
                totalPrice=totalPrice+it.next().getItemPrice();
            }

        }
    }

    public void showPackge() {
        this.calcTotalPrice();
        System.out.println("套餐名："+packName+"/n"+"折扣："+discount+"/n"+"总价格："+totalPrice+"/n");
    }

    public void showDetail() {
        showPackge();
        System.out.println(items.toString());
    }

}
