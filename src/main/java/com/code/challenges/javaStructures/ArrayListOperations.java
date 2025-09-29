package com.code.challenges.javaStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListOperations {

    static void main() {

        List<String> al = new ArrayList<>();

        // 1. Adding elements to ArrayList at the end
        al.add("Geeks");
        al.add("Geeks");
        al.add("Geeks2");
        al.add("Geeks3");
        al.add("Geeks4");
        al.add("Geeks5");

        // 2. Removing Element using index
        al.remove(0);
        al.remove("Geeks");

        // is empty
        al.isEmpty();

        // last Index
        al.lastIndexOf("Geeks2");
        al.size();

        // to Array
        Object[] objects = al.toArray();

        // create SubList
        List<String> s = al.subList(0, 1);

        //last index
        String str = "";

        //contains
        al.contains("Geeks5");

        //sort
        //al.sort( (a, b) -> { return -1 * a.compareTo(b); } );
        al.sort(Comparator.reverseOrder());
        //al.reversed();
        System.out.println(al);

    }
}
