package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;
import java.util.ArrayList;

import java.sql.Date;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "AlquilerBean")
@SessionScoped
public class AlquilerItemsBean extends BasePageBean {

    @Inject
    private ServiciosAlquiler serviciosAlquiler;
    private Recurso recurso;
    private List<Recurso> added;
    private List<Recurso> recursos;

    /**
     * Retorna una lista con la informacion de los clientes almacenados en la base de datos
     * @return todos los clientes de la base de datos
     * @throws ExcepcionServiciosAlquiler
     */
    public AlquilerItemsBean(){
        added = new ArrayList<Recurso>();
    }

    public List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosAlquiler{
        try {
            recursos =  serviciosAlquiler.consultarRecursosDisponibles();
            return recursos;
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar la tabla Recursos");
        }
    }
    public List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosAlquiler{
        try {
            recursos =  serviciosAlquiler.consultarRecursosNoDisponibles();
            return recursos;
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar la tabla Recursos");
        }
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}