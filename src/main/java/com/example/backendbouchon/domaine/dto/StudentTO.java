package com.example.backendbouchon.domaine.dto;

import com.example.backendbouchon.model.DemandeMessage;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class StudentTO {

    private int id;

    public StudentTO(int id) {
        this.id = id;
    }
}
