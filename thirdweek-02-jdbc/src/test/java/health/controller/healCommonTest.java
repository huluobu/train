package health.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import static org.junit.Assert.*;

public class healCommonTest {

    @Test
    public void inithealCommon() throws Exception {
        healCommon hc=new healCommon();
        String name = "组合套餐1";
        hc.inithealCommon(name);
        System.out.println(hc.getHealthCheckPackage());
        hc.showPackge();
        hc.showDetail();
    }

    @Test
    public void addHealthCheckItem() throws Exception {
        healCommon hc=new healCommon();
        String name = "组合套餐1";
        hc.inithealCommon(name);
        hc.showDetail();
        hc.addHealthCheckItem(hc.getHealthCheckPackage().getPackName(),"x胸透");
        System.out.println(hc.getHealthCheckPackage());
    }

    @Test
    public void calcTotalPrice() {
    }

    @Test
    public void showPackge() {
    }

    @Test
    public void showDetail() {
    }
}