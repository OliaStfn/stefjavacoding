package com.stef.Meetings.lesson_39.Homework39;

import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.Client;
import com.stef.MagazineProject.mysql.MySQLDaoFactory;
import com.stef.Meetings.lesson_38.VocabularyHashSet;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ClientGenerator {
    private static GregorianCalendar calendar = new GregorianCalendar();
    private static Random random = new Random(calendar.getTimeInMillis());

    public static void main(String[] args) throws FileNotFoundException, DaoException {
        HashSet<Client> clients = new HashSet<>();
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter count of clients: ");
        int count = Integer.parseInt(in.next());

        while (count != clients.size()) {
            Client client = new Client();
            client.setName(readFile("name"));
            client.setSurname(readFile("surname"));
            client.setBornDate(new GregorianCalendar(random.nextInt(117) + 1900, random.nextInt(12),
                    random.nextInt(31)));
            String number = "+380";
            for (int i = 0; i < 9; i++) {
                number += random.nextInt(10);
            }
            client.setPhoneNumber(number);
            client.setAddress("вул. " + readFile("surname"));
            String login = "";
            for (int i = 0; i < random.nextInt(7) + 5; i++) {
                login += new Character((char) (random.nextInt(57) + 65)).toString();
            }
            client.setLogin(login);
            String pass = "";
            for (int i = 0; i < 8; i++) {
                pass += new Character((char) (random.nextInt(126))).toString();
            }
            client.setPassword(pass);
            clients.add((Client) dao.createInDB(client));
        }

    }

    public static String readFile(String str) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();

        String inputData = VocabularyHashSet.loadBook("./src/main/java/com/stef/Meetings/lesson_39/Homework39/" + str + ".txt");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                words.add(word);
            }
        }
        int index;

        do {
            index = random.nextInt();
        } while (index > words.size() - 1 || index < 0);
        return words.get(index);
    }
}
