package io.dsub.blog.api.user;

import io.dsub.blog.api.exception.EmailAlreadyExistsException;
import io.dsub.blog.api.exception.NoChangesFoundException;
import io.dsub.blog.api.exception.UserNotFoundException;
import io.dsub.blog.common.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleUserService implements UserService{

    private final UserRepository userRepository;
    
    private static final String USER_NOT_FOUND_STRING = "user with email %s not found";

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
        throw new UserNotFoundException(String.format(USER_NOT_FOUND_STRING, requestedEmail), HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDto updateUser(UserCommand.UpdateUser updatedUser) throws NoChangesFoundException, UserNotFoundException, EmailAlreadyExistsException {
        if (!userRepository.existsByEmail(updatedUser.getOldEmail())) {
            throw new UserNotFoundException(
                    String.format(USER_NOT_FOUND_STRING, updatedUser.getOldEmail()), HttpStatus.BAD_REQUEST);
        }

        User updatedUserEntity = userRepository.findByEmail(updatedUser.getOldEmail())
                .update(updatedUser.toUser());

        return UserDto.fromUser(userRepository.save(updatedUserEntity));
    }

    @Override
    public String deleteUser(String email) throws UserNotFoundException {
        if (userRepository.existsByEmail(email)) {
            userRepository.deleteByEmail(email);
            return "user " + email + " successfully deleted";
        }
        throw new UserNotFoundException(String.format(USER_NOT_FOUND_STRING, email), HttpStatus.BAD_REQUEST);
    }

//    // TODO: IMPLEMENT
//    public UserDto updateUserEmail(String email) throws EmailAlreadyExistsException{
//        if (!userRepository.existsByEmail(email)) {
//            userRepository.updateByEmail(email);
//            return UserDto.fromUser(userRepository.save(email));
//        }
//        String reason = "user " + email + " already exists";
//        throw new EmailAlreadyExistsException(reason, HttpStatus.BAD_REQUEST);
//    }
}
