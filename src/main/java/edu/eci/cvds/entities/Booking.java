package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    @Getter @Setter private int id;
    @Getter @Setter private Date fechaInicio;
    @Getter @Setter private Date fechaFin;
    @Getter @Setter private int usuarioId;
    @Getter @Setter private int recursoId;


    public  Booking(){

    }

    public Booking(int id, Date fechaInicio,Date fechaFin){
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Booking(Date fechaInicio,Date fechaFin){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Booking(int id, Date fechaInicio, Date fechaFin, int usuarioId, int recursoId){
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
        this.recursoId = recursoId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
