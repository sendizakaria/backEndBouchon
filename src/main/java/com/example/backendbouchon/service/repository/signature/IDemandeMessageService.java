package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.DemandeMessageTO;
import com.example.backendbouchon.domaine.dto.PieceJointeTO;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import java.util.List;
import java.util.Map;

public interface IDemandeMessageService {

    List<DemandeMessageTO> getAllDemandeMessage();
    DemandeMessageTO getDemandeMessageByname(String DemandeMessageName);
    DemandeMessageTO getDemandeMessageById(Long id);

    void saveDemandeMessage(DemandeMessageTO DemandeMessageTO);


    void deleteAllDemandeMessage();

    DemandeMessageTO mergeUserIncludePicture(DemandeMessageTO demandeMessageTO, PieceJointeTO pieceJointeTO);

}
