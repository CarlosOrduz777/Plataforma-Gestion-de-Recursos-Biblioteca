package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

public class Resource implements Serializable {

    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String ubicacion;
    @Getter @Setter private String capacidad;
    @Getter @Setter private String tipo;
    @Getter @Setter private Date iDisp;
    @Getter @Setter private Date fDisp;
    @Getter @Setter private boolean disponible;

    public Resource(String nombre, String ubicacion, String capacidad, String tipo, Date iDisp, Date fDisp,boolean disponible){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.iDisp = iDisp;
        this.fDisp = fDisp;
        this.disponible = disponible;
    }
    public Resource(int id, String nombre, String ubicacion, String capacidad, String tipo, Date iDisp, Date fDisp){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.iDisp = iDisp;
        this.fDisp = fDisp;
    }
    public Resource(int id, String nombre, String ubicacion, String capacidad, String tipo, Date iDisp, Date fDisp,boolean disponible){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.iDisp = iDisp;
        this.fDisp = fDisp;
        this.disponible = disponible;
    }
    public Resource(int id, String nombre, String ubicacion, String capacidad, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }
    public Resource(int id, String nombre, String ubicacion, String capacidad, String tipo, Date fDisp){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.fDisp = fDisp;
    }
    public Resource(Date iDisp,Date fDisp){
        this.iDisp = iDisp;
        this.fDisp = fDisp;
    }

    public Date getfDisp() {
        return this.fDisp;
    }
    public Date getiDisp() {
        return this.iDisp;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", tipo='" + tipo + '\'' +
                ", iDisp=" + iDisp +
                ", fDisp=" + fDisp +
                '}';
    }
}
