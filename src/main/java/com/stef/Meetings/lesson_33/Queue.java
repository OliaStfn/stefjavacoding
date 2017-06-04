package com.stef.Meetings.lesson_33;

public interface Queue<T> {
    void add(T item);
    T remove();
    int size();
}
