package com.carrot.train;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @Author carrot
 * @Description 单例的恶汉模式
 * @Date 2020/8/29 13:49
 **/
public class ActuatorSingetonHungry {
    private static ActuatorSingetonHungry actuatorSingleton = new ActuatorSingetonHungry();
    private ActuatorSingetonHungry() {
        System.out.println("construct hungry is null");
    }
    public static  ActuatorSingetonHungry getActuatorSingleton() {
        System.out.println("hungry get is :"+actuatorSingleton);
        return actuatorSingleton;
    }
}
