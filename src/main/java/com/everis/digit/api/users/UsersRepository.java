package com.everis.digit.api.users;

import com.everis.digit.api.users.model.Sex;
import com.everis.digit.api.users.model.User;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UsersRepository {

    static final Map<Integer, User> USERS;

    static {
        USERS = Arrays.asList
            (
                new User(1, "John", Sex.M, 42),
                new User(2, "Sarah", Sex.F, 8),
                new User(3, "Dan", Sex.M, 38),
                new User(4, "Jane", Sex.F, 22),
                new User(5, "Timmy", Sex.M, 10)
            )
            .stream()
            .collect(Collectors.toMap(u -> u.getId(), u -> u));
    }


    public Optional<User> getUser(Integer id) {
        final User user = USERS.get(id);
        // we know map.get returns null if key does not exist, so
        // just use `ofNullable` in case user is null
        return Optional.ofNullable(user);
    }

    private static String generateId() {
        return UUID.randomUUID().toString();
    }
}
