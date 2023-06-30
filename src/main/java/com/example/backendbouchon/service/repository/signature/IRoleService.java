package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.RoleTO;

import java.util.List;

public interface IRoleService {

    void save(RoleTO roleTO);
    List<RoleTO> getAllRoles();
    RoleTO getRoleByName(String role);

}
