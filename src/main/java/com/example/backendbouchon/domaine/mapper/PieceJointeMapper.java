package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.PieceJointeTO;
import com.example.backendbouchon.model.PieceJointe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "PieceJointeMapperImpl")
public interface PieceJointeMapper {

        PieceJointe toPieceJointeBO(PieceJointeTO pieceJointeTO);

        PieceJointeTO toPieceJointeTO(PieceJointe pieceJointe);

}
