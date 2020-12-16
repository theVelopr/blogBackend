package io.dsub.blog.common.entity.post;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="post")
public class Post extends PostDetail{


    @Override
    public void Like() {

    }

    @Override
    public void Write() {

    }
}
