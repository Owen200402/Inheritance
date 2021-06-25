package Projects;

import java.util.Scanner;

public class PigLatin {
    public static void translator() {
        System.out.println("Entre a word that you want to translate to Pig Latin!");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        String pigLatin = word.substring(1) + word.substring(0,1) + "ay";
        System.out.println(word + " in Pig Latin is " + pigLatin);
    }
}
