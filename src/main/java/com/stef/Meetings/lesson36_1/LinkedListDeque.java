package com.stef.Meetings.lesson36_1;

public class LinkedListDeque<T> {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        T item;
        Node next;
        Node previous;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (!isNull(item)) {
            Node newFirst = new Node();
            newFirst.item = item;

            if (first != null) {
                newFirst.next = first;
                first.previous = newFirst;
            }
            first = newFirst;
            if (last == null) last = first;

            size++;
        }
    }

    public T removeFirst() {
        if (!isEmpty()) {
            Node oldFirst = first;
            first = first.next;

            if (first == null){
                last = null;
            }
            else
                first.previous = null;
            size--;

            return oldFirst.item;
        }
        return null;
    }

    public void addLast(T item) {
        if(!isNull(item)){
            Node newLast = new Node();
            newLast.item = item;

            if (last != null) {
                newLast.previous = last;
                last.next = newLast;
            }
            last = newLast;
            if (first == null) first = last;

            size++;
        }
    }

    public T removeLast() {
        if (!isEmpty()) {
            Node oldLast = last;
            last = oldLast.previous;

            if (last == null)
                first = null;
            else
                last.next = null;
            size--;
            return oldLast.item;
        }
        return null;
    }

    private boolean isNull(T item) {
        return (item == null);
    }
}
