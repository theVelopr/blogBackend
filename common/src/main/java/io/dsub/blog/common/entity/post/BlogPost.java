package io.dsub.blog.common.entity.post;

import io.dsub.blog.common.entity.user.UserAccount;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
public class BlogPost extends Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne
    private UserAccount userAccount;
}
