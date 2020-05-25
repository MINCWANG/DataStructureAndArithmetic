package com.wmc.datastructure.tree.arrarytree;

/**
 * @author: WangMC
 * @date: 2020/5/21 13:28
 * @description:
 */
//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历
public class ArrBinaryTree {
    //存储数据结点的数组
    private final int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }
    public void infixOrder() {
        infixOrder(0);
    }

    public void postOrder() {
        postOrder(0);
    }




    /**
     * 顺序存储二叉树的后序遍历
     * @param index 数组的下标
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is null");
        }


        if ((index * 2 +1 )< arr.length){
            postOrder(index * 2 +1 );
        }

        if ((index * 2 +2 )< arr.length){
            postOrder(index * 2 +2 );
        }
        System.out.println(arr[index]);

    }


    /**
     * 顺序存储二叉树的中序遍历
     * @param index 数组的下标
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is null");
        }


        if ((index * 2 +1 )< arr.length){
            infixOrder(index * 2 +1 );
        }
        System.out.println(arr[index]);
        if ((index * 2 +2 )< arr.length){
            infixOrder(index * 2 +2 );
        }

    }

    /**
     * 顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is null");
        }

        System.out.println(arr[index]);
        if ((index * 2 +1 )< arr.length){
            preOrder(index * 2 +1 );
        }

        if ((index * 2 +2 )< arr.length){
            preOrder(index * 2 +2 );
        }

    }

}
