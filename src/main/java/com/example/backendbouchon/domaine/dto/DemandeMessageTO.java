package com.example.backendbouchon.domaine.dto;

import com.example.backendbouchon.model.Categorie0;
import com.example.backendbouchon.model.Tag;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class DemandeMessageTO {

    private int sender;
    private String state;
    private String subject;
    private String category;
    private Categorie0 categoryO;
    //private StudentList student;
    //private StudentListeTO student;
    private StudentTO student;

    private String text;
    private boolean eleve;
    private boolean parents;
    private String direction;
    private List<Tag> destinataire;


    public DemandeMessageTO(int sender, String state, String subject, String category, Categorie0 categoryO,
                            StudentTO student,
                            String text, boolean eleve, boolean parents, String direction, List<Tag> destinataire) {
        this.sender = sender;
        this.state = state;
        this.subject = subject;
        this.category = category;
        this.categoryO = categoryO;
        this.student = student;
        this.text = text;
        this.eleve = eleve;
        this.parents = parents;
        this.direction = direction;
        this.destinataire = destinataire;
    }
}
