package lambdas;

import java.util.function.Function;

public class LambdasDemo {
    public static void show() {
        Function<String,Integer> function = str -> str.length();
        function.apply("Good");
    }
}
