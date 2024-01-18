package com.example.configsecurity.resposetory;
//
import com.example.configsecurity.entity.UserEntity;
import com.example.enity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>  {
//
UserEntity findByUsername(String username);

}
