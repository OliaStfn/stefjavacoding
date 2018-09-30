package com.stef.Meetings.lesson_39;

import com.stef.Meetings.lesson33.Queue;

import java.util.*;

public class lesson_39 {
    public static void main(String[] args) {
        Deque someQueue = new ArrayDeque();
        PriorityQueue<GregorianCalendar> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new GregorianCalendar(2000, Calendar.OCTOBER, 10));
        priorityQueue.add(new GregorianCalendar(1995, Calendar.MAY, 1));
        priorityQueue.add(new GregorianCalendar(2017, Calendar.JUNE, 26));
        priorityQueue.add(new GregorianCalendar(1990, Calendar.MARCH, 8));
        for(GregorianCalendar date: priorityQueue){
            System.out.println(date.get(Calendar.YEAR));
        }
    }
}
