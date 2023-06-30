package com.example.backendbouchon.domaine.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class UserTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private List<RoleTO> roles = new ArrayList<>();

    public UserTO() {
        super();
    }

    public UserTO(Long id, String username, String password, String firstName, String lastName,String email,List<RoleTO> roles) {
        this(username,  firstName,  lastName,  email, password, roles);
        this.id = id;
    }

    public UserTO(String username, String firstName, String lastName, String email, String password, List<RoleTO> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }
}
