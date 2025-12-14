package com.code.challenges.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class LambdaCollectionSort {

    static void main() {

        Person person1 = new Person("name1", "Company1", 34);
        Person person2 = new Person("name2", "Company1", 45);
        Person person3 = new Person("nameA", "Company2",  23);
        Person person4 = new Person("name4", "Company3", 41);
        Person person5 = new Person("name5", "Company3", 32);

        List<Person> list1 = new ArrayList<>();
        list1.add(person1);
        list1.add(person2);
        list1.add(person3);
        list1.add(person4);
        list1.add(person5);

        // Sort:
        list1.stream().sorted( (a, b )-> a.getAge() - b.getAge() ).toList();
        List companySortedList = list1.stream().sorted( (a, b )-> a.getCompany().compareTo(b.getCompany())).collect(Collectors.toList());
        List ageSortedList = list1.stream().sorted(Comparator.comparingInt(Person::getAge)).toList();
        List dafaultSortedList = list1.stream().sorted().toList();

        System.out.println("\nAge Sorted");
        ageSortedList.forEach( p -> System.out.println(p.toString()));

        System.out.println("\nDefault Sorted");
        dafaultSortedList.forEach( p -> System.out.println(p.toString()));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    private static class Person implements Comparable<Person> {
        String name;
        String company;
        int age;

        @Override
        public int compareTo(Person person) {
            return this.name.compareTo(person.name);
        }
    }
}
