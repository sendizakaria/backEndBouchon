package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.CategorieTO;
import com.example.backendbouchon.model.Categorie0;

import java.util.List;
import java.util.Optional;

public interface ICategorieService {

    void save(CategorieTO Categorie0TO);
    List<CategorieTO> getAllCategorie0s();
    Categorie0 getCategorie0ById(Long catId);
    void deleteAllCategorieService();

}
