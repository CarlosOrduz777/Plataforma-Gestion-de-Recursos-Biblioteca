package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    @Getter @Setter private int id;
    @Getter @Setter private Date fechaInicio;
    @Getter @Setter private Date fechaFin;
    @Getter @Setter private int usuario_id;
    @Getter @Setter private int recurso_id;

    public Booking(){
        super();
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

    public Booking(int id, Date fechaInicio, Date fechaFin, int usuario_id, int recurso_id){
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario_id = usuario_id;
        this.recurso_id = recurso_id;
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
