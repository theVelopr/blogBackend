package io.dsub.blog.common.entity.comment;

import io.dsub.blog.common.entity.enums.CommenterType;
import io.dsub.blog.common.entity.post.BaseEntity;
import io.dsub.blog.common.entity.post.Post;
import io.dsub.blog.common.entity.user.User;
import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long text;

    private CommenterType commenterType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User commenterUser; // nullable

    private String commenterName;
    private String commentPassword;

    private boolean isDeleted;

    private boolean isRoot;

    @OneToMany(mappedBy = "parentComment") // lazy
    private List<Comment> childComment;

    @ManyToOne // eager
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
