package com.wmc.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: WangMC
 * @date: 2020/5/24 20:56
 * @description:
 */
public class Graph {


    private final ArrayList<String> vertexList; //存储顶点集合
    private final int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目
    //定义给数组boolean[], 记录某个结点是否被访问
    private boolean[] isVisited;


    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }

    public static void main(String[] args) {


        String[] Vertexs = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(5);

        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        //显示一把邻结矩阵
        graph.showGraph();
        graph.dfs();
        System.out.println("\n--------------");
        graph.bfs();
    }


    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
    /**
     * 广度优先遍历算法
     *
     * @param isVisited 是否被访问过
     * @param i         第几个顶点
     */
    private void bfs(boolean[] isVisited, int i) {
        int u; // 表示队列的头结点对应下标
        int w; // 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        //当队列非空时，继续执行，否则算法结束。
        while (queue.isEmpty()) {
            //出队列，取得队头结点u。
            u = queue.removeFirst();
            //查找结点u 的第一个邻接结点w。
            w = getFirstNeighbor(u);
            while (w != -1) {
                //若结点w 尚未被访问，则访问结点w 并标记为已访问。
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    //结点w 入队列
                    queue.addLast(w);
                    //查找结点u 的继w 邻接结点后的下一个邻接结点w，
                }
                w = getNextNeighbor(u, w); //体现出我们的广度优先
            }
        }

    }

    /**
     * 深度优先遍历算法
     *
     * @param isVisited 是否被访问过
     * @param i         第几个顶点
     */
    private void dfs(boolean[] isVisited, int i) {

        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "->");

        //将结点设置为已经访问
        isVisited[i] = true;

        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);

        while (w != -1) {
            //说明有下一个邻节点 可以访问
            if (!isVisited[w]) {
                //如果改节点没被访问过
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //图中常用的方法
    //返回结点的个数
    private int getNumOfVertex() {
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1 前一个邻接点的下标
     * @param v2
     * @return
     */
    private int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 得到第i个邻接结点的下标 w
     *
     * @param i
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    private int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private String getValueByIndex(int i) {

        return vertexList.get(i);
    }


    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标即使第几个顶点"A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
