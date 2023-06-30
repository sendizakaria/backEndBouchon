package com.example.backendbouchon.controller;

import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.service.repository.signature.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/demande-message")
public class TagController {

    private static final Logger LOGGER = Logger.getLogger(TagController.class.getSimpleName());

    private IRoleService iRoleService;

    /**
     Injection par constructeur
     */
    public TagController(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    /**
     * Pour chercher tous les utilisateurs
     */
    @PostMapping(value = "/get-all-roles", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<RoleTO>> getAllUserRoles() {
        return new ResponseEntity<>(iRoleService.getAllRoles(), HttpStatus.OK);
    }


}
