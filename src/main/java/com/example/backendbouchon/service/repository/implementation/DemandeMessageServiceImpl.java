package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.DemandeMessageRepository;
import com.example.backendbouchon.dao.PieceJointeRepository;
import com.example.backendbouchon.domaine.dto.DemandeMessageTO;
import com.example.backendbouchon.domaine.dto.PieceJointeTO;
import com.example.backendbouchon.domaine.mapper.DemandeMessageMapper;
import com.example.backendbouchon.domaine.mapper.PieceJointeMapper;
import com.example.backendbouchon.model.DemandeMessage;
import com.example.backendbouchon.model.PieceJointe;
import com.example.backendbouchon.service.repository.signature.IDemandeMessageService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DemandeMessageServiceImpl implements IDemandeMessageService {

    private DemandeMessageRepository demandeMessageRepository;
    private DemandeMessageMapper demandeMessageMapper;
    private PieceJointeMapper pieceJointeMapper;
    private PieceJointeRepository pieceJointeRepository;



    public static final String KEY_ATTACHEMENTS = "attachements";
    public static final String KEY_MESSAGE = "message";


    public DemandeMessageServiceImpl(DemandeMessageRepository demandeMessageRepository,
                                     DemandeMessageMapper demandeMessageMapper,
                                     PieceJointeMapper pieceJointeMapper,
                                     PieceJointeRepository pieceJointeRepository) {
        this.demandeMessageRepository = demandeMessageRepository;
        this.demandeMessageMapper = demandeMessageMapper;
        this.pieceJointeMapper = pieceJointeMapper;
        this.pieceJointeRepository = pieceJointeRepository;
    }

    @Override
    public List<DemandeMessageTO> getAllDemandeMessage() {
        return demandeMessageMapper.toListDemandeMessageTO(demandeMessageRepository.findAll());
    }

    @Override
    public DemandeMessageTO getDemandeMessageByname(String DemandeMessageName) {
        return null;
    }

    @Override
    public DemandeMessageTO getDemandeMessageById(Long id) {
        return null;
    }

    @Override
    public void saveDemandeMessage(DemandeMessageTO DemandeMessageTO) {
        demandeMessageRepository.save(demandeMessageMapper.toDemandeMessageBO(DemandeMessageTO));
    }

    @Override
    public void deleteAllDemandeMessage() {
        demandeMessageRepository.deleteAll();
    }

    @Override
    public DemandeMessageTO mergeUserIncludePicture(DemandeMessageTO demandeMessageTO, PieceJointeTO pieceJointeTO) {
        DemandeMessage message = demandeMessageMapper.toDemandeMessageBO(demandeMessageTO);
        PieceJointe pieceJointe = pieceJointeMapper.toPieceJointeBO(pieceJointeTO);

       PieceJointe pieceJointeFromDB = pieceJointeRepository.findPieceJointesByMessageId(message.getId());
        if (pieceJointeFromDB != null)
            pieceJointeRepository.deleteById(pieceJointeFromDB.getId());

        message.setCategoryO(demandeMessageTO.getCategoryO());

        pieceJointe.setDemandeMessage(message);
        message.setPieceJointe(pieceJointe);

        DemandeMessage demandeMessage = demandeMessageRepository.save(message);
        DemandeMessageTO demandeMessageTO1 =  demandeMessageMapper.toDemandeMessageTO(demandeMessage);
        return demandeMessageTO1;
    }

}
