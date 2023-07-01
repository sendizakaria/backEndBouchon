package com.example.backendbouchon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "demandeMessage")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class DemandeMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sender")
    private int sender;

    @Column(name = "state")
    private String state;

    @Column(name = "subject")
    private String subject;

    @Column(name = "category")
    private String category;

    @OneToOne(mappedBy = "demandeMessage",cascade = CascadeType.MERGE,fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Categorie0 categoryO;

   // @OneToMany(cascade = {CascadeType.ALL})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Student student;

    @Column(name = "text")
    private String text;

    @Column(name = "eleve")
    private boolean eleve;

    @Column(name = "parents")
    private boolean parents;

    @Column(name = "direction")
    private String direction;

    @OneToMany(mappedBy="demandeMessage" )
    @JsonIgnore
    private List<Tag> destinataire;

    @OneToOne(mappedBy = "demandeMessage",cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private PieceJointe pieceJointe ;

}
