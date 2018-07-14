package com.everis.digit.optional;

import com.everis.digit.api.users.UserNotFound;
import com.everis.digit.api.users.model.Sex;
import com.everis.digit.api.users.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CheckingEmptyValuesWithOptional {


    public static void main(String[] args) throws UserNotFound {
        final User user = new User(1, "Gandalf", Sex.M, 12);
        final Optional<User> op = Optional.of(user);

        final User nullUser = null;
        final Optional<User> emptyOp = Optional.ofNullable(nullUser);

        /**
         * Here are some simple value checks
         */
        // instead of
        if (user != null) {
            System.out.println("Ugly and prone to errors null check: " + user);
        }

        // do
        if (op.isPresent()) {
            System.out.println("From a classical if: " + op.get());
        }
        //... or
        op.filter(u -> u.getAge() > 18)
            .ifPresent(u -> {
                System.out.println("From within a lambda: " + u);
            });


        op.ifPresent(user1 -> {

        });


        // retrieving the value without checking
        // BEWARE, if it was empty it would throw `NoSuchElementException` -> always use some `Else*` method.
        //   * orElse       -> returns the vale if present, if not present, returns a default value passed as parameter
        //   * orElseGet    -> returns the vale if present, if not present, returns a default value passed as a Provider (for dynamic logic)
        //   * orElseThrow  -> returns the vale if present, if not present, throws an exception

        /**
         * Here are some checks with additional business logic
         */
        // I think we are passed this and can do much better with Optional ;)
        if (user != null && user.getAge() > 18) {
            System.out.println(user.getAge());
        }

        // Let's get the information for a UI model map.
        // If no user matches the condition let's return an empty map
        final Map<String, Object> uiModel = op.filter(u -> u.getAge() > 18)
            .map(u -> {
                Map<String, Object> uiProperties = new HashMap<>();
                uiProperties.put("id", u.getId());
                uiProperties.put("name", u.getAge());
                uiProperties.put("age", u.getAge());

                return uiProperties;
            })
            .orElseGet(HashMap::new);
    }

}
