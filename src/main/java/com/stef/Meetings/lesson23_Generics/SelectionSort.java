package com.stef.Meetings.lesson23_Generics;


public class SelectionSort<T extends Number> {
    private int indexMin;
    private int size;
    private T temp;
    private T[] arr;

    public SelectionSort(T[] arr) {
        this.arr = arr;
        indexMin = 0;
        size = arr.length;
    }

    public T[] selectionSort() {
        for (int index = 0; index < size - 1; index++) {
            indexMin = index;
            for (int i = index + 1; i < size; i++) {
                if (arr[i].doubleValue() < arr[indexMin].doubleValue()) {
                    indexMin = i;
                }
            }

            temp = arr[indexMin];
            arr[indexMin] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }
}
