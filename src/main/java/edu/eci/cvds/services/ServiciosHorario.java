package edu.eci.cvds.services;

import edu.eci.cvds.entities.Horario;

import javax.persistence.PersistenceException;
import java.util.List;

public interface ServiciosHorario {


    public abstract List<Horario> consultarHorario(int id) throws PersistenceException;

    public abstract List<Horario> consultarHorarios() throws PersistenceException;

}