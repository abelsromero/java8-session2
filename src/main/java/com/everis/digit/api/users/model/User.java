package com.everis.digit.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class User {

    private Integer id;
    private String name;
    private Sex sex;
    private Integer age;

    boolean isMale() {
        return sex.equals(Sex.M);
    }

    boolean isWomen() {
        return sex.equals(Sex.F);
    }

}
