package com.everis.digit.date;

import com.everis.digit.api.users.UserNotFound;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class DateExamples {


    public static void main(String[] args) throws UserNotFound, ParseException {
        settingDatesValues();
        readingFromString();
    }


    private static void settingDatesValues() {
        /**
         * Java 1.0
         */
        Date date = new Date();
        date.setMonth(0);
        date.setYear(-123);
        date.setTime(12345678l);

        System.out.println("Date: " + date);
        long time = date.getTime();
        System.out.println("Date: " + time);

        /**
         * Java 1.1
         */
        Calendar calendar =
            Calendar.getInstance(Locale.ENGLISH);
        calendar.set(Calendar.MONTH, 13);

        System.out.println("Calendar: " + calendar);

        /**
         * Java 8
         */
        LocalDate dateTime = LocalDate.now();
        System.out.println("Current LocalDate (now): " + dateTime);

        LocalDate kTime = LocalDate.of(1963, 11, 22);
        System.out.println("Manually set LocalDate: " + kTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current LocalDateTime (now): " + localDateTime);

        long longTime = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("Long value: " + longTime);


        // What happens when we set a negative value here!?
        LocalDateTime negativeYear = LocalDateTime.of(-123, 11, 22,
            12, 30, 00);
        // A: it is set as-is, this is not perfect, but at least is consistent and easy to track when issues appear in production
        System.out.println("Just set the value as-is: " + negativeYear);


        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);

        LocalDateTime localDateTime2 = LocalDateTime.now(Clock.system(ZoneId.of(availableZoneIds.iterator().next())));
        System.out.println(localDateTime2);
    }


    private static void readingFromString() throws ParseException {
        /**
         * Java 7
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Date date = dateFormat.parse("2018-01-30");
        System.out.println("This was obtained with a good-old SimpleDateFormat: " + date);

        /**
         * Java 8
         */
        ZonedDateTime parsedFromString = ZonedDateTime.parse("2018-07-12T13:30:30+01:00");
        System.out.println("This was obtained with the default format:" + parsedFromString);
    }

}
