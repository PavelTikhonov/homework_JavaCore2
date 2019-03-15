package homework.lesson3.additional;

/*1 Обязательно есть хоть 1 цифра
  2 Не менее 8 символов и не более 20
  3 Должны быть большие и маленькие буквы
  4 Обязательно дожен быть спец символ*/

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMain {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите пароль:");
            String password = in.nextLine();
            System.out.println(password);

            if (validationPart1(password)){
                if (validationPart2(password)){
                    if (validationPart3(password)){
                        if (validationPart4(password)){
                            System.out.println("Пароль корректен");
                            break;
                        } else {
                            System.out.println("Обязательно дожен быть спец символ");
                        }
                    } else {
                        System.out.println("Обязательно должны быть большие и маленькие буквы");
                    }
                } else {
                    System.out.println("Обязательно должно быть не менее 8 символов и не более 20");
                }
            } else {
                System.out.println("Обязательно должна быть хоть 1 цифра");
            }
        }
    }
    public static boolean validationPart1(String password){
        Pattern p = Pattern.compile("^.*\\d.*$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean validationPart2(String password){
        Pattern p = Pattern.compile("^.{8,20}$");
        Matcher m = p.matcher(password);
        return m.matches();
    }
    public static boolean validationPart3(String password){
        Pattern p = Pattern.compile("(.*[a-z].*[A-Z].*)|(.*[A-Z].*[a-z].*)");
        Matcher m = p.matcher(password);
        return m.matches();
    }
    public static boolean validationPart4(String password){
        Pattern p = Pattern.compile("^.*[\\S&&[\\W_]]{1,}.*$");
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
