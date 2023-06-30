package com.example.backendbouchon.service.userDetailService;


import com.example.backendbouchon.dao.UserRepository;
import com.example.backendbouchon.domaine.dto.UserTO;
import com.example.backendbouchon.domaine.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static UserRepository userRepository ;
    private static UserMapper userMapper;

    public UserDetailsServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserTO userTO = Optional.ofNullable(userMapper.toUserTO(userRepository.findByUsername(username)))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(userTO);
    }

}
