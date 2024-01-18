package com.example.configsecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer userId;
    private  String username;
    private String password;
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)

    private List<Role> role;
}
