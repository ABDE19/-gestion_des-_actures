package com.example.configsecurity.servicesecurity;

import com.example.configsecurity.entity.Role;
import com.example.configsecurity.entity.UserEntity;
import com.example.configsecurity.resposetory.RoleReposetory;
import com.example.configsecurity.resposetory.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
 @AllArgsConstructor
public class AccontServiceImpl implements AccontService{
    private UserRepository userRepository;

    private RoleReposetory roleReposetory;
    private PasswordEncoder passwordEncoder;



    @Override
    public UserEntity addNewUser(String userName, String password, String email, String confirm) {
        UserEntity userEntity=userRepository.findByUsername(userName);

            if (userEntity!=null)throw new RuntimeException("this is a ready exist");

            if (!password.equals(confirm)) throw new RuntimeException("comfirm password incorected");

            UserEntity user = UserEntity.builder().
                        username(userName)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .build();
                UserEntity saved = userRepository.save(user);
                return saved;
//        }else {
//        throw new RuntimeException("confirm password error");
//        }
//        }else {
//            throw new RuntimeException("user a ready exist") ;

    }

    @Override
    public Role addNewRole(String role) throws RuntimeException {
        Role role1=roleReposetory.findByName(role).orElse(null);

//        if (role1!=null) throw new RuntimeException("role a ready exist");
if (role1==null) {
    Role role2 = Role.builder()
            .name(role)
            .build();


    return roleReposetory.save(role2);
}
return null;
    }

    @Override
    public void addRolToUser(String username, String role) {
        UserEntity userEntity = userRepository.findByUsername(username);


        Role role1 = roleReposetory.findByName(role).get();
        userEntity.getRole().add(role1);


    }
@Override
public void removeROleFromUser(String username, String role) {
    UserEntity userEntity=userRepository.findByUsername(username);

    Role role1=roleReposetory.findByName(role).get();
    userEntity.getRole().remove(role1);
    }

    @Override
    public UserEntity laodUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}




