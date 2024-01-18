package com.example.configsecurity.servicesecurity;


import com.example.configsecurity.entity.Role;
import com.example.configsecurity.entity.UserEntity;

public interface AccontService {

UserEntity addNewUser(String userName,String password,String email,String confirm);
Role addNewRole(String Role);
void  addRolToUser(String username,String role);
void removeROleFromUser(String username,String role);
UserEntity laodUserByUsername(String user);

}
