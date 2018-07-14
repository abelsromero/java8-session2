package com.everis.digit.life;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.StringJoiner;

import static java.lang.String.join;

public class JoiningStrings {

    public static void main(String[] args) {

        apacheJoining();
        guavaJoining();
        java8Joining();
    }

    private static void guavaJoining() {

        final String join = Joiner.on(',')
            .join("first", "second", "third");
        System.out.println(join);
    }

    private static void java8Joining() {
        final String value = new StringJoiner(", ")
            .add("first")
            .add("second")
            .add("third")
            .toString();
        System.out.println(value);

        String join = join(", ", "first", "second", "third");
        System.out.println(join);
    }

    private static void apacheJoining() {

        final String join = StringUtils.join(new String[]{"first", "second", "third"}, ", ");
        System.out.println(join);
    }

}
