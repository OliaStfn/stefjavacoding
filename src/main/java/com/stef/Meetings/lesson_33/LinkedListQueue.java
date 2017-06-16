package com.stef.Meetings.lesson_33;

public class LinkedListQueue<T> implements Queue<T> {

    private class Node {
        T item;
        Node next;
    }

    private Node last; // посилання на новий елемент в черзі
    private Node first; // посилання на старий елемент в черзі
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    @Override
    public T remove() {
        T nextElement = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        size--;
        return nextElement;
    }

    @Override
    public int size() {
        return size;
    }
}
