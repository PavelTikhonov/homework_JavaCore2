package homework.lesson3.main;

/*Практическое задание
        1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
        вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово.
        2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
        добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
        учесть, что под одной фамилией может быть несколько телефонов (в случае
        однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
        Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
        взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
        результатов проверки телефонного справочника.*/

import java.util.*;

public class Part1Main {
    public static void main(String[] args) {
        // write your code here

        ArrayList<String> words = new ArrayList<>();
        TreeMap<String, Integer> uniqueWords = new TreeMap<>();
        int countWords = 1;

        words.add("Фродо");
        words.add("Бильбо");
        words.add("Гэндальф");
        words.add("Арагорн");
        words.add("Галадриэль");
        words.add("Фродо");
        words.add("Саруман");
        words.add("Фродо");
        words.add("Гэндальф");
        words.add("Гимли");
        words.add("Арагорн");
        words.add("Фродо");

        Collections.sort(words);
        System.out.println("Массив слов:");
        System.out.println(words.toString());
        for(int i = 0; i < words.size() - 1; i++){
            if(words.get(i).equals(words.get(i + 1))){
                countWords++;
                uniqueWords.put(words.get(i).toString(), countWords);
            } else {
                uniqueWords.put(words.get(i).toString(), countWords);
                countWords = 1;
            }
        }
        for (Map.Entry<String, Integer> o : uniqueWords.entrySet()) {
            System.out.println("Уникальное слово: "  + "\"" + o.getKey() + "\"" +
                    ", количество его дубликатов: " + o.getValue());
        };
    }
}