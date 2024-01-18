package com.example.model.usermodel;

import com.example.configsecurity.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequist {

    private String username;
    private String password;
    private Role role;
}
