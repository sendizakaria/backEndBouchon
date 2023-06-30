package com.example.backendbouchon.domaine.dto;

import com.example.backendbouchon.model.DemandeMessage;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class CategorieTO {

    private Long id;
    private String bgColor;
    private String name;
    private String value;
    private DemandeMessage demandeMessage;

    public CategorieTO(Long id, String bgColor, String name, String value) {
        this.id = id;
        this.bgColor = bgColor;
        this.name = name;
        this.value = value;
    }
}
