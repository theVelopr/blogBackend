package io.dsub.blog.common.entity.post;

import io.dsub.blog.common.entity.comment.Comment;
import io.dsub.blog.common.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Post extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> rootComments;
}
