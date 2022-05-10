package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.*;

import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.services.ExcepcionServiciosHorario;
import edu.eci.cvds.samples.services.ServiciosHorario;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public class ServiciosHorarioImpl implements ServiciosHorario {

    @Inject
    private HorarioDAO horarioDAO;

    @Override
    public Horario consultarHorario(int id) throws ExcepcionServiciosHorario {
        try {
            Horario horario =  horarioDAO.load(id);
            if(horario ==null) throw new ExcepcionServiciosHorario(ExcepcionServiciosHorario.NO_RESOURCE_REGISTRED);
            return horario;
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosHorario("Error al consultar el horario", ex);
        }
    }

    @Override
    public List<Horario> consultarHorariosDisponibles() throws ExcepcionServiciosHorario {
        try{
            return horarioDAO.loadAllAvailable();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosHorario("Error al consultar horarios" + ex.getMessage());
        }
    }



    @Transactional
    @Override
    public void registrarHorario(Horario r) throws ExcepcionServiciosHorario {
        try {
            horarioDAO.save(r);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosHorario("Error al registrar el horario",ex);
        }
    }

}
