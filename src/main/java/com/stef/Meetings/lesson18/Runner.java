package com.stef.Meetings.lesson18;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        /*
        DF - Developer Factory
         */

        ArrayList<ITeam> team = new ArrayList<ITeam>();
        int x = -1;
        Scanner in = new Scanner(System.in);
        String st;
        do {
            System.out.println("Who do you want to employ?(Tester,Developer or Manager) ");
            st = in.next();
            if (st.equalsIgnoreCase("manager")) {
                System.out.println("Which manager do you need?Team Manager or Project Manager? ");
                st = in.next();
                IManagerFactory MF = Factory.createManFactoryByType(st);
                team.add(MF.createManager());
            } else if (st.equalsIgnoreCase("developer")) {
                System.out.println("Which developer do you need?Java or C#?");
                st = in.next();
                IDeveloperFactory DF = Factory.createDevFactoryByType(st);
                team.add(DF.creatDeveloper());
            } else if (st.equalsIgnoreCase("tester")) {
                System.out.println("Which tester do you need?Qc or Qa?");
                st = in.next();
                ITesterFactory TF = Factory.createTestFactoryByType(st);
                team.add(TF.createTester());
            } else throw new RuntimeException(st + " is not defined");


            do {
                System.out.println("Add another employee?1- Yes, 0-Exit");
                x = in.nextInt();
            } while (x != 0 || x != 1);


        } while (x != 0);


    }
}
