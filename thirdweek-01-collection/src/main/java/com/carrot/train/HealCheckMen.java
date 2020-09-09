package com.carrot.train;

import java.io.IOException;
import java.util.Scanner;

public class HealCheckMen {
    HealthCheckManagerImpl healthCheckManager=new HealthCheckManagerImpl();
    HealthCheckPackage healthCheckPackage = new HealthCheckPackage();
    private Scanner input;

    public void showmenu1() throws IOException {
        healthCheckManager.initial();
        System.out.println("------体检套餐管理系统--------");
        System.out.println("---------------------------------");
        System.out.println("      1、显示所有套餐");
        System.out.println("      2、显示套餐详情");
        System.out.println("      3、增加某套餐检查项");
        System.out.println("      4、删除某套餐检查项");
        System.out.println("      5、修改某套餐折扣");
        System.out.println("      6、增加新套餐");
        System.out.println("      7、退出系统");
        System.out.println("---------------------------------");
        System.out.println("请选择您的服务项目(7):");
        input = new Scanner(System.in);
        int search=input.nextInt();
        switch (search) {
            case 1:showMenu2();break;
            case 2:showMenu3();break;
            case 3:showMenu4();break;
            case 4:showMenu5();break;
            case 5:showMenu6();break;
            case 7:
                System.out.println("-----欢迎下次使用------");
                System.exit(0);
            default:
                System.out.println("请输入0-4之间的数字！");
        }
    }
    public void showMenu2() throws IOException {
        System.out.println("------所有套餐有：--------");
        healthCheckManager.showAllPackages();
        System.out.println("---------------------------------");
        System.out.println("      1、返回主菜单");
        System.out.println("      2、退出");
        input = new Scanner(System.in);
        int search=input.nextInt();
        switch (search) {
            case 1:showmenu1();break;
            case 2:
                System.out.println("-----欢迎下次使用！------");
                System.exit(0);
            default:
                System.out.println("请输入0-4之间的数字！");
        }
    }
    public void showMenu3() throws IOException {
        System.out.println("------输入的套餐名称：--------");
        System.out.println("---------------------------------");

        input = new Scanner(System.in);
        String search=input.nextLine();
        healthCheckManager.getMap().get(search).showPackge();
        showMenu7();

    }
    public void showMenu4() throws IOException {}
    public void showMenu5() throws IOException {}
    public void showMenu6() throws IOException {}
    public void showMenu7() throws IOException {
        System.out.println("      1、返回主菜单");
        System.out.println("      2、退出");
        input = new Scanner(System.in);
        int search=input.nextInt();
        switch (search) {
            case 1:showmenu1();break;
            case 2:
                System.out.println("-----欢迎下次使用！------");
                System.exit(0);
            default:
                System.out.println("请输入0-4之间的数字！");
        }

    }



}
