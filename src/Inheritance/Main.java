package Inheritance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main (String[] arg) {
        Map<Integer, String> map = new HashMap<>();

        Thread thread1 = new Thread(() -> {
           map.put(1, "a");
        });

        Thread thread2 = new Thread(() -> {
            map.put(2, "b");
        });

        Thread thread3 = new Thread(() -> {
            map.put(3, "c");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
}


