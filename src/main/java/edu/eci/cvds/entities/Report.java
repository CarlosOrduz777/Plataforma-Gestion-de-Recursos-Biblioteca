package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Report {
    @Getter @Setter private int numeroReservas;
    @Getter @Setter private String recursoId;
    @Getter @Setter private Date inicioDisp;
    @Getter @Setter private Date finDisp;
    @Getter @Setter private String programa;
    @Getter @Setter private String tipo;
    @Getter @Setter private String nombre;
    @Getter @Setter private String ubicacion;

    public Report(){
        super();
    }

}
