package com.example.backendbouchon.dao;

import com.example.backendbouchon.model.DemandeMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeMessageRepository extends JpaRepository<DemandeMessage, Long> {

}
