package com.example.configsecurity.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable


public class RoleUser implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
