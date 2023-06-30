package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.RoleRepository;
import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.domaine.mapper.RoleMapper;
import com.example.backendbouchon.service.repository.signature.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public void save(RoleTO roleTO) {
        roleRepository.save(roleMapper.toRoleBO(roleTO));
    }

    @Override
    public List<RoleTO> getAllRoles() {
        return roleMapper.toListRoleTO(roleRepository.findAll());
    }

    @Override
    public RoleTO getRoleByName(String role) {
        return  roleMapper.toRoleTO(roleRepository.findByRole(role).get(0));
    }

}
