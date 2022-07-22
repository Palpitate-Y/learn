package com.yzr;

import com.yzr.uitl.CircleLinkedList;
import com.yzr.uitl.DoublyLinkedList;

/**
 * @author Palpitate Yzr
 */
public class Test2 {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList=new DoublyLinkedList();
        doublyLinkedList.addFirst("1");
        doublyLinkedList.addLast("3");
        doublyLinkedList.addLast("6");
        doublyLinkedList.addFirst("0");
        System.out.println(doublyLinkedList.isEmpty());
        System.out.println(doublyLinkedList.toString());
        System.out.println(doublyLinkedList.reverseToString());
        CircleLinkedList circle=new CircleLinkedList();
        circle.add("1");
        circle.add("2");
        circle.add("0");
        System.out.println(circle.isEmpty());
        System.out.println(circle.toString());
    }
}
