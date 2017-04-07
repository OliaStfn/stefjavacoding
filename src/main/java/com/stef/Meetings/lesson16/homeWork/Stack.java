package com.stef.Meetings.lesson16.homeWork;

public class Stack implements IntfStack{
    private Account[] arr;
    private  int top;
    private int size;

    public Stack(int size) {
        top=-1;
        this.size = size;
        arr= new Account[size];
    }

    public void push(Account item) {
    arr[++top]= item;
    }

    public Account pop() {
        return arr[top--];
    }

    public Account top() {
        return arr[top];
    }

    public int isEmpty()
    {
        if(top==-1)
        return 0;
    }

    public int isFull() {
        if (top >= size - 1) {
            return 1;
        }

    }
}
