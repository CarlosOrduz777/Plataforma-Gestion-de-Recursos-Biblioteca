package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServiciosVisualizar;
import edu.eci.cvds.samples.services.ExcepcionServiciosVisualizar;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "VisualizarBean")
@SessionScoped
public class VisualizarBean extends BasePageBean {

    @Inject
    private ServiciosVisualizar serviciosVisualizar;
    private Recurso recurso;
    private List<Recurso> added;
    private List<Recurso> recursos;

    /**
     * Retorna una lista con la informacion de los clientes almacenados en la base de datos
     * @return todos los clientes de la base de datos
     * @throws ExcepcionServiciosVisualizar
     */
    public VisualizarBean(){
        added = new ArrayList<Recurso>();
    }

    public List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosVisualizar {
        try {
            recursos =  serviciosVisualizar.consultarRecursosDisponibles();
            return recursos;
        } catch (Exception e) {
            throw new ExcepcionServiciosVisualizar("Error al consultar la tabla Recursos");
        }
    }
    public List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosVisualizar {
        try {
            recursos =  serviciosVisualizar.consultarRecursosNoDisponibles();
            return recursos;
        } catch (Exception e) {
            throw new ExcepcionServiciosVisualizar("Error al consultar la tabla Recursos");
        }
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}