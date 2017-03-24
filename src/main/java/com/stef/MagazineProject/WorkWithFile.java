package com.stef.MagazineProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WorkWithFile {

    public FileInputStream testMethod1() {

        File file = new File("test.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read();
            throw new NullPointerException();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("Демонстрація NullPointerException");
            testMethod1();
        }
        finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileInputStream;
    }

    public static void main(String[] args) {
        WorkWithFile instance1 = new WorkWithFile();
        instance1.testMethod1();
    }
}
