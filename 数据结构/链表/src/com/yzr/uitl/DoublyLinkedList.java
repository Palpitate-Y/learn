package com.yzr.uitl;

import com.yzr.exception.EmptyListException;

/**
 * 双向链表
 *
 * @author Palpitate Yzr
 */
public class DoublyLinkedList {
    /**
     * 起始节点
     */
    private Node first;
    /**
     * 终止节点
     */
    private Node last;

    /**
     * 双向链表初始化
     */
    public DoublyLinkedList(){
        this.first=new Node();
        this.last=new Node(this.first,null,null);
        this.first.next=this.last;
    }

    /**
     * 判断当前双向链表中是否为空
     * @return true 空 false 非空
     */
    public boolean isEmpty(){
        return this.first.next==this.last && this.last.prev==this.first;
    }

    /**
     * 添加节点到尾部 尾插法
     * @param item 节点值
     */
    public void addLast(String item){
        Node node=new Node(this.last.prev,item,this.last);
        this.last.prev.next=node;
        this.last.prev=node;
    }

    /**
     * 头插法
     * @param item
     */
    public void addFirst(String item){
        Node node= new Node(this.first, item, this.first.next);
        this.first.next=node;
        node.next.prev=node;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder res=new StringBuilder("[");
        for (Node currentNode=this.first.next;;currentNode=currentNode.next){
            res.append(currentNode.item);
            if (currentNode.next==this.last) return res.append("]").toString();
            res.append(",");
        }
    }

    public String reverseToString() {
        if (this.isEmpty()) return "[]";
        StringBuilder res=new StringBuilder("[");
        for (Node currentNode=this.last.prev;;currentNode=currentNode.prev){
            res.append(currentNode.item);
            if (currentNode.prev==this.first) return res.append("]").toString();
            res.append(",");
        }
    }

    public int elementsCount(){
        int result=0;
        for (Node current=this.first.next;current.next!=this.last;current=current.next){
            result++;
        }
        return result;
    }

    /**
     * 获取对应位置索引节点
     * @param index
     * @return
     */
    private Node getIndexOfNode(int index){
        Node current=this.first.next;
        for (int i = 0; i < index; i++) {
            current=current.next;
        }
        return current;
    }

    /**
     * 获取指定位置元素值
     * 出表
     * @param index
     * @return
     */
    private String getByIndex(int index){
        if (this.isEmpty()) throw new EmptyListException("链表为空");
        if (index<0||index>=this.elementsCount()) {
            throw new IndexOutOfBoundsException("错误的索引："+index);
        }
        Node target = this.getIndexOfNode(index);
        target.prev.next=target.next;
        target.next.prev=target.prev;
        target.next=null;
        target.prev=null;
        return target.item;
    }

    /**
     * 双向链表的节点
     */
    private static class Node {
        /**
         * 前驱节点地址
         */
        private Node prev;
        /**
         * 节点值
         */
        private String item;
        /**
         * 后置节点地址
         */
        private Node next;
        /**
         * 初始化
         * @param prev
         * @param item
         * @param next
         */
        public Node(Node prev,String item,Node next){
            this.prev=prev;
            this.item=item;
            this.next=next;
        }
        public Node(){}

    }
//    private void reverseList(Node head){
//    Node end=null;
//    Node first=null;
//    while (head!=null){
//        Node next=head.next;
//        Node prev=head.prev;
//        head.next=end;
//        head.prev=first;
//        end=head;
//
//        head=next;
//
//    }
//    }


}
