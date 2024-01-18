package com.example.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name ="authorities" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {
    @Id
    private String username;
    private String authority;
}
