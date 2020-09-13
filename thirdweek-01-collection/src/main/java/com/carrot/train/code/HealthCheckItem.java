package com.carrot.train;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class HealthCheckItem {

    private String itemName;
//    ���������
    private String itemDesc;
//    �����۸�
    private float itemPrice;

//    ��ʾ�������Ϣ
    public void showItem() {
        System.out.println(this.toString());
    }
}
