package com.wmc.datastructure.sparsearray;

import java.util.Scanner;

/**
 * @author: WangMC
 * @date: 2019/12/16 11:01
 * @description:
 */
public class ArrayQueueMain {


    public static void main(String[] args) {


        ArrayQueue queue = new ArrayQueue(4);
        //接收输入字符
        char key = ' ';

        boolean loop = true;
        while (loop) {
            System.out.println("s(show) 显示队列");
            System.out.println("e(exit) 退出程序");
            System.out.println("a(add) 添加数据到队列");
            System.out.println("g(get) 从队列中取出数据");
            System.out.println("h(head) 查看队列头的数据");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            key = s.charAt(0);
            System.out.println(key);
            switch (key) {
                case 's':

                    queue.showQueue();
                    break;
                case 'a':

                    System.out.println("请输入数");
                    int i = scanner.nextInt();
                    queue.addQueue(i);
                    break;
                case 'g':

                    int getData = queue.getQueue();
                    System.out.println("取出的数据是" + getData);
                    break;
                case 'h':

                    int h = queue.headQueue();
                    System.out.println(h);
                    break;
                case 'e':

                    scanner.close();
                    loop = false;
                    break;
                default:
            }
        }
        System.out.println("程序退出");
    }


}
