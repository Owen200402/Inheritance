package Projects;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrangingBooks {
    public static void arrange() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        ArrayList<Character> characters = new ArrayList<>();
        char pointer = '\0';
        int count = 0;

        for (char letter: string.toCharArray()) {
            characters.add(letter);
        }

        // placing L
        for (int i = 0; i < characters.size(); i++) {
            char current = characters.get(i);

            // set the pointer to the first occurrence of the letter that is not L
            int j;
            for (j = 0; j < characters.size(); j++) {
                if (!characters.get(j).equals('L')) {
                    pointer = characters.get(j);
                    break;
                }
            }

            // swap process
            if (current == 'L' && pointer != '\0' && j < i) {
                characters.set(characters.indexOf(pointer), 'L');
                characters.set(i, pointer);
                count++;
            }
        }

        for (int i = 0; i < characters.size(); i++) {
            char current = characters.get(i);

            int j;
            for (j = 0; j < characters.size(); j++) {
                if (characters.get(j).equals('S')) {
                    pointer = characters.get(j);
                    break;
                }
            }

            if (current == 'M' && pointer != '\0' && j < i) {
                characters.set(characters.indexOf(pointer), 'M');
                characters.set(i, pointer);
                count++;
            }
        }
        System.out.println(count);
    }
}
