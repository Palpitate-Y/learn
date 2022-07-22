package lesson2队列;

import lesson2队列.exception.EmptyQueueException;
import lesson2队列.exception.FullQueueException;

import java.util.Arrays;

/**
 * @author Palpitate Yzr
 */
public class ArrayQueue {
    //队列  先进先出、后进后出（排队依次通过） 可用链表或数组实现
    //栈   先进后出（像桶一样压在里面）

    /*
    入列 ：新的数据加入到队列中 加入到最后的位置
    出列： 数据离开队列 从头的位置离开
    front: 记录队列中第一个元素的位置 出列时front不断向后移动
    rear: 记录队列中最后一个元素的下一个位置 入列时rear不断向后移动
    */

    /**
     * 记录队列头的位置
     */
    private int front;
    /**
     * 记录队列尾（最后一个元素的下一个位置）
     */
    private int rear;
    /**
     * 数组长度
     */
    private int maxSize;
    /**
     * 存储值的数组
     */
    private String[] elementData;

    /**
     * 初始化
     *
     * @param queueSize 队列长度
     */
    public ArrayQueue(int queueSize) {
        if (queueSize <= 0) throw new IllegalArgumentException("队列长度值不合理");
        this.maxSize = queueSize;
        this.elementData = new String[queueSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 判断当前队列是否已经满了
     *
     * @return true:已满 false:未满
     */
    private boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    /**
     * 入列
     *
     * @param element 元素值
     */
    public void add(String element) {
        if (this.isFull()) throw new FullQueueException("队列已满，无法添加新的数据。");
        this.elementData[this.rear] = element;
        this.rear++;
    }

    /**
     * 出列
     *
     * @return 元素值
     */
    public String get() {
        if (this.isEmpty()) throw new EmptyQueueException("队列已经为空，无法进行出列");
        //return this.elementData[this.front ++];
        String res = this.elementData[this.front];
        this.elementData[this.front++] = null;
        return res;
    }


    /**
     * 判断队列是否为空
     *
     * @return true:为空 false:不为空
     */
    private boolean isEmpty() {
        return this.front == this.rear;
    }
    /**
     * 获取队列中数组长度
     * */
    public int queueLength(){
        return maxSize;
    }
    /**
     * 获取队列中元素数目
     * */
    public int elementsCount(){
        return this.rear-this.front;
    }
    /**
     * 查看第一个元素
     * */
    public String peekFirstElement(){
        return this.elementData[this.front];
    }


    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder res = new StringBuilder("[");
        for (int i = this.front; ; i++) {
            res.append(this.elementData[i]);
            if (i == this.rear - 1) return res.append("]").toString();
            res.append(",");
        }
    }

}
