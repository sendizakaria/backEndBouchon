package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.CategorieRepository;
import com.example.backendbouchon.domaine.dto.CategorieTO;
import com.example.backendbouchon.domaine.mapper.Category0Mapper;
import com.example.backendbouchon.model.Categorie0;
import com.example.backendbouchon.service.repository.signature.ICategorieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategorieServiceImpl implements ICategorieService {

    private CategorieRepository categorieRepository;
    private Category0Mapper category0Mapper;

    public CategorieServiceImpl( CategorieRepository categorieRepository,Category0Mapper category0Mapper) {
        this.categorieRepository = categorieRepository;
        this.category0Mapper = category0Mapper;
    }

    @Override
    public void save(CategorieTO Categorie0TO) {
        categorieRepository.save(category0Mapper.toCategory0BO(Categorie0TO));
    }

    @Override
    public List<CategorieTO> getAllCategorie0s() {
        return category0Mapper.toListCategorieTO(categorieRepository.findAll());
    }

    @Override
    public Categorie0 getCategorie0ById(Long catId) {
        return  categorieRepository.findById(catId).orElse(null);

       // return Optional.ofNullable(categorieRepository.findById(catId))    .orElse(null);
    }

    @Override
    public void deleteAllCategorieService() {
        categorieRepository.deleteAll();
    }


}
