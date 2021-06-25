package com.Owen.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo { // care about index of objects in collection
    public static void show() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a", "b", "c");
        System.out.println(list.subList(0,2));
        System.out.println(list);
    }
}
