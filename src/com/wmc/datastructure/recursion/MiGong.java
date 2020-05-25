package com.wmc.datastructure.recursion;



/**
 * @author: WangMC
 * @date: 2020/5/2 23:23
 * @description:
 */
public class MiGong {


    public static void main(String[] args) {

        String[] celuo = {"上","下","左","右"};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < celuo.length; i++) {

        }
        // 地图
        int[][] map = new int[8][7];


        // 迷宫上线墙
        for (int i = 0; i < 7; i++) {

            map[0][i] = 1;
            map[7][i] = 1;

        }


        // 迷宫左右墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }


        // 设置2个挡板
        map[1][2] = 1;
        map[2][2] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map, 1, 1);
        System.out.println("小球走过，并标识过的地图的情况");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发(1,1)
    //3. 如果小球能到map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为0 表示该点没有走过; 当为1 表示墙； 2 表示通路可以走； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左, 如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true, 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {


        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;

                if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果map[i][j] != 0 , 可能是1， 2， 3
                return false;
            }
        }

    }
}
