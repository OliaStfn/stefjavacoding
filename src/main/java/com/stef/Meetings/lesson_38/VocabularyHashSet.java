package com.stef.Meetings.lesson_38;

import java.io.*;
import java.util.*;

public class VocabularyHashSet {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> words = new TreeSet<String>();
        long totalTime = 0;

        String inputData = loadBook("./src/main/java/com/stef/Meetings/lesson_38/book.txt");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long spentTime = System.currentTimeMillis();
                words.add(word);
                spentTime = System.currentTimeMillis() - spentTime;
                //System.out.println(spentTime);
                totalTime += spentTime;
            }
        }

        Iterator<String> stringIterator=words.iterator();
        for (int i = 1; i <= 10 && stringIterator.hasNext(); i++) {
            System.out.println(stringIterator.next());
        }
        System.out.println("Quantity of words in collection: "+words.size());
        System.out.println("Total time: "+totalTime);
    }

    public static String loadBook(String path) throws FileNotFoundException {
        StringBuilder line = new StringBuilder();
        File file = new File(path);
        try {
            BufferedReader inputData = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String temp;
                while ((temp = inputData.readLine()) != null) {
                    line.append(temp);
                    line.append("\n");
                }
            } finally {
                inputData.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.toString();
    }
}
