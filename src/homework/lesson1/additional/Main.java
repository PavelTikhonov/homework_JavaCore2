package homework.lesson1.additional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner file = new Scanner(Paths.get("src/homework/lesson1/additional/text.txt"), "UTF8");
        ArrayList<String> text = new ArrayList<>();
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};
        int i = 0;
        while (file.hasNext()) {
            text.add(file.nextLine());
            System.out.println(text.get(i));
            i++;
        }
        text.remove(0);
        text.remove(0);
        int[] countVowels = new int[i - 2];
        System.out.println();

        i = 0;
        for (String line: text) {
            for (char ch : vowels) {
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == ch) {
                        countVowels[i]++;
                    }
                }
            }
            i++;
        }

        i = 1;
        for (int k: countVowels){
            System.out.println("Количество глассных букв в строке №" + (i++) + ":  " + k);
        }
    }
}
