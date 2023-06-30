package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",implementationName = "RoleMapperImpl")
public interface RoleMapper {

        RoleTO toRoleTO(Role role);

        Role toRoleBO(RoleTO roleTO);

        List<RoleTO> toListRoleTO(List<Role> listeRole);

}
