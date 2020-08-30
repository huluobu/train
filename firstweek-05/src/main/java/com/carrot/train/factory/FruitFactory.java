package com.carrot.train.factory;

/**
 * @Author carrot
 * @Description 工厂模式了解
 * @Date 2020/8/29 14:15
 **/
public class FruitFactory {
    public  static Fruit produce(String param) {
        Fruit fruit=null;
        if (param.equals("Appple")) {
            fruit =new Apple();
        }
        if (param.equals("Peach")) {
            fruit =new Peach();
        }
        if (param.equals("Banana")) {
            fruit =new Peach();
        }
        return fruit;
    }
}
