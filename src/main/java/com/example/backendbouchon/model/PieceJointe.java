package com.example.backendbouchon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "PIECE_JOINTE")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class PieceJointe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OBJET_ID")
    private Long id;

    @Column(name="NAME_FILE",length = 20,nullable = true)
    private String nameFile;

    @Column(name="TYPE_FILE",length = 900,nullable = true)
    private String typeFile;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "PIC_BYTE", length = 900000)
    private byte[] picByte;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private DemandeMessage demandeMessage ;

}
