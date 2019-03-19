package homework.lesson3.main;

public class Part2Main {
    public static void main(String[] args) {
        PhoneBook phones = new PhoneBook("Друзья");
        phones.add(253635, "Пушкин");
        phones.add(355655, "Лермонтов");
        phones.add(422233, "Блок");
        phones.add(513222, "Пушкин");
        phones.add(613222, "Ахматова");

        phones.get("Тютчев");
        phones.get("Пушкин");
        phones.get("Блок");
    }
}
