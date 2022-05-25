package com.berkay22demirel.buybetuserboard.model;

import com.berkay22demirel.buybetuserboard.annotations.ImageValidation;
import com.berkay22demirel.buybetuserboard.constant.AuthorityRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 16)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 5, max = 50)
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Pattern(message = "{buybet.validation.constraints.Pattern.phone.message}", regexp = "(^$|[0-9]{10})")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull
    @Pattern(message = "{buybet.validation.constraints.Pattern.password.message}", regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,255}$")
    @Column(name = "password", nullable = false)
    private String password;

    @ImageValidation
    @Column(name = "image")
    private String image;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(AuthorityRole.getValues().toArray(new String[0]));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}