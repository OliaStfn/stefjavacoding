package com.stef.Meetings.lesson25;

public class Finder<T extends Comparable<T>> implements MinMax<T> {
    T[] values;

    public Finder(T[] values) {
        this.values = values;
    }

    public T min() {
        T temp= values[0];

        for (int i = 0; i <values.length ; i++) {
            if(values[i].compareTo(temp)<0) temp = values[i];
        }
        return temp;
    }

    public T max() {
        T temp= values[0];

        for (int i = 0; i <values.length ; i++) {
            if(values[i].compareTo(temp)>0) temp = values[i];
        }
        return temp;
    }
}
