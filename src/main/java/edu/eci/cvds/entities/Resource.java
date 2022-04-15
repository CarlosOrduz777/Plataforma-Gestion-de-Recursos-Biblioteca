package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Resource implements Serializable {

    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String ubicacion;
    @Getter @Setter private boolean disponible;
    @Getter @Setter private String tipo;
    @Getter @Setter private String descripcion;

    public Resource(int id, String nombre, String ubicacion, boolean disponible, String tipo, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Resource(int id, String nombre, String ubicacion, boolean disponible, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
        this.tipo = tipo;
        this.descripcion = null;
    }
}
