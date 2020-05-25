package com.wmc.datastructure.linkedList;

/**
 * @author: WangMC
 * @date: 2019/12/16 16:44
 * @description:
 */
public class HeroNode {


    public int no;

    public String name;

    public String nickName;

    /**
     * 指向下一个节点
     */
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }




}
