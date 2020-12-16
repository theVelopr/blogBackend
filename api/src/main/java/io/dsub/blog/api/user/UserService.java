package io.dsub.blog.api.user;

import io.dsub.blog.api.exception.EmailAlreadyExistsException;
import io.dsub.blog.api.exception.NoChangesFoundException;
import io.dsub.blog.api.exception.UserNotFoundException;
import io.dsub.blog.common.entity.user.User;

public interface UserService {
    UserDto signUp(User user) throws EmailAlreadyExistsException;

    UserDto getUserByEmail(String requestedEmail) throws UserNotFoundException;

    UserDto updateUser(User toUser) throws NoChangesFoundException;

    UserDto updateUserEmail(String email) throws EmailAlreadyExistsException;

    String deleteUser(String email) throws UserNotFoundException;
}
