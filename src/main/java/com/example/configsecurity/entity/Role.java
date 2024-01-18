package com.example.configsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @Column(nullable =false)
    private String name;



}
