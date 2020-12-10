package com.codeacademy.eshop.user.model;

import com.codeacademy.eshop.user.service.validator.LithuanianPhone;
import com.codeacademy.eshop.user.service.validator.LithuanianZip;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Size(min = 3, max = 200)
    private String username;

    @Column(nullable = false)
    @Size(min = 3)
    @NotBlank
    private String password;

    @LithuanianPhone
    private String phone;

    @LithuanianZip
    private String zip;

    private String avatar;

    @ManyToMany
    @JoinTable(
            name="User_Roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles;
}
