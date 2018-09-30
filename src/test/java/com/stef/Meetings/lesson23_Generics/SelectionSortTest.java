package com.stef.Meetings.lesson23_Generics;

import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void selectionSort() throws Exception {
        Integer[] arr = {5, 3, 8, 6, 1, 4, 2, 7, 9};
        Double[] array = {9.3, 1.75, 8.96, 2.14, 7.7, 3.55, 6.58, 4.2, 5.7};

        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (Double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        SelectionSort<Integer> obj = new SelectionSort<Integer>(arr);
        SelectionSort<Double> obj1 = new SelectionSort<Double>(array);

        arr = obj.selectionSort();
        array = obj1.selectionSort();

        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (Double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}