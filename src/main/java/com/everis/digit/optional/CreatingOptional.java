package com.everis.digit.optional;

import com.everis.digit.api.users.UserNotFound;
import com.everis.digit.api.users.model.Sex;
import com.everis.digit.api.users.model.User;

import java.util.Optional;

public class CreatingOptional {


    public static void main(String[] args) throws UserNotFound {

        final User user = new User(1, "Gandalf", Sex.M, 12);
        final User nullUser = null;

        /**
         * Use `of` when you are sure the instance is not null.
         */
        Optional<User> op = Optional.of(user);

        /**
         * Otherwise, or in doubt, use `ofNullable`.
         */
        Optional<User> emptyOptional = Optional.ofNullable(nullUser);
    }

}
