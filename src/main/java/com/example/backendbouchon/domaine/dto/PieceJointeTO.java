package com.example.backendbouchon.domaine.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class PieceJointeTO {

    private Long id;

    private String nameFile;

    private String typeFile;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    private byte[] picByte;

    public PieceJointeTO() {
        super();
    }

    public PieceJointeTO(Long id, String nameFile, String  typeFile, byte[]  picByte  ) {
        this( nameFile ,typeFile, picByte);
        this.id = id;
    }

    public PieceJointeTO(String nameFile, String  typeFile, byte[] picByte){
        super();
        this.nameFile = nameFile;
        this.typeFile = typeFile;
        this.picByte = picByte;
    }

}
