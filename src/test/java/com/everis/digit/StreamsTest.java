package com.everis.digit;


import org.junit.Test;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsTest {

    @Test
    public void should_iterate_three_times() {
        // given
        final int counter = 3;
        // when
        OptionalInt collect = IntStream
            .range(0, 10)
            .map(i -> i + i)
            .reduce((left, right) -> Integer.reverse(Math.max(left, right)));
        // then

        System.out.println(collect);
    }

    private List<String> run(int i, IntFunction<String> function) {
        return IntStream.range(0, i)
            .mapToObj(function)
            .collect(Collectors.toList());
    }

}
