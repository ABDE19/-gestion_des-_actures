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
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private UserProfil userProfile;

    @ManyToMany(fetch = FetchType.EAGER)

    private List<Role> role;
}
