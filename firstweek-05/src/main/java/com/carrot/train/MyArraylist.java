package com.carrot.train;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author carrot
 * @Description 特定列表的构造方法
 * @Date 2020/8/29 15:45
 **/
public class MyArraylist {
    //记录当前数组的存储值
    public Integer currentindex;

    //记录当前数组容量
    public Integer length;

    //存储的数组
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
            //数组扩长，复制
            Integer newlength = this.length + this.length / 2;
            Object[] tmp = new Object[newlength];
            for (int i=0;i<this.length;i++) {
                tmp[i] = this.list[i];
            }
            //添加对象，调整参数
            tmp[currentindex]=object;
            this.list=tmp;
            this.length=newlength;
        }

    }

    public void moveFromMyArraylist(Integer index) {
        //参数判断
        if (index<0 || index>this.length) {
            System.out.println("your index is wrong");
        }
        //删除元素
        for (int i=index;i<length-1;i++) {
            this.list[i]=this.list[i+1];
        }
        this.currentindex=this.currentindex-1;
        //缩短判断处理
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
