package com.stef.Meetings.lesson_36_1;

public class LinkedListDeque<T> {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public LinkedListDeque() {
    }

}
