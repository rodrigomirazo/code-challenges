package com.code.challenges.javaStructures;

import java.util.HashMap;
import java.util.stream.Collectors;

public class HasMaps {

    static void main() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "John");
        hashMap.put(2, "Alfred");
        hashMap.put(3, "Less");

        hashMap.get(1);
        hashMap.remove(1);

        hashMap.containsKey(2);

        hashMap.size();

        hashMap.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );

        hashMap.entrySet().stream().filter( entry -> entry.getKey() <= 2 )
                .map(k -> k.getValue()).toList();

        // Sort
        System.out.println(
            hashMap.entrySet().stream().sorted(
                    (o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                    .map(entry -> entry.getKey())
                    .toList()
        );

        hashMap.clear();
    }
}
