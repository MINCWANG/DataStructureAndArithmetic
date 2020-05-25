package com.wmc.datastructure.tree.arrarytree;

/**
 * @author: WangMC
 * @date: 2020/5/21 13:26
 * @description:
 */
public class ArrBinaryTreeDemo {


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        //创建一个ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
        System.out.println("*-----------");
        arrBinaryTree.infixOrder();
        System.out.println("*-----------");
        arrBinaryTree.postOrder();
    }


}
