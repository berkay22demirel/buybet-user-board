package com.berkay22demirel.buybetuserboard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 16)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 4, max = 16)
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Pattern(message = "{buybet.validation.constraints.Pattern.phone.message}", regexp = "(^$|[0-9]{10})")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull
    @Size(min = 8, max = 32)
    @Pattern(message = "{buybet.validation.constraints.Pattern.password.message}", regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    @Column(name = "password", nullable = false)
    private String password;
}