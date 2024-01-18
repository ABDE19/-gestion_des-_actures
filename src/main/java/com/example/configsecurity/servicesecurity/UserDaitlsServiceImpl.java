package com.example.configsecurity.servicesecurity;

import com.example.configsecurity.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserDaitlsServiceImpl implements UserDetailsService {
    @Autowired
    private AccontService accontService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =accontService.laodUserByUsername(username);
        if (userEntity==null)throw new UsernameNotFoundException(String.format("user %s not found",username));
        String [] role =userEntity.getRole().stream().map(u -> u.getName()).toArray(String[]::new);
//       List <SimpleGrantedAuthority>listSimpleGranteAuth= userEntity.getRole().stream().map(r->new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
        UserDetails userDetails= User.withUsername(username)
                .password(userEntity.getPassword())
                .authorities(role)
               .build();
        return userDetails;
    }
}
