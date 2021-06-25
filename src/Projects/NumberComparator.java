package Projects;

public class NumberComparator {
    public static void filter(Integer number1, Integer number2) {
        if (number1 > number2)
            System.out.println(number1 + " is larger than " + number2);
        if (number1 < number2)
            System.out.println(number2 + " is larger than " + number1);
        else
            System.out.println("Both numbers are equal.");
    }
}
