package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.*;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ExcepcionServiciosVisualizar;
import edu.eci.cvds.samples.services.ServiciosVisualizar;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

@Singleton
public class ServiciosVisualizarImpl implements ServiciosVisualizar {

    @Inject
    private RecursoDAO recursoDAO;

    @Override
    public Recurso consultarRecurso(int id) throws ExcepcionServiciosVisualizar {
        try {
            Recurso recurso=  recursoDAO.load(id);
            if(recurso==null) throw new ExcepcionServiciosVisualizar(ExcepcionServiciosVisualizar.NO_RESOURCE_REGISTRED);
            return recurso;
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosVisualizar("Error al consultar el recurso", ex);
        }
    }

    @Override
    public List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosVisualizar {
        try{
            return recursoDAO.loadAllAvailable();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosVisualizar("Error al consultar recursos" + ex.getMessage());
        }
    }

    @Override
    public List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosVisualizar {
        try{
            return recursoDAO.loadAllNotAvailable();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosVisualizar("Error al consultar recursos" + ex.getMessage());
        }
    }



    @Transactional
    @Override
    public void registrarRecurso(Recurso r) throws ExcepcionServiciosVisualizar {
        try {
            recursoDAO.save(r);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosVisualizar("Error al registrar el recurso",ex);
        }
    }

}
