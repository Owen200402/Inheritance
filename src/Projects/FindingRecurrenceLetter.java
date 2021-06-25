package Projects;

import java.util.ArrayList;

public class FindingRecurrenceLetter { // Google coding interview question -- Finding the recursive character.

    public static Character filter(String givenCharacter) {
        ArrayList<Character> list = new ArrayList(); // declaring an arraylist to store characters in the for loop.
        String character = givenCharacter.toLowerCase(); // unify the letter case.

        for (int i = 0; i < character.length(); i++) { // a for loop that takes one character in a cycle.
            Character result = character.charAt(i);
            if(list.contains(result)) // if the result is repeated in the list, than print it out; if not, add it to the list.
                return result;
            else
                list.add(result);
        }
        return null; // if none of the letters repeat, return null
    }
}
