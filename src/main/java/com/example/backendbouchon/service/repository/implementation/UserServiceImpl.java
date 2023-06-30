package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.RoleRepository;
import com.example.backendbouchon.dao.UserRepository;
import com.example.backendbouchon.domaine.dto.UserTO;
import com.example.backendbouchon.domaine.mapper.UserMapper;
import com.example.backendbouchon.model.Role;
import com.example.backendbouchon.model.User;
import com.example.backendbouchon.service.exception.BusinessException;
import com.example.backendbouchon.service.repository.signature.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserMapper UserMapper;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserMapper UserMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.UserMapper = UserMapper;

    }

    @Override
    public void saveUser(UserTO userTO) {
        User user = UserMapper.toUserBO(userTO);
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            Role userRole = roleRepository.findByRole(role.getRole()).get(0);
            rolesPersist.add(userRole);
        }
        user.setRoles(rolesPersist);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<UserTO> getAllUsers() {
       return UserMapper.toListUserTO(userRepository.findAll());
    }

    @Override
    public boolean isUserExistsByUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isUserExistsById(Long userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public UserTO getUserByname(String username) {
        return Optional.ofNullable(UserMapper.toUserTO(userRepository.findByUsername(username)))
                        .orElseThrow(() -> new BusinessException("User Not Found with username: " + username));
    }

    @Override
    public UserTO getUserById(Long userId) {
        return Optional.ofNullable(userRepository.findById(userId))
                        .map(userFound -> UserMapper.toUserTOFromOptional(userFound))
                        .orElseThrow(() -> new BusinessException("User Not Found with Id: " + userId));
     }

    @Override
    public void deleteUserByID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}
