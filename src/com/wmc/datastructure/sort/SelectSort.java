package com.wmc.datastructure.sort;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author: WangMC
 * @date: 2020/5/3 23:43
 * @description:
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(80000) + 1;
        }

//        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println(LocalDateTime.now());
        selectSort(arr);
        System.out.println(LocalDateTime.now());

    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    // 说明假定的最小值，并不是最小
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 将最小值，放在arr[i], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第"+(i+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
