package com.example.configsecurity.resposetory;

import com.example.configsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleReposetory extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);

}
