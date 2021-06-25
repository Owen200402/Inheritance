package Projects;

import java.util.Scanner;

public class SumGame { // Waterloo 2017 question 1
    public static void sum() {
        Scanner scanner = new Scanner(System.in);
        int gameNum = scanner.nextInt();
        int swiftsScore;
        int semaScore;
        int[] array1 = new int[gameNum];
        int[] array2 = new int[gameNum];
        int max1 = 0;
        int max2 = 0;
        int largestNum = 0;

        if (1 <= gameNum && gameNum <= 100_000) { // make sure the first num is positive
            for (int i = 0; i < gameNum; i++) {
                swiftsScore = scanner.nextInt(); // according to the first input, decide how many inputs I need
                array1[i] = swiftsScore; // store the input in an array
            }

            for (int i = 0; i < gameNum; i++) { // another for loop for the second line of input
                semaScore = scanner.nextInt();
                array2[i] = semaScore;
            }
        }
        else
            return;

        for (int i = 0; i < array1.length; i++) { // iterate through all the scores to find the times when both teams get the same scores
            max1 = max1 + array1[i];
            max2 = max2 + array2[i];

            if (max1 == max2) {
                largestNum = i+1; // store the scores in the largestNum variable and update it automatically
            }
        }

        System.out.println(largestNum); // print out the largestNum after getting its largest value
        // if none of the sums of those scores are the same, print out 0
    }
}
