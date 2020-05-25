package com.wmc.datastructure.sparsearray;


import org.junit.Test;

import java.io.*;

/**
 * @author: WangMC
 * @date: 2019/11/30 10:04
 * @description:
 */
public class SparseArray {

    public static void main(String[] args) {



    }

    /**
     * 二维数组 to 稀疏矩阵
     */
    @Test
    public void test1() throws IOException {
        // 创建二维数组 11 * 11
        //0：没有棋子 1：黑子 2：白子
        int[][] chessArr = new int[11][11];
        chessArr[1][10] = 1;
        chessArr[3][4] = 2;
        chessArr[7][9] = 1;
        chessArr[10][1] = 2;
        System.out.println("原始的二维数组");
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int i1 = 0; i1 < 11; i1++) {
                if (chessArr[i][i1] != 0) {
                    sum++;
                }
                System.out.print(chessArr[i][i1] + "\t");
            }
            System.out.println();
        }
        // System.out.println(sum);
        // 创建稀疏矩阵数组
        int[][] saparseArr = new int[sum + 1][3];
        // 给稀疏矩阵第一行赋值
        saparseArr[0][0] = 11;
        saparseArr[0][1] = 11;
        saparseArr[0][2] = sum;
        int y = 1;
        for (int i = 0; i < 11; i++) {
            for (int i1 = 0; i1 < 11; i1++) {
                if (chessArr[i][i1] != 0) {
                    // saparseArr[y++][2] = chessArr[i][i1];
                    // 行赋值
                    saparseArr[y][0] = i;
                    // 列赋值
                    saparseArr[y][1] = i1;
                    // 值赋值
                    saparseArr[y][2] = chessArr[i][i1];
                    y++;
                }
            }
        }
        System.out.println("二维数组 to 稀疏矩阵");
        for (int[] datas : saparseArr) {
            for (int data : datas) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        System.out.println("稀疏矩阵 to 二维数组");
        // 稀疏矩阵 to 二维数组
        // 定义二维数组
        int row = saparseArr[0][0];
        int column = saparseArr[0][1];
        int result = saparseArr[0][2];
        int[][] chessArr2 = new int[row][column];
        for (int i = 1; i <= result; i++) {
            chessArr2[saparseArr[i][0]][saparseArr[i][1]] = saparseArr[i][2];
        }
        for (int[] datas : chessArr2) {
            for (int data : datas) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }


        FileWriter fw = new FileWriter(new File("E:/map.data"));
        try {
            for (int[] datas : saparseArr) {
                // fw.write(, 0, datas.length);
                for (int data : datas) {
                    fw.write(data + "\t");
                }
                fw.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.flush();
            fw.close();
        }
    }

    /**
     * 从磁盘读取稀疏矩阵并转换为二维数组
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader(new File("E:/map.data"));
        BufferedReader br = new BufferedReader(fr);
        String tempString;
        int lineNum = 0;
        int[][] chessArr = new int[0][0];
        int rows = 0;
        int columns = 0;
        int results = 0;
        while ((tempString = br.readLine()) != null) {
            String[] lines = tempString.split("\t");
            if (lineNum == 0) {
                rows = Integer.parseInt(lines[0]);
                columns = Integer.parseInt(lines[1]);
                results = Integer.parseInt(lines[2]);
                chessArr = new int[rows][columns];
            } else {
                for (int i = 0; i < results; i++) {
                    chessArr[Integer.parseInt(lines[0])][Integer.parseInt(lines[1])] = Integer.parseInt(lines[2]);
                }
            }
            lineNum++;
        }
        for (int[] datas : chessArr) {
            for (int data : datas) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        br.close();
        fr.close();
    }


}
