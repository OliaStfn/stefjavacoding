package com.stef.Meetings.lesson_33;

import java.util.Collection;

public interface Queue<T> {
    void add(T item);
    T remove();
    int size();
}
