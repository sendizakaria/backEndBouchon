package com.example.backendbouchon.domaine.dto;

import com.example.backendbouchon.model.DemandeMessage;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Getter
@Setter
public class TagTO {

    private Long id;

    private String name;

    private String type;

    private DemandeMessage demandeMessage;


    public TagTO(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
