package io.dsub.blog.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String ddd(){return "WORKS";}

    // POST localhost:0000/

    @PostMapping
    public UserDto signUp(@RequestBody UserCommand.CreateUser command) {
        return userService.signUp(command.toUser());
    }

    @GetMapping("/{email}")
    public UserDto getUser(@PathVariable(name = "email") String requestedEmail) {
        return userService.getUserByEmail(requestedEmail);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody @Valid UserCommand.UpdateUser command) {
        return userService.updateUser(command);
    }

    @DeleteMapping
    public String deleteUser(@RequestBody Map<String, String> requestBody) {
        return userService.deleteUser(requestBody.get("email"));
    }

//    @PutMapping
//    public String updateUserEmail(@RequestBody @Valid UserCommand.UpdateUser command) {
//        return userService.updateUserEmail(command.toUser());
//    }
}
