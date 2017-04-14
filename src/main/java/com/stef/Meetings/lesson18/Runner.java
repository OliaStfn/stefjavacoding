package com.stef.Meetings.lesson18;

public class Runner {
    public static void main(String[] args) {
        /*
        DF - Developer Factory
         */

        IDeveloperFactory DF = Factory.createDevFactoryByType("java");
        IDeveloper dev1 = DF.creatDeveloper();
        dev1.writeCode();

        ITesterFactory TF = Factory.createTestFactoryByType("qa");
        ITester ts1 = TF.createTester();
        ts1.testCode();

        IManagerFactory MF = Factory.createManFactoryByType("project");
        IManager mp1 = MF.createManager();
        mp1.creatTask();


    }
}
