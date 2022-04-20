package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Resource implements Serializable {

    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String ubicacion;
    @Getter @Setter private String capacidad;
    @Getter @Setter private String tipo;
    @Getter @Setter private Date iDisp;
    @Getter @Setter private Date fDisp;

    public Resource(String nombre, String ubicacion, String capacidad, String tipo, Date iDisp, Date fDisp){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.iDisp = iDisp;
        this.fDisp = fDisp;
    }
}
