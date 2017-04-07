package com.stef.Meetings.lesson16.homeWork;

public interface IntfStack {
    void push(Account item);
    Account pop();
    Account top();
    int isEmpty();
    int isFull();
}
