package com.everis.digit.life;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFile {

    public static void main(String[] args) throws IOException {

        /**
         * Apache Commons
         */
        final List<String> strings = FileUtils.readLines(new File("file.txt"));

        /**
         * Guava
         */
        final List<String> lines =
            com.google.common.io.Files.readLines(new File("file.txt"), StandardCharsets.UTF_8);

        /**
         * Java 8
         * Let's count the words on each line
         */
        Files.lines(Paths.get("file.txt"))
            .map(line -> line.split(" ").length)
            .forEach(wordCount -> {
                System.out.println(wordCount);
            });
    }

}
