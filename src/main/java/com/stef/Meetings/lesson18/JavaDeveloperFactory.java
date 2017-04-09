package com.stef.Meetings.lesson18;

public class JavaDeveloperFactory implements IDeveloperFactory {
    public IDeveloper creatDeveloper() {
        return new JavaDeveloper();
    }
}
