package lesson2队列;

import lesson2队列.exception.EmptyQueueException;
import lesson2队列.exception.FullQueueException;

import java.util.Arrays;

/**
 * @author Palpitate Yzr
 */
public class CirCleArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private String[] elementData;
    /**
     * 初始化
     *
     * @param queueSize 队列长度
     */
    public CirCleArrayQueue(int queueSize) {
        if (queueSize <= 0) throw new IllegalArgumentException("队列长度值不合理");
        this.maxSize = queueSize;
        this.elementData = new String[queueSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    private boolean isEmpty() {
        return this.front == this.rear;
    }

    public void add(String element) {
        if (this.isFull()) throw new FullQueueException("队列已满");
        this.elementData[this.rear] = element;
        this.rear = (this.rear + 1) % this.maxSize;
    }

    public String get() {
        if (this.isEmpty()) throw new EmptyQueueException("队列已空");
        String res = this.elementData[this.front];
        this.elementData[this.front] = null;
        this.front = (this.front + 1) % maxSize;
        return res;
    }

    public int elementsCount() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        int lastIndex = this.front + this.elementsCount();
        StringBuilder res = new StringBuilder("[");
        for (int i = this.front; ; i++) {
            res.append(this.elementData[i % this.maxSize]);
            if (i == lastIndex - 1) return res.append("]").toString();
            res.append(",");
        }
    }
}

