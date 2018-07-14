package com.everis.digit.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * This example shows how to extract method parameter names with the new `Parameter` class introduced in Java8.
 * How to test it:
 * 1. Run the method from your IDE.
 * You will see that the output says that the parameter names are `arg0` and `arg1`.
 * 2. Run the following command form terminal (Alt+F12 in IntelliJ) to compile and run the class with the new `-parameters` compile option.
 * $> mvn clean compile exec:java -Dexec.mainClass="com.everis.digit.reflection.ParametersChecker"
 * You will see now that the output show the parameter names as written in the source code.
 */
public class ParametersChecker {

    public static void main(String[] args) {
        final Method[] methods = ParametersChecker.class.getMethods();

        Arrays.stream(methods)
            .filter(m -> m.getName().equals("myCall"))
            .findFirst()
            .ifPresent(m -> {
                System.out.println("== Method " + m.getName());
                for (Parameter param : m.getParameters()) {
                    System.out.println("Parameter name: " + param.getName() + ", type: " + param.getType());
                }
            });

    }

    public void myCall(Integer someNumber, String aSimpleText) {
        System.out.println(someNumber);
        System.out.println(aSimpleText);
    }

}
