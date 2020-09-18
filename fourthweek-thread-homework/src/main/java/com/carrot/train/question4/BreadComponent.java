package com.carrot.train.question4;

import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@NoArgsConstructor
public class BreadComponent {
    private String a = "bread";
    private String b = "romaine";
    private String c = "meat";
    private Lock lock=new ReentrantLock();

    public void usea() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"制作汉堡使用bread");
        }finally {
            lock.unlock();
        }
    }
    public void useb() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"制作汉堡使用meat");
        }finally {
            lock.unlock();
        }
    }
    public void usec() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"制作汉堡使用romaine");
        }finally {
            lock.unlock();
        }
    }
}
