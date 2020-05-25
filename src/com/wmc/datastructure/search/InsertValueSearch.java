package com.wmc.datastructure.search;

/**
 * @author: WangMC
 * @date: 2020/5/17 17:43
 * @description:
 */
public class InsertValueSearch {


    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int i = insertValueSearch(arr, 0, arr.length - 1, 56);

        System.out.println(i);
    }

    //编写插值查找算法
//说明：插值查找算法，也要求数组是有序的

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("插值查找次数~~");
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);


        int midVal = arr[mid];

        //向左递归
        if (findVal < midVal) {
            return insertValueSearch(arr, 0, mid - 1, findVal);
        }
        //向右递归
        else if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else {

            return mid;
        }

    }
}
