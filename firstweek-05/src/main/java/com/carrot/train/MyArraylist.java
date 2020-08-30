package com.carrot.train;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author carrot
 * @Description �ض��б�Ĺ��췽��
 * @Date 2020/8/29 15:45
 **/
public class MyArraylist {
    //��¼��ǰ����Ĵ洢ֵ
    public Integer currentindex;

    //��¼��ǰ��������
    public Integer length;

    //�洢������
    public Object[] list;

    public  MyArraylist(){
        this.currentindex=0;
        this.length=10;
        this.list=new Object[this.length];
    }

    public void addToMyArraylist(Object object) {
        this.currentindex=this.currentindex+1;
        if (this.currentindex < this.length) {
            this.list[currentindex]=object;

        }
        if (this.currentindex > this.length) {
            //��������������
            Integer newlength = this.length + this.length / 2;
            Object[] tmp = new Object[newlength];
            for (int i=0;i<this.length;i++) {
                tmp[i] = this.list[i];
            }
            //��Ӷ��󣬵�������
            tmp[currentindex]=object;
            this.list=tmp;
            this.length=newlength;
        }

    }

    public void moveFromMyArraylist(Integer index) {
        //�����ж�
        if (index<0 || index>this.length) {
            System.out.println("your index is wrong");
        }
        //ɾ��Ԫ��
        for (int i=index;i<length-1;i++) {
            this.list[i]=this.list[i+1];
        }
        this.currentindex=this.currentindex-1;
        //�����жϴ���
        if (this.length > 10) {
            if (this.currentindex<=(this.length-this.length/3)) {
                Integer newlength = this.length - this.length / 3;
                Object[] tmp = new Object[newlength];
                for (int i=0;i<newlength;i++) {
                    tmp[i] = this.list[i];
                }
                this.list = tmp;
                this.length = newlength;
            }
        }



    }

    public void toString2() {
        System.out.println("=======================================================");
        System.out.println( "currentindex is: "+this.currentindex+"\nlength is :"+this.length);
    }

    public void toString3() {
        for (int i=0;i<this.currentindex;i++) {
            System.out.println(this.list[i].toString()+",");
        }
    }

}
