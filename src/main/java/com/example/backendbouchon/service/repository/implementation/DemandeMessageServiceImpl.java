package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.DemandeMessageRepository;
import com.example.backendbouchon.domaine.dto.DemandeMessageTO;
import com.example.backendbouchon.domaine.mapper.DemandeMessageMapper;
import com.example.backendbouchon.service.repository.signature.IDemandeMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemandeMessageServiceImpl implements IDemandeMessageService {

    private DemandeMessageRepository demandeMessageRepository;
    private DemandeMessageMapper demandeMessageMapper;

    public DemandeMessageServiceImpl(DemandeMessageRepository demandeMessageRepository,
                                     DemandeMessageMapper demandeMessageMapper) {
        this.demandeMessageRepository = demandeMessageRepository;
        this.demandeMessageMapper = demandeMessageMapper;
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

}
