package com.example.backendbouchon.controller;

import com.example.backendbouchon.domaine.dto.DemandeMessageListTO;
import com.example.backendbouchon.domaine.dto.DemandeMessageTO;
import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.service.repository.signature.IDemandeMessageService;
import com.example.backendbouchon.service.repository.signature.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/test")
public class DemandeMessageController {

    private static final Logger LOGGER = Logger.getLogger(DemandeMessageController.class.getSimpleName());

    private IDemandeMessageService iDemandeMessageService;

    /**
     Injection par constructeur
     */
    public DemandeMessageController(IDemandeMessageService iDemandeMessageService) {
        this.iDemandeMessageService = iDemandeMessageService;
    }

    /**
     * Pour chercher tous les utilisateurs
     */
    @GetMapping(value = "/demandemessages", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<DemandeMessageListTO> getAllUserRoles() {
        DemandeMessageListTO demandeMessageListTOS = new DemandeMessageListTO();

        demandeMessageListTOS.setPayload(iDemandeMessageService.getAllDemandeMessage());

        return new ResponseEntity<>(demandeMessageListTOS, HttpStatus.OK);
    }


}
