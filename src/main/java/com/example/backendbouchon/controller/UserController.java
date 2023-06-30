package com.example.backendbouchon.controller;

import com.example.backendbouchon.domaine.dto.UserTO;
import com.example.backendbouchon.service.repository.signature.IUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/gestion-utilisateurs")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getSimpleName());

    private IUserService userService;

    /**
     Injection par constructeur
     */
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Pour chercher tous les utilisateurs
     */
    @PostMapping(value = "/get-all-users", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<UserTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    /**
     * Pour recuperer l'utilisateur connecté
     */
    @PostMapping(value = "/user-by-name/{username}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserTO> getUserByUserName(@PathVariable(value = "username") String userByuserName) {
        return new ResponseEntity<>(userService.getUserByname(userByuserName), HttpStatus.OK);
    }

    /**
     * Pour supprimer un Utilisateur par son id
     */
    @DeleteMapping(value = "/delete-user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> deleteUserById(@PathVariable(name = "id") Long userId) {

        if (!userService.isUserExistsById(userId)) {
            LOGGER.log( Level.SEVERE, "Cet utilisateur est inexistant");
            return new ResponseEntity<>("Cet utilisateur est inexistant", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

        userService.deleteUserByID(userId);
        LOGGER.log( Level.INFO, String.format("Votre utilisateur %s est crée avec succés",userId));

        return new ResponseEntity<>(HttpStatus.OK);
    }




}
