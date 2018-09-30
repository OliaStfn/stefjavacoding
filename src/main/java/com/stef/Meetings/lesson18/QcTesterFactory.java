package com.stef.Meetings.lesson18;

public class QcTesterFactory implements ITesterFactory {
    public ITester createTester() {
        return new QcTester();
    }
}
