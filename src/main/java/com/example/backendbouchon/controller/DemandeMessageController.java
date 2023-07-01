package com.example.backendbouchon.controller;

import com.example.backendbouchon.domaine.dto.DemandeMessageListTO;
import com.example.backendbouchon.domaine.dto.DemandeMessageTO;
import com.example.backendbouchon.domaine.dto.PieceJointeTO;
import com.example.backendbouchon.service.repository.signature.IDemandeMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
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
    @GetMapping(value = "/demande-messages", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<DemandeMessageListTO> getAllUserRoles() {
        DemandeMessageListTO demandeMessageListTOS = new DemandeMessageListTO();

        demandeMessageListTOS.setPayload(iDemandeMessageService.getAllDemandeMessage());

        return new ResponseEntity<>(demandeMessageListTOS, HttpStatus.OK);
    }


    @PostMapping(value ="/save-demande-messages" , consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> mergeUser(@RequestParam("message") String message,  @RequestPart("attachement") MultipartFile file){

        System.out.println("-----------------"+file.toString());

        //Map<String, List<InputPart>> uploadForm = file.getFormDataMap();
     //   iDemandeMessageService.createMessage(uploadForm);
        /*
      System.out.println("-----------------"+file.toString());


*/
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @PostMapping("/new3")
    public DemandeMessageTO uploadFile(@RequestParam(value = "message", required = false) String jsonObject,
    @RequestParam(value = "attachements", required = false) MultipartFile file) {
        DemandeMessageTO response = null;
        try {

            response = objectMapper(jsonObject);

            PieceJointeTO pieceJointeTO = new PieceJointeTO(file.getOriginalFilename(), file.getContentType(), file.getBytes());

            iDemandeMessageService.mergeUserIncludePicture(response,pieceJointeTO);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private DemandeMessageTO objectMapper(String messagData) throws JsonProcessingException {
        ObjectMapper objectMapper = getObjectMapper();
        DemandeMessageTO demandeMessageListTO = objectMapper.readValue(messagData, DemandeMessageTO.class);
        return demandeMessageListTO;
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper;
    }
}
