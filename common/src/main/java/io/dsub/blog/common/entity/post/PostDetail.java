package io.dsub.blog.common.entity.post;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="post_detail")
public abstract class PostDetail implements Writable, Likable{

    @Id
    private String postId;

    public PostDetail() {
    }

    public PostDetail(String postId) {
        this.postId = postId;
    }
}
