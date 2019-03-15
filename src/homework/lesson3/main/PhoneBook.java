package homework.lesson3.main;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private String name;
    private HashMap<Integer, String> book = new HashMap<>();

    public PhoneBook(String name) {
        this.name = name;
    }

    public void add(int phone, String surname){
        book.put(phone, surname);
    }

    public void get(String surname){
        if (book.containsValue(surname)) {
            for (Map.Entry<Integer, String> o : book.entrySet()) {
                if (o.getValue() == surname) {
                    System.out.println(o.getValue() + ", номер телефона: " + o.getKey());
                }
            }
        } else {
            System.out.println("По запросу " + "\"" + surname + "\"" + " ничего не найдено");
        }
    }
}
