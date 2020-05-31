package com.wmc.arithmetic.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: WangMC
 * @date: 2020/5/31 14:53
 * @description:
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();

        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        //取所有广播电台的交集
        for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
            allAreas.addAll(entry.getValue());
        }

        //创建ArrayList, 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();
        //定义一个临时的集合， 在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<String>();
        //定义给maxKey ， 保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey 不为null , 则会加入到selects
        String maxKey = null;
        while (allAreas.size() != 0) {
            // 如果allAreas 不为0, 则表示还没有覆盖到所有的地区
            //每进行一次while,需要
            maxKey = null;
            //如果allAreas 不为0, 则表示还没有覆盖到所有的地区
            for (String key : broadcasts.keySet()) {
                //每进行一次for
                tempSet.clear();
                //获取当前key对应的区域
                HashSet<String> areas = broadcasts.get(key);
                //放入tempSet保存起来
                tempSet.addAll(areas);
                //求出tempSet 和allAreas 集合的交集, 交集会赋给tempSet
                tempSet.retainAll(allAreas);

                //如果当前这个集合包含的未覆盖地区的数量，比maxKey 指向的集合地区还多
                //就需要重置maxKey
                //tempSet.size() > 0 有交集才可以进行往选择的区域里添加key
                // tempSet.size() >broadcasts.get(maxKey).size()) 体现出贪心算法的特点,每次都选择最优的
                //如果maxKey == null 代表第一次遍历，因此也要添加
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                //maxKey != null, 就应该将maxKey 加入selects
                selects.add(maxKey);
                //将maxKey 指向的广播电台覆盖的地区，从allAreas 去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println(selects);
    }
}
