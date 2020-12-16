package io.dsub.blog.common.entity.post;

import io.dsub.blog.common.entity.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostContributor extends BaseEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
