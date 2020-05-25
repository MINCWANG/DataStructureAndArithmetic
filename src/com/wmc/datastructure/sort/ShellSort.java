package com.wmc.datastructure.sort;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author: WangMC
 * @date: 2020/5/5 23:39
 * @description:
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(80000) + 1;
        }

//        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println(LocalDateTime.now());
//        shellSort(arr);
        shellSort2(arr);
        System.out.println(LocalDateTime.now());
    }

    /**
     * 移动法
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        int temp = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while 后，就给temp 找到插入的位置
                    arr[j] = temp;
                }

            }

        }
    }

    /**
     * 交换法
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        int temp = 0;

        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 对gap组的数据进行交换
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap 组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
        }


    }
}
