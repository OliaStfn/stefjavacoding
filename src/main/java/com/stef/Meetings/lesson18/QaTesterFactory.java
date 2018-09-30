package com.stef.Meetings.lesson18;

public class QaTesterFactory implements ITesterFactory {
    public ITester createTester() {
        return new QaTester();
    }
}

