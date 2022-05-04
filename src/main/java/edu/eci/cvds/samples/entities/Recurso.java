package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;

public class Recurso implements Serializable{

    private int id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private String descripcion;
    private Date iniciodisponibilidad;
    private Date findisponibilidad;

    public Recurso() {
    }

    public Recurso(int id, String nombre, String ubicacion, String tipo, String descripcion, Date iniciodisponibilidad,
                    Date findisponibilidad) {
        this.id =id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo =tipo;
        this.descripcion = descripcion;
        this.iniciodisponibilidad = iniciodisponibilidad;
        this.findisponibilidad = findisponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getIniciodisponibilidad() {
        return iniciodisponibilidad;
    }

    public void setIniciodisponibilidad(Date iniciodisponibilidad) {
        this.iniciodisponibilidad = iniciodisponibilidad;
    }

    public Date getFindisponibilidad() {
        return findisponibilidad;
    }

    public void setFindisponibilidad(Date findisponibilidad) {
        this.findisponibilidad = findisponibilidad;
    }

    @Override
    public String toString() {
        return "Recurso{" + "nombre=" + nombre + ", ubicacion=" + ubicacion + '}';
    }




}
