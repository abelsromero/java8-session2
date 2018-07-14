package com.everis.digit.api.users;

public class UserNotFound extends Exception {

    public UserNotFound() {
        super();
    }

    public UserNotFound(String id) {
        super(String.format("User with id %s does not exist", id));
    }

}
