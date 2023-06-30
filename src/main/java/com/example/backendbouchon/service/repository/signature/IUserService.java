package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.UserTO;

import java.util.List;

public interface IUserService {

    List<UserTO> getAllUsers();
    UserTO getUserByname(String username);
    UserTO getUserById(Long id);

    void saveUser(UserTO userTO);
    void deleteUserByID(Long id);
    void deleteAllUsers();

    boolean isUserExistsByUserName(String username);
    boolean isUserExistsById(Long id);

}
