package com.wmc.datastructure.sparsearray;

/**
 * @author: WangMC
 * @date: 2019/11/30 15:40
 * @description: 数组队列
 * <p>
 * 优化:
 * 循环代码的复用
 * <p>
 * while（true）{  //code  }
 * <p>
 * 环形队列
 */
public class ArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 队列模拟
     */
    private int[] arr;

    /**
     * 使用maxSize创建队列
     *
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 判断队列是否满
     * result ：
     * true 满
     * false 未满
     * <p>
     * -1 -> 0  -> 1 ->
     * -> -1
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 给队列添加数据
     *
     * @param data
     */
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        //尾指针指向头指针
        if (rear + 1 % maxSize == 0) {
            rear = 0;
        }
        arr[rear] = data;
        System.out.println(arr[rear]);
        rear++;

    }

    /**
     * 出队列
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if ((rear + maxSize - front) % maxSize == 0) {
            throw new RuntimeException("队列头已到达尾部");
        } else {

            int temp =  arr[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    /**
     * 显示队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < front+size(); i++) {
            System.out.printf("arr[%d]=>%d \t", i, arr[i]);
        }
        System.out.println();
    }

    /**
     * 显示队列头
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }


    /**
     * 返回当前队列的有效大小
     *
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
