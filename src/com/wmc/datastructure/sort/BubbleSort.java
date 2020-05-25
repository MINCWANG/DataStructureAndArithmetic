package com.wmc.datastructure.sort;


import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

/**
 * @author: WangMC
 * @date: 2020/5/3 17:36
 * @description:
 */
public class BubbleSort {


    public static void main(String[] args) {
//        int[] arr = {1, 9, 7, 3, 8, 6};
        int[] arr = new int[80000];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        String time1 = LocalDateTime.now().format(ISO_LOCAL_DATE_TIME);
        System.out.println(time1);
        bubbleSort(arr);
        String time2 = LocalDateTime.now().format(ISO_LOCAL_DATE_TIME);
        System.out.println(time2);
//        System.out.println(time2 - time1);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

    }
}
