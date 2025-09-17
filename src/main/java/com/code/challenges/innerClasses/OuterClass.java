package com.code.challenges.innerClasses;

public class OuterClass {

    int age = 14;
    static String name = "::name::";

    public static class StaticInnerClass {
        int myAge = 21;
        static String myLastName = "Mirazo";

        public void giveMeYourAge() {
            System.out.println("My Age is " + myAge);
        }

        public static void giveMeYourLastName() {
            System.out.println("My lastname is " + myLastName);
        }

        class LocalInnerClass {

        }
    }

    class InnerClass {
        public String myName = "::name::";

        public void greetings() {
            System.out.println("hi my name is " + myName );
        }
    }
}
