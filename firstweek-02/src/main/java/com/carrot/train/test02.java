package com.carrot.train;


import com.carrot.train.factory.Fruit;
import com.carrot.train.factory.FruitFactory;
import com.carrot.train.factory2.Card;
import com.carrot.train.factory2.CardFactory;
import com.carrot.train.factory2.DiamondFactory;

import java.sql.SQLOutput;

/**
 * @Author carrot
 * @Description ����f5��ģʽ
 * @Date 2020/8/29 13:58
 **/
public class test02 {
    public static void main(String[] args) throws Exception {

        //���Ե���ģʽ
        ActuatorSingetonHungry act1 = ActuatorSingetonHungry.getActuatorSingleton();
        ActuatorSingetonLazzy act2 =ActuatorSingetonLazzy.getActuatorSingetonLazzy();

        //���Լ򵥹���ģʽ
        Fruit fruit = FruitFactory.produce("Apple");
        fruit.getcolor();

        //���Թ���ģʽ
        CardFactory cardFactory= new DiamondFactory();
        Card card=cardFactory.produce();
        card.getlevel();

        //�����Զ���list
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
        //���һ����int����
        myArraylist.addToMyArraylist(new test01());
        myArraylist.toString2();
        //�����11������
        myArraylist.addToMyArraylist(1);
        myArraylist.toString2();
        //ɾ����10������
        myArraylist.moveFromMyArraylist(10);
        myArraylist.toString2();
        myArraylist.moveFromMyArraylist(4);
        myArraylist.toString2();
        myArraylist.moveFromMyArraylist(4);
        myArraylist.toString2();
        //ɾ����7������
        myArraylist.moveFromMyArraylist(4);
        myArraylist.toString2();
        //����Ƿ������ж�
        myArraylist.moveFromMyArraylist(-1);


    }
}
