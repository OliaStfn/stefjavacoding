package com.stef.Meetings.lesson_33.Homework36;

public class ArrayList<T> {
    private int size;
    private Object[] array;
    private int index = 0;

    public ArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }

    public void add(T item) {
        if (index == array.length - 1)
            resize(array.length *2);
        array[index] = item;
        index++;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i < this.index; i++)
            array[i] = array[i + 1];
        array[this.index] = null;
        this.index--;
    }

    public int size() {
        return index;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, index);
        array = newArray;
    }
}
