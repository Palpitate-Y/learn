package com.yzr.uitl;

import com.yzr.exception.EmptyListException;

/**
 * 环形链表
 * @author Palpitate Yzr
 */
public class CircleLinkedList {
    /**
     * 起始节点
     */
    private Node first;

    /**
     *
     */
    public CircleLinkedList(){
        this.first=new Node();
        this.first.next=this.first;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return this.first.next==this.first;
    }

    public Node getLastNode(){
        Node res;
        for (res=this.first;res.next!=this.first;res=res.next);
        return res;
    }

    /**
     * 添加新元素
     * @param item
     */
    public void add(String item){
        Node lastNode = this.getLastNode();
        Node node = new Node(item, this.first);
        lastNode.next=node;
    }

    public int elementsCount(){
        int count=0;
        for (Node cur=this.first.next;cur.next!=this.first;cur=cur.next)
        {
            count++;
        }
        return count;
    }

    /**
     * 根据位置获取对应节点
     * @param index 参数
     * @return
     */
    private Node getIndexOfNode(int index){
        if (index<0||index>this.elementsCount()){
            throw new IndexOutOfBoundsException();
        }
        Node res = this.first;
        for (int i = 0; i < index; i++) {
            res=res.next;
        }
        return res;
    }

    /**
     *  出表
     * @param offset 偏移量
     * @param count 间距
     * @return 元素结果
     */
    public String[] get(int offset,int count){
        if (this.isEmpty()) throw new EmptyListException();
        int elementCounts=this.elementsCount();
        if (offset<0 || offset>=elementCounts){
            throw new IndexOutOfBoundsException();
        }
        String[] res=new String[elementCounts];
        Node indexOfNode = this.getIndexOfNode(offset);

    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder res=new StringBuilder("[");
        for (Node cur=this.first.next;;cur=cur.next){
            res.append(cur.item);
            if (cur.next==this.first) return res.append("]").toString();
            res.append(",");
        }
    }

    /**
     * 节点类
     */
    private static class Node{
        /**
         * 节点值
         */
        private String item;
        /**
         * 下一个节点
         */
        private Node next;

        public Node(){
        }
        public Node(String item,Node next){
            this.item=item;
            this.next=next;
        }
    }
}
