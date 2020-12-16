package io.dsub.blog.api.user;

import io.dsub.blog.common.entity.enums.UserType;
import io.dsub.blog.common.entity.user.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserCommand {
    @Data
    @Builder
    public static class CreateUser {
        @NotNull
        private UserType userType;
        @Email
        private String email;
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;
        @NotBlank
        private String nickname;
        @NotBlank
        private String password;
        @NotBlank
        private String address;

        public User toUser() {
            return User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .nickname(nickname)
                    .password(password)
                    .address(address)
                    .userType(userType)
                    .build();
        }
    }

    @Data
    @Builder
    public static class UpdateUser {
        @Email
        private String email;
        private String firstName;
        private String lastName;
        private String nickname;
        private String address;

        public User toUser() {
            return User.builder()
                    .email(email)
                    .firstName(firstName)
                    .lastName(lastName)
                    .nickname(nickname)
                    .address(address)
                    .build();
        }
    }
}
