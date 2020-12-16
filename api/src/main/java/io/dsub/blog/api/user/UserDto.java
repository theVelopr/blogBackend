package io.dsub.blog.api.user;

import io.dsub.blog.common.entity.user.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;
    private String nickname;
    private String address;
    private LocalDateTime registeredAt;
    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .nickname(user.getNickname())
                .registeredAt(user.getCreatedAt())
                .address(user.getAddress())
                .build();
    }
}
