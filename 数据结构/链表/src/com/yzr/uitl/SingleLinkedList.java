package com.yzr.uitl;

import com.yzr.exception.EmptyListException;

/**
 * 单向链表类
 * @author Palpitate Yzr
 */
public class SingleLinkedList {
    /**
     * 存储起始节点
     */
    private Node first;

    /**
     * 初始化
     */
    public SingleLinkedList() {
        this.first=new Node();
    }

    /**
     * 从第一个节点开始遍历
     * 获取当前链表中最后一个节点（当前节点下一个元素为null）
     * @return 节点
     */
    public Node getLastNode(){
/*        Node lastNode=this.first;
        while (lastNode.next!=null){
            lastNode=lastNode.next;
        }*/
        Node lastNode;
        for (lastNode=this.first;lastNode.next!=null;lastNode=lastNode.next);
        return lastNode;
    }
    /**
     * 入列
     * 添加新的元素
     * @param item 添加元素值
     */
    public void add(String item){
        /*
        1.获取当前链表中最后一个有效节点
        2.将最后一个有效节点的next存储为新的节点
        * */
        Node lastNode = this.getLastNode();
        lastNode.next=new Node(item);
    }

    /**
     * 出列
     */
    public String get(){
        /*
        * 1.判断是否链表为空
        * 2.开始进行取值
        * */
        if (this.isEmpty()){
            throw new EmptyListException("链表为空，无法获取值");
        }
        //节点位置向后 拿出该节点 然后节点向后移动
        Node secondNode=this.first.next;
        //返回该节点get的内容
        String item=secondNode.item;
        //拿出的节点被废弃 之后将被回收
        //删除原first指针，让他移动到下一个位置，然后内容变为null代表被拿出
        this.first.next=null;
        this.first=secondNode;
        this.first.item=null;
        return item;
    }

    /**
     * 判断当前链表是否为空（无任何有效节点）
     * first.next=null
     * @return
     */
    public boolean isEmpty(){
        return this.first.next==null;
    }

    /**
     * 获取链表中有效值个数
     * @return 值的个数
     */
    public int getElementsCount(){
        int count=0;
        for (Node currentNode=this.first;currentNode.next!=null;currentNode=currentNode.next)
        count++;
        return count;
    }

    /**
     * 获取倒数第N个节点的值
     * @param lastIndex 倒数索引
     * @return 值
     */
    public String getLastIndexOf(int lastIndex){
        if (this.isEmpty()) throw new EmptyListException("链表为空");
        int elementsCount = this.getElementsCount();
        if (lastIndex<=0 || lastIndex>elementsCount)
            throw new IndexOutOfBoundsException("元素位置非法");

        int index=elementsCount-lastIndex+1;
        Node targetNode = this.first;
        for (int i = 0; i < index; i++) {
            targetNode=targetNode.next;
        }
        return targetNode.item;

    }
    public String reverseFormat(){
        if (this.isEmpty()) return "[]";
        String[] elementData = new String[this.getElementsCount()];
        int arrayIndex=0;
        for (Node currentNode=this.first.next;;currentNode=currentNode.next){
            elementData[arrayIndex++]= currentNode.item;
            if (currentNode.next==null) break;
        }
        StringBuilder res = new StringBuilder("[");
        for (int i=elementData.length-1;;i++) {
            res.append(elementData[i]);
            if (i==0) return res.append("]").toString();
            res.append(",");
        }
    }
    public void addAll(SingleLinkedList singleLinkedList){
        this.getLastNode().next=singleLinkedList.first.next;
    }


    @Override
    public String toString() {
       if (this.isEmpty()) return "[]";
        StringBuilder res = new StringBuilder("[");
    for (Node currentNode=this.first.next;;currentNode=currentNode.next){
        res.append(currentNode.item);
        if (currentNode.next==null) return res.append("]").toString();
        res.append(",");
    }
    }

    /**
     * 单项链表中的节点表
     */
    public static class Node {
        /**
         * 节点所存储的值
         */
        private String item;
        /**
         * 后置节点地址
         */
        private Node next;

        public Node() {
        }

        public Node(String item) {
            this.item = item;
        }

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
