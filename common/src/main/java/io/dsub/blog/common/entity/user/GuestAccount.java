package io.dsub.blog.common.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GuestAccount extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
