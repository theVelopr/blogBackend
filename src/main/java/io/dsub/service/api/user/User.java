package io.dsub.service.api.user;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

@Data
@Entity
@Mapping
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GetMapping
    private int id;

    @GetMapping
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    public User() {
    }

    public User(String password, String email, String address, String firstName, String lastName) {
        this.password = password;
        this.email = email;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
