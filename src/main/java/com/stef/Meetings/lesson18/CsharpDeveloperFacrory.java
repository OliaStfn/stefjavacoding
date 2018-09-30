package com.stef.Meetings.lesson18;

public class CsharpDeveloperFacrory implements IDeveloperFactory {
    public IDeveloper creatDeveloper() {
        return new CsharpDeveloper();
    }
}
