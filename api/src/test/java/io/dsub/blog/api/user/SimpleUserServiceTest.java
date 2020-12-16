package io.dsub.blog.api.user;


import io.dsub.blog.common.entity.enums.UserType;
import io.dsub.blog.common.entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@DataJpaTest
class SimpleUserServiceTest {

    @Autowired
    SimpleUserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {

    }
//
//    @Test
//    void signUp() {
//        User user = User.builder()
//                .email("orange@man.com")
//                .address("hangang")
//                .firstName("first")
//                .lastName("last")
//                .nickname("orange")
//                .password("해킹즐")
//                .userType(UserType.USER)
//                .build();
//
//        UserDto resultDto = userService.signUp(user);
//
//        assertThat(resultDto.getEmail())
//                .isEqualTo(user.getEmail());
//        assertThat(resultDto.getAddress())
//                .isEqualTo(user.getAddress());
//        assertThat(resultDto.getFirstName())
//                .isEqualTo(user.getFirstName());
//        assertThat(resultDto.getLastName())
//                .isEqualTo(user.getLastName());
//        assertThat(resultDto.getNickname())
//                .isEqualTo(user.getNickname());
//    }

//    @Test
//    void getUserByEmail() {
//    }
//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void updateUserEmail() {
//    }
}
