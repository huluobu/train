package com.carrot.train;

import java.io.IOException;
import java.util.Scanner;

public class HealCheckMen {
    HealthCheckManagerImpl healthCheckManager=new HealthCheckManagerImpl();
    HealthCheckPackage healthCheckPackage = new HealthCheckPackage();
    private Scanner input;

    public void showmenu1() throws IOException {
        healthCheckManager.initial();
        System.out.println("------����ײ͹���ϵͳ--------");
        System.out.println("---------------------------------");
        System.out.println("      1����ʾ�����ײ�");
        System.out.println("      2����ʾ�ײ�����");
        System.out.println("      3������ĳ�ײͼ����");
        System.out.println("      4��ɾ��ĳ�ײͼ����");
        System.out.println("      5���޸�ĳ�ײ��ۿ�");
        System.out.println("      6���������ײ�");
        System.out.println("      7���˳�ϵͳ");
        System.out.println("---------------------------------");
        System.out.println("��ѡ�����ķ�����Ŀ(7):");
        input = new Scanner(System.in);
        int search=input.nextInt();
        switch (search) {
            case 1:showMenu2();break;
            case 2:showMenu3();break;
            case 3:showMenu4();break;
            case 4:showMenu5();break;
            case 5:showMenu6();break;
            case 7:
                System.out.println("-----��ӭ�´�ʹ��------");
                System.exit(0);
            default:
                System.out.println("������0-4֮������֣�");
        }
    }
    public void showMenu2() throws IOException {
        System.out.println("------�����ײ��У�--------");
        healthCheckManager.showAllPackages();
        System.out.println("---------------------------------");
        System.out.println("      1���������˵�");
        System.out.println("      2���˳�");
        input = new Scanner(System.in);
        int search=input.nextInt();
        switch (search) {
            case 1:showmenu1();break;
            case 2:
                System.out.println("-----��ӭ�´�ʹ�ã�------");
                System.exit(0);
            default:
                System.out.println("������0-4֮������֣�");
        }
    }
    public void showMenu3() throws IOException {
        System.out.println("------������ײ����ƣ�--------");
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
        System.out.println("      1���������˵�");
        System.out.println("      2���˳�");
        input = new Scanner(System.in);
        int search=input.nextInt();
        switch (search) {
            case 1:showmenu1();break;
            case 2:
                System.out.println("-----��ӭ�´�ʹ�ã�------");
                System.exit(0);
            default:
                System.out.println("������0-4֮������֣�");
        }

    }



}
