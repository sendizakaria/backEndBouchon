package com.example.backendbouchon.domaine.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class DemandeMessageListTO {

    List<DemandeMessageTO> payload;

    public DemandeMessageListTO(List<DemandeMessageTO> payload) {
        this.payload = payload;
    }
}
