package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    @Getter @Setter private int id;
    @Getter @Setter private Date fechaInicio;
    @Getter @Setter private Date fechaFin;

    public Booking(int id, Date fechaInicio,Date fechaFin){
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public Booking(Date fechaInicio,Date fechaFin){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
