package com.example.backendbouchon.domaine.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class RoleTO {

    private int id;
    private String role;

    public RoleTO(String role) {
        this.role = role;
    }
}
