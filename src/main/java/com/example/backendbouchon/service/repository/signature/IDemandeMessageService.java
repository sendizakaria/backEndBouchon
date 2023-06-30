package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.DemandeMessageTO;

import java.util.List;

public interface IDemandeMessageService {

    List<DemandeMessageTO> getAllDemandeMessage();
    DemandeMessageTO getDemandeMessageByname(String DemandeMessageName);
    DemandeMessageTO getDemandeMessageById(Long id);

    void saveDemandeMessage(DemandeMessageTO DemandeMessageTO);


    void deleteAllDemandeMessage();
}
