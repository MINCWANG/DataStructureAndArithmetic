package com.wmc.datastructure.sort;

import java.time.LocalDateTime;

/**
 * @author: WangMC
 * @date: 2020/5/13 22:32
 * @description:
 */
public class RadixSort {

    public static void main(String[] args) {
//        int arr[] = { 53, 3, 542, 748, 14, 214};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);

        }
        System.out.println(LocalDateTime.now());
        radixSort(arr);
        System.out.println(LocalDateTime.now());
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int maxLen = (max + "").length();

        //二维数组包含了10个一维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketElemCounts = new int[10];

        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElem = arr[j] / n % 10;
                bucket[digitOfElem][bucketElemCounts[digitOfElem]] = arr[j];
                // 对应桶内下标的+1
                bucketElemCounts[digitOfElem] += 1;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElemCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if(bucketElemCounts[k] != 0){
                    //循环该桶即第k 个桶(即第k 个一维数组), 放入
                    for (int l = 0; l < bucketElemCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //遍历10次，每次完成后桶内count置0
                bucketElemCounts[k] = 0;
            }
//            System.out.println("第"+(i+1)+"轮，对个位的排序处理arr =" + Arrays.toString(arr));
        }
    }
}
