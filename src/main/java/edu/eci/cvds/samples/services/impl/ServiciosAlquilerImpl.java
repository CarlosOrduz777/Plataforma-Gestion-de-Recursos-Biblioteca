package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.*;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import org.mybatis.guice.transactional.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    @Inject
    private RecursoDAO recursoDAO;

    @Override
    public Recurso consultarRecurso(int id) throws ExcepcionServiciosAlquiler {
        try {
            Recurso recurso=  recursoDAO.load(id);
            if(recurso==null) throw new ExcepcionServiciosAlquiler(ExcepcionServiciosAlquiler.NO_RESOURCE_REGISTRED);
            return recurso;
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al consultar el recurso", ex);
        }
    }

    @Override
    public List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosAlquiler {
        try{
            return recursoDAO.loadAllAvailable();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al consultar recursos" + ex.getMessage());
        }
    }

    @Override
    public List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosAlquiler {
        try{
            return recursoDAO.loadAllNotAvailable();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al consultar recursos" + ex.getMessage());
        }
    }



    @Transactional
    @Override
    public void registrarRecurso(Recurso r) throws ExcepcionServiciosAlquiler {
        try {
            recursoDAO.save(r);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al registrar el recurso",ex);
        }
    }

}
