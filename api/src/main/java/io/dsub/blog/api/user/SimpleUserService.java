package io.dsub.blog.api.user;

import io.dsub.blog.api.exception.EmailAlreadyExistsException;
import io.dsub.blog.api.exception.NoChangesFoundException;
import io.dsub.blog.api.exception.UserNotFoundException;
import io.dsub.blog.common.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleUserService implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDto signUp(User user) throws EmailAlreadyExistsException {
        if (userRepository.existsByEmail(user.getEmail())) {
            String reason = "email " + user.getEmail() + " already exists";
            throw new EmailAlreadyExistsException(reason, HttpStatus.BAD_REQUEST);
        }
        return UserDto.fromUser(userRepository.save(user));
    }

    @Override
    public UserDto getUserByEmail(String requestedEmail) throws UserNotFoundException {
        if (userRepository.existsByEmail(requestedEmail)) {
            return UserDto.fromUser(userRepository.findByEmail(requestedEmail));
        }
        String reason = "user with email " + requestedEmail + " not found";
        throw new UserNotFoundException(reason, HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDto updateUser(User user) throws NoChangesFoundException {
        User oldUser = userRepository.findByEmail(user.getEmail());
        return UserDto.fromUser(userRepository.save(oldUser.update(user)));
    }

    @Override
    public String deleteUser(String email) throws UserNotFoundException {
        if (userRepository.existsByEmail(email)) {
            userRepository.deleteByEmail(email);
            return "user " + email + " successfully deleted";
        }
        String reason = "user with email " + email + " not found";
        throw new UserNotFoundException(reason, HttpStatus.BAD_REQUEST);
    }

    // TODO: IMPLEMENT
    public UserDto updateUserEmail(String email) {
        return null;
    }
}
