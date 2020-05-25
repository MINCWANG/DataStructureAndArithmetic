package com.wmc.arithmetic.dac;

/**
 * @author: WangMC
 * @date: 2020/5/25 23:29
 * @description:
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }


    /**
     * 汉诺塔的移动的方法
     * 使用分治算法
     *
     * @param num 盘的数量
     * @param a   A塔
     * @param b   B塔
     * @param c   C塔
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //如果我们有n >= 2 情况，我们总是可以看做是两个盘1.最下边的一个盘2. 上面的所有盘
            //1. 先把最上面的所有盘A->B， 移动过程会使用到c
            hanoiTower(num - 1, a, c, b);
            //2. 当将最上面的盘移走B后，再把最下面的盘移到C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 接着将B塔上面的盘子从B移到C，移动过程使用到a塔
            hanoiTower(num - 1, b, a, c);
        }

    }
}
