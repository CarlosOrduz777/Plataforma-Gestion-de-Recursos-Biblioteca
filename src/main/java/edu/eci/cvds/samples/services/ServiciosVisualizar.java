package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Recurso;

import java.util.List;

public interface ServiciosVisualizar {


    public abstract Recurso consultarRecurso(int id) throws ExcepcionServiciosVisualizar;



    List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosVisualizar;

    List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosVisualizar;

    public abstract void registrarRecurso(Recurso p) throws ExcepcionServiciosVisualizar;




}