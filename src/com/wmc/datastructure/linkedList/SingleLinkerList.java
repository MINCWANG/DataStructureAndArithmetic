package com.wmc.datastructure.linkedList;

import java.util.Stack;

/**
 * @author: WangMC
 * @date: 2019/12/16 16:49
 * @description:
 */
public class SingleLinkerList {

    /**
     * 初始化一个头节点
     */
    private final HeroNode head = new HeroNode(0, "", "");

    /**
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }


    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = this.head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("Hero已存在！" + heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    public void update(HeroNode heroNode) {
        if (heroNode == null) {
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }


    public void del(int no) {
        HeroNode temp = this.head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void list() {
        if (head.next == null) {
            return;
        }

        HeroNode temp = head.next;
        while (true) {

            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public int getLength() {

        int sum = 0;
        if (head.next == null) {
            return sum;
        }

        HeroNode temp = head.next;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }


    public HeroNode findLastIndexNode(int index) {
        if (head.next == null) {
            return null;
        }

        int length = getLength();
        int lastIndex = length - index;
        HeroNode temp = head.next;
        while (temp != null) {
            lastIndex--;
            if (lastIndex == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;

    }


    public void reverseList() {
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        if (temp == null) {
            return;
        }
        while (temp != null) {
            // 原链表的指针给next保存
            next = temp.next;
            // 将反转的头节点替换原链表的指针
            temp.next = reverseHead.next;
            //将当前的节点给反转的头节点
            reverseHead.next = temp;
            //

            temp = next;
        }
        head.next = reverseHead.next;
        list();
    }

    public void foreachReverse(){
        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode temp = head.next;
        while (temp!=null){
            heroNodeStack.push(temp);
            temp = temp.next;
        }

        while ((heroNodeStack.size() > 0)) {
            System.out.println(heroNodeStack.pop());
        }
    }

    public void mergeList(HeroNode heroNode1,HeroNode heroNode2){
        if (heroNode1.next == null && heroNode2.next == null) {
            return;
        }
        HeroNode tempNode = new HeroNode(0, "", "");
        HeroNode temp1 = heroNode1.next;
        HeroNode temp2 = heroNode2.next;
        while (temp1 != null){
            if (temp1.no > tempNode.no){
                tempNode.next = temp1;
            }
            temp1 = temp1.next;
        }
        while (temp2 != null){
            if (temp2.no > tempNode.no){
                tempNode.next = temp2;
            }
            temp2 = temp2.next;
        }
        tempNode = tempNode.next;
        while (tempNode.next != null){
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }

}
