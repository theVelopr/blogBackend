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
                .password(this.password.equals(that.password) ? that.password : this.password)
                .userType(this.userType.equals(that.userType) ? that.userType : this.userType)
                .email(this.email.equals(that.email) ? that.email : this.email)
                .firstName(this.firstName.equals(that.firstName) ? that.firstName : this.firstName)
                .lastName(this.lastName.equals(that.lastName) ? that.lastName : this.lastName)
                .nickname(this.nickname.equals(that.nickname) ? that.nickname : this.nickname)
                .build();
    }
}
