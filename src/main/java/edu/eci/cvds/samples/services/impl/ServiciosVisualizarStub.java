package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ExcepcionServiciosVisualizar;
import edu.eci.cvds.samples.services.ServiciosVisualizar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServiciosVisualizarStub implements ServiciosVisualizar {

    private final Map<Integer,Recurso> recursos;


    public ServiciosVisualizarStub() {
        recursos = new HashMap<>();
    }



    @Override
    public Recurso consultarRecurso(int id) throws ExcepcionServiciosVisualizar {
        Recurso r=null;
        if(recursos.containsKey(id)){
            r=recursos.get(id);
        }
        return r;
    }

    @Override
    public List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosVisualizar {
        return  new LinkedList<>(recursos.values());
    }

    @Override
    public List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosVisualizar {
        return  new LinkedList<>(recursos.values());
    }



    @Override
    public void registrarRecurso(Recurso p) throws ExcepcionServiciosVisualizar {
        if (!recursos.containsKey(p.getId())) {
            recursos.put(p.getId(), p);
        } else {
            throw new ExcepcionServiciosVisualizar("El recurso con id "+p+" ya esta registrado.");
        }
    }

}