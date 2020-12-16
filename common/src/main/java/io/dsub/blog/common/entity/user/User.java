package io.dsub.blog.common.entity.user;

import io.dsub.blog.common.entity.post.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class User extends BaseEntity {

    private String nickname;

    private String password;
}
