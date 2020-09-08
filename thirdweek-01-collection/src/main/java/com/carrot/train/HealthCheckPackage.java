package com.carrot.train;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

import java.util.Iterator;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthCheckPackage {
    //套餐名
    private String packName;
//    折扣名
    private Double discount = 1.0;
//    套餐价格
    private Double totalPrice;
//    套餐的检查项
    private Set<HealthCheckItem> items = new HashSet<HealthCheckItem>();

    public HealthCheckPackage(String packName,Double discount,HashSet<HealthCheckItem> items) {
        this.setPackName(packName);
        this.setDiscount(discount);
        this.setItems(items);
    }
    public void addHealthCheckItem(HealthCheckItem item) {
        items.add(item);
    }

    public void calcTotalPrice() {
//        无检查项判断
        if (items==null||items.isEmpty()) {
            totalPrice=0.0;
        }
//        有检查项判断
        if (items.size()>0) {
            Iterator<HealthCheckItem> it = items.iterator();
            while (it.hasNext()) {
                totalPrice=totalPrice+it.next().getItemPrice()*discount;
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
