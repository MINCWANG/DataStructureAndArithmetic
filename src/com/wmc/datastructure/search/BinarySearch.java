package com.wmc.datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WangMC
 * @date: 2020/5/17 13:26
 * @description:
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        List<Integer> list = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }


    // 二分查找算法

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回-1
     */
    public static List<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        List<Integer> list = new ArrayList<>();
        // 当left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return list;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        //向左递归
        if (findVal < midVal) {
            return binarySearch(arr, 0, mid - 1, findVal);
        }
        //向右递归
        else if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            list.add(mid);
            int temp = mid - 1;
            while (arr[temp] == findVal && temp > 0) {
                list.add(temp--);
            }

            temp = mid + 1;
            while (arr[temp] == findVal && temp < arr.length - 1) {
                list.add(temp++);
            }
        }
        list.sort((o1, o2) -> o1 - o2);
        return list;
    }


}
