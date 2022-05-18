package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.*;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.ServiciosHorario;

import java.text.ParseException;
import java.util.List;

public class ServiciosHorarioImpl implements ServiciosHorario {

    @Inject
    private HorarioDAO horarioDAO;


    public List<Horario> consultarHorario(int id) throws org.apache.ibatis.exceptions.PersistenceException{
        try {
            return horarioDAO.consultarHorario(id);
        } catch (ParseException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Horario> consultarHorarios() throws org.apache.ibatis.exceptions.PersistenceException {
        try {
            return horarioDAO.consultarHorarios();
        }catch (ParseException e){
            throw new org.apache.ibatis.exceptions.PersistenceException(e.getMessage());
        }

    }

}
