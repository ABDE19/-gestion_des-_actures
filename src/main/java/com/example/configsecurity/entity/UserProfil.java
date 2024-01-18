package com.example.configsecurity.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfil implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String avater;
    private String tele;
//    @OneToOne
//    private User user;
}
