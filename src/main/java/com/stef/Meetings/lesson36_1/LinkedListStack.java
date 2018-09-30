package com.stef.Meetings.lesson36_1;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class LinkedListStack<T> extends AbstractSequentialList {

    private class Node {
        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    private Node first;
    private int size;

    public boolean isEmpty() {
        return first==null;
    }


    public T pop() {
        while (!isEmpty()) {
            Node tempElement = first;
            first = first.next;
            return tempElement.item;
        }
        return null;
    }

    public void push(T item){
        Node n = new Node(item);
        n.next = first;
        first = n;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
