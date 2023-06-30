package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.DemandeMessageTO;
import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.model.DemandeMessage;
import com.example.backendbouchon.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",implementationName = "DemandeMessageMapperImpl")
public interface DemandeMessageMapper {

        DemandeMessageTO toDemandeMessageTO(DemandeMessage demandeMessage);

        DemandeMessage toDemandeMessageBO(DemandeMessageTO demandeMessageTO);

        List<DemandeMessageTO> toListDemandeMessageTO(List<DemandeMessage> listeDemandeMessage);

}
