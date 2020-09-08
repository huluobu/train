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
    //�ײ���
    private String packName;
//    �ۿ���
    private Double discount = 1.0;
//    �ײͼ۸�
    private Double totalPrice;
//    �ײ͵ļ����
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
//        �޼�����ж�
        if (items==null||items.isEmpty()) {
            totalPrice=0.0;
        }
//        �м�����ж�
        if (items.size()>0) {
            Iterator<HealthCheckItem> it = items.iterator();
            while (it.hasNext()) {
                totalPrice=totalPrice+it.next().getItemPrice()*discount;
            }

        }
    }

    public void showPackge() {
        this.calcTotalPrice();
        System.out.println("�ײ�����"+packName+"/n"+"�ۿۣ�"+discount+"/n"+"�ܼ۸�"+totalPrice+"/n");
    }

    public void showDetail() {
        showPackge();
        System.out.println(items.toString());
    }

}
