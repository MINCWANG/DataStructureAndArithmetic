package com.wmc.datastructure.recursion;

/**
 * @author: WangMC
 * @date: 2020/5/2 23:46
 * @description:
 */
public class Queue8 {

    //定义一个max 表示共有多少个皇后
    int max = 8;
    //定义数组array, 保存皇后放置位置的结果,比如arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];

    static int count = 0;
    public static void main(String[] args) {


        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.println(count);
    }

    //编写一个方法，放置第n 个皇后
    //特别注意： check 是每一次递归时，进入到check 中都有for(int i = 0; i < max; i++)，因此会有回溯
    public void check(int n){


        if (n == max){
            count++;
            print();
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[n] = i;
            // 不冲突
            if (judge(n)){
                //接着放n+1 个皇后,即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i; 即将第n 个皇后，放置在本行得后移的一个位置
        }
    }


    //查看当我们放置第n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n 个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //1. array[i] == array[n] 表示判断第n 个皇后是否和前面的n-1 个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n 个皇后是否和第i 皇后是否在同一斜线
            // n = 1 放置第2 列1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }

        }
        return true;
    }
    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
