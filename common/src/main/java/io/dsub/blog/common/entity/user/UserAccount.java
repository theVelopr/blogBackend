package io.dsub.blog.common.entity.user;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class UserAccount extends User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
}
