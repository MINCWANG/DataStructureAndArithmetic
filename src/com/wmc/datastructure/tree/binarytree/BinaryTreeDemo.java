package com.wmc.datastructure.tree.binarytree;


/**
 * @author: WangMC
 * @date: 2020/5/20 18:21
 * @description:
 */
public class BinaryTreeDemo {


    public static void main(String[] args) {

        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);


    /*    System.out.println("前序遍历"); // 1,2,3,5,4
        binaryTree.preOrder();


        System.out.println("中序遍历");
        binaryTree.infixOrder(); // 2,1,5,3,4

        System.out.println("后序遍历");
        binaryTree.postOrder(); // 2,5,4,3,1*/
        //需要查找的对象
        int no = 5;
        //前序查找
//        binaryTree.preOrderSearch(no);
//        binaryTree.infixOrderSearch(no);
//        binaryTree.postOrderSearch(no);

        binaryTree.delNode(3);
        binaryTree.preOrder();
    }
}

class BinaryTree {

    private HeroNode root;


    public void setRoot(HeroNode root) {
        this.root = root;
    }


    public void delNode(int no) {
        if (this.root != null) {

            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delNodeAndReplaceRoot(no);
            }
        } else {

            System.out.println("空树，不能删除~");

        }
    }

    // 前序查找

    public void preOrderSearch(int no) {
        HeroNode node = this.root.preOrderSearch(no);
        System.out.println(node);
    }

    // 中序查找
    public void infixOrderSearch(int no) {
        HeroNode node = this.root.infixOrderSearch(no);
        System.out.println(node);
    }

    // 后序查找
    public void postOrderSearch(int no) {
        HeroNode node = this.root.postOrderSearch(no);
        System.out.println(node);
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }


}