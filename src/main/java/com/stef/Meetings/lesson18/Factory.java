package com.stef.Meetings.lesson18;

public class Factory {
    public static IDeveloperFactory creatDevFactoryByType(String str) {
        if (str.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (str.equalsIgnoreCase("c#") || str.equalsIgnoreCase("csharp"))
            return new CsharpDeveloperFacrory();
        else throw new RuntimeException(str + " is not defined");
    }

    public static ITesterFactory creatTestFactoryByType(String str) {
        if (str.equalsIgnoreCase("qa")) {
            return new QaTesterFactory();
        } else if (str.equalsIgnoreCase("qc")) {
            return new QcTesterFactory();
        } else throw new RuntimeException(str + " is not defined");
    }
    public static IManagerFactory creatManFactoryByType(String str) {
        if (str.equalsIgnoreCase("project")) {
            return new ProjectManagerFactory();
        } else if (str.equalsIgnoreCase("team")) {
            return new TeamManagerFactory();
        } else throw new RuntimeException(str + " is not defined");
    }

}
