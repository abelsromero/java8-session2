package com.everis.digit.api.users;

import com.everis.digit.api.users.model.User;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * This represents a service consumed by third party components.
 * For example a Rest endpoint.
 */
public class UsersService {

    private UsersRepository repository = new UsersRepository();

    public User getUser(final int id) throws UserNotFound {
        final Integer validId = sanitize(id);

        return repository.getUser(validId)
                .orElseThrow(() -> new UserNotFound(String.valueOf(id)));
    }

    private Integer sanitize(int id) {
        return id;
    }

}
