package com.carrot.train;


import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class HealthCheckItem {
//    检查项名
    private String itemName;
//    检查项描述
    private String itemDesc;
//    检查项价格
    private float itemPrice;

//    显示检查项信息
    public void showItem() {
        System.out.println(this.toString());
    }
}
