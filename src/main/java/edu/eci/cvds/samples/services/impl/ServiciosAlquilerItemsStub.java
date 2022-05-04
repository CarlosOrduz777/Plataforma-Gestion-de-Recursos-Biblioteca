package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServiciosAlquilerItemsStub implements ServiciosAlquiler {

    private final Map<Integer,Recurso> recursos;


    public ServiciosAlquilerItemsStub() {
        recursos = new HashMap<>();
    }



    @Override
    public Recurso consultarRecurso(int id) throws ExcepcionServiciosAlquiler {
        Recurso r=null;
        if(recursos.containsKey(id)){
            r=recursos.get(id);
        }
        return r;
    }

    @Override
    public List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosAlquiler {
        return  new LinkedList<>(recursos.values());
    }

    @Override
    public List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosAlquiler {
        return  new LinkedList<>(recursos.values());
    }



    @Override
    public void registrarRecurso(Recurso p) throws ExcepcionServiciosAlquiler {
        if (!recursos.containsKey(p.getId())) {
            recursos.put(p.getId(), p);
        } else {
            throw new ExcepcionServiciosAlquiler("El recurso con id "+p+" ya esta registrado.");
        }
    }

}