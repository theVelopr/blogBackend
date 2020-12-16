package io.dsub.blog.common.entity.user;

import io.dsub.blog.common.entity.enums.UserType;
import io.dsub.blog.common.entity.post.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String email;

    private String address;

    private String firstName;

    private String lastName;

    private String nickname;

    private String password;

    public User update(User that) {
        return User.builder()
                .id(id)
                .password(password)
                .userType(userType)
                .email(that.email)
                .firstName(that.firstName)
                .lastName(that.lastName)
                .nickname(that.nickname)
                .build();
    }
}
