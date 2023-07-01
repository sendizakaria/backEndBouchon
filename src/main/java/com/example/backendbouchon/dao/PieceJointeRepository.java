package com.example.backendbouchon.dao;

import com.example.backendbouchon.model.PieceJointe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PieceJointeRepository extends JpaRepository<PieceJointe, Long> {

    @Query(value ="SELECT p.* FROM PIECE_JOINTE p WHERE p.id = ?1",nativeQuery = true)
    PieceJointe findPieceJointesByMessageId(Long userId);

}
