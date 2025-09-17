package com.code.challenges.innerClasses;

public class OutterClassAccess {

    public static void main(String[] args) {

        // Call Inner Clas Non-Static
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass inner = outerClass.new InnerClass();
        inner.greetings();

        // Call Inner Clas Static Calling a Non-Static Method
        OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
        staticInner.giveMeYourAge();

        // Call Inner Clas Static Calling a Static Method
        OuterClass.StaticInnerClass.giveMeYourLastName();
    }
}
