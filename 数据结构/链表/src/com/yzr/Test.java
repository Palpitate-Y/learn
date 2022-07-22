package com.yzr;

import com.yzr.uitl.SingleLinkedList;

/**
 * @author Palpitate Yzr
 */
public class Test {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.get());
        System.out.println(list.get());
        System.out.println(list.getElementsCount());
    }
}
