package com.carrot.train;

/**
 * @Author carrot
 * @Description  单列懒加载模式了解
 * @Date 2020/8/29 13:35
 **/
public class ActuatorSingetonLazzy {
    private Integer count=0;
    //
    private volatile  static ActuatorSingetonLazzy actuatorSingetonLazzy;


    //构造
    private ActuatorSingetonLazzy() {
        System.out.println("construct lazzy is null");

    }

    public static ActuatorSingetonLazzy getActuatorSingetonLazzy() {
        if (actuatorSingetonLazzy==null) {
            //线程锁创建对象
            synchronized (ActuatorSingetonLazzy.class){
                if (actuatorSingetonLazzy == null) {
                    actuatorSingetonLazzy=new ActuatorSingetonLazzy();
                    actuatorSingetonLazzy.count=1;
                    System.out.println("new count is:"+actuatorSingetonLazzy.count);
                }
            }
        }else{
            System.out.println("exist actuatorSingetonLazzy is : "+actuatorSingetonLazzy);
        }
        return  actuatorSingetonLazzy;
    }

}
