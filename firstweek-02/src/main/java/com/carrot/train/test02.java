package com.carrot.train;


import com.carrot.train.factory.Fruit;
import com.carrot.train.factory.FruitFactory;
import com.carrot.train.factory2.Card;
import com.carrot.train.factory2.CardFactory;
import com.carrot.train.factory2.DiamondFactory;

import java.sql.SQLOutput;

/**
 * @Author carrot
 * @Description 测试f5的模式
 * @Date 2020/8/29 13:58
 **/
public class test02 {
    public static void main(String[] args) throws Exception {

        //测试单例模式
        ActuatorSingetonHungry act1 = ActuatorSingetonHungry.getActuatorSingleton();
        ActuatorSingetonLazzy act2 =ActuatorSingetonLazzy.getActuatorSingetonLazzy();

        //测试简单工厂模式
        Fruit fruit = FruitFactory.produce("Apple");
        fruit.getcolor();

        //测试工厂模式
        CardFactory cardFactory= new DiamondFactory();
        Card card=cardFactory.produce();
        card.getlevel();

        //测试自定义list
        MyArraylist myArraylist=new MyArraylist();
        myArraylist.toString2();
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.toString2();
        myArraylist.addToMyArraylist(1);
        myArraylist.addToMyArraylist(1);
        myArraylist.toString2();
        myArraylist.moveFromMyArraylist(10);
        myArraylist.toString2();
        //添加一个非int对象
        myArraylist.addToMyArraylist(new test01());
        myArraylist.toString2();
        //添加至11个对象
        myArraylist.addToMyArraylist(1);
        myArraylist.toString2();
        //删除至10个对象
        myArraylist.moveFromMyArraylist(10);
        myArraylist.toString2();
        myArraylist.moveFromMyArraylist(4);
        myArraylist.toString2();
        myArraylist.moveFromMyArraylist(4);
        myArraylist.toString2();
        //删除至7个对象
        myArraylist.moveFromMyArraylist(4);
        myArraylist.toString2();
        //输入非法参数判断
        myArraylist.moveFromMyArraylist(-1);


    }
}
