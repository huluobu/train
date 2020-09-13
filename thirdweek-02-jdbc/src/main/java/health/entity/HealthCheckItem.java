package health.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    public HealthCheckItem(String itemName,String itemDesc,float itemPrice) {
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }
}
