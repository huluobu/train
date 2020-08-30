package com.carrot.train;

/**
 * @Author carrot
 * @Description  ����������ģʽ�˽�
 * @Date 2020/8/29 13:35
 **/
public class ActuatorSingetonLazzy {
    private Integer count=0;
    //
    private volatile  static ActuatorSingetonLazzy actuatorSingetonLazzy;


    //����
    private ActuatorSingetonLazzy() {
        System.out.println("construct lazzy is null");

    }

    public static ActuatorSingetonLazzy getActuatorSingetonLazzy() {
        if (actuatorSingetonLazzy==null) {
            //�߳�����������
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
