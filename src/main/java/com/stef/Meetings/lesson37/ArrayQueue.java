package com.stef.Meetings.lesson37;

public class ArrayQueue<T> {

    private int size;
    private int index = -1;
    private Object[] arrayqueue;

    public ArrayQueue(int size) {
        this.size = size;
        arrayqueue = new Object[size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return index < 0;
    }

    public void add(T item) {
        if (index < size - 1) {
            index++;
            arrayqueue[index] = item;
        }
    }

    public T remove() {
        if (!isEmpty()) {
            T temp = (T) arrayqueue[0];
            for (int i = 0; i < index && i < size - 1; i++) {
                arrayqueue[i] = arrayqueue[i + 1];
            }
            index--;
            return temp;
        }
        return null;
    }
}
