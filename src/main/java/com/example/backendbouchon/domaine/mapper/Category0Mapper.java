package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.CategorieTO;
import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.model.Categorie0;
import com.example.backendbouchon.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",implementationName = "CategorieMapperImpl")
public interface Category0Mapper {

        CategorieTO toCategory0TO(Categorie0 category0);

        Categorie0 toCategory0BO(CategorieTO category0TO);

        List<CategorieTO> toListCategorieTO(List<Categorie0> listCategories);

}
