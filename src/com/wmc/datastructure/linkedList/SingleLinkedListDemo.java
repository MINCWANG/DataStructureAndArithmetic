package com.wmc.datastructure.linkedList;

/**
 * @author: WangMC
 * @date: 2019/12/16 16:47
 * @description:
 */
public class SingleLinkedListDemo {


    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(5, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(6, "林冲", "豹子头");

        HeroNode heroNode11 = new HeroNode(3, "宋江", "及时雨");
        HeroNode heroNode21 = new HeroNode(4, "卢俊义", "玉麒麟");
        HeroNode heroNode31 = new HeroNode(7, "吴用", "智多星");
        HeroNode heroNode41 = new HeroNode(8, "林冲", "豹子头");

        SingleLinkerList singleLinkedList = new SingleLinkerList();
        //加入
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        //加入按照编号的顺序
//        singleLinkedList.addByOrder(heroNode11);
//        singleLinkedList.addByOrder(heroNode21);
//        singleLinkedList.addByOrder(heroNode31);
//        singleLinkedList.addByOrder(heroNode41);
//        显示一把
        singleLinkedList.list();


        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况~~");
        singleLinkedList.list();

        //删除一个节点
//        singleLinkedList.del(1);
//        singleLinkedList.del(4);
//        System.out.println("删除后的链表情况~~");
//        singleLinkedList.list();

        int length = singleLinkedList.getLength();
        System.out.println("length: " + length);
//        HeroNode lastIndexNode = singleLinkedList.findLastIndexNode(3);
//        System.out.println(lastIndexNode);
        singleLinkedList.reverseList();
//        singleLinkedList.foreachReverse();

//        singleLinkedList.mergeList(heroNode1,heroNode11);
    }
}
