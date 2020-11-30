package com.codeacademy.eshop.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    private String phone;

    private String avatar;
}
