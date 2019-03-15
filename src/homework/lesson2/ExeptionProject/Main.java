package homework.lesson2.ExeptionProject;

import java.util.Arrays;

/*
Практическое задание
        1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
        подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
        3 В методе main() вызвать полученный метод, обработать возможные исключения
        MySizeArrayException и MyArrayDataException и вывести результат расчета.
*/

public class Main {

    public static void main(String[] args) {
	// write your code here

        String[][] str = {
                {"0","0","0","0"},
                {"0","0","0","0","0"},
                {"0","0","0","0"},
                {"0","0","0"},
                {"0","0","0"}
        };
        tryCalcSum(str, "str");

        String[][] str1 = {
                {"5","0","0","0"},
                {"0","5","0","0"},
                {"0","0","5","0"},
                {"0","0","0","5"}
        };
        tryCalcSum(str1, "str1");

        String[][] str2 = {
                {"5","0","0","р"},
                {"0","5","0","0"},
                {"0","0","5","0"},
                {"0","0","0","5"}
        };
        tryCalcSum(str2, "str2");

    }

    public static void tryCalcSum(String[][] str, String name){
        System.out.println("Пытаемся рассчитать сумму элементов строкового массива " + name + ":");
        for (int i = 0; i < str.length; i++) {
            System.out.println(Arrays.toString(str[i]));
        }
        try {
            MyArray array = new MyArray(str);
            System.out.println("Сумма элементов массива " + name + " = " + array.calcSumOfElements());
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Сумму элементов массива " + name + " рассчитать невозможно");
        }
        System.out.println();
    }

}
