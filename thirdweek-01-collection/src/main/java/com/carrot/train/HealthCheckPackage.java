package com.carrot.train;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;

import java.util.Iterator;
import java.util.Set;
@Data
@AllArgsConstructor
public class HealthCheckPackage {
    //�ײ���
    private String packName;
//    �ۿ���
    private float discount = 1;
//    �ײͼ۸�
    private float totalPrice;
//    �ײ͵ļ����
    private Set<HealthCheckItem> items = new HashSet<HealthCheckItem>();

    public void calcTotalPrice() {
//        �޼�����ж�
        if (items==null||items.isEmpty()) {
            totalPrice=0;
        }
//        �м�����ж�
        if (items.size()>0) {
            Iterator<HealthCheckItem> it = items.iterator();
            while (it.hasNext()) {
                totalPrice=totalPrice+it.next().getItemPrice();
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
