package health.entity;

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
    private Double totalPrice=0.0;
//    �ײ͵ļ����
    private String items = "";

    public HealthCheckPackage(String packName,Double discount,String items) {
        this.setPackName(packName);
        this.setDiscount(discount);
        this.setItems(items);
    }
//    public void addHealthCheckItem(HealthCheckItem item) {
//        items=item+","+
//    }

//    public void calcTotalPrice() {
//        totalPrice=0.0;
//        if (items==null||items.isEmpty()) {
//            totalPrice=0.0;
//        }
////        �м�����ж�
//        if (items.size()>0) {
//            Iterator<HealthCheckItem> it = items.iterator();
//            while (it.hasNext()) {
//                totalPrice=totalPrice+it.next().getItemPrice()*discount;
//            }
//
//        }
//    }

//    public void showPackge() {
////        this.calcTotalPrice();
//        System.out.println("套餐名为："+packName+"\n"+"折扣为"+discount+"\n"+"总价格"+totalPrice+"\n");
//    }
//
//    public void showDetail() {
//        showPackge();
//        System.out.println(items.toString());
//    }

}
