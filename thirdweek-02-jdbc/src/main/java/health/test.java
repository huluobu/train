package health;


import java.io.IOException;

public class test {
    public static void main(String[] args) throws Exception {
        HealCheckMen healCheckMen = new HealCheckMen();
        healCheckMen.healthCheckManager.initial();
        healCheckMen.showmenu1();
    }
}
