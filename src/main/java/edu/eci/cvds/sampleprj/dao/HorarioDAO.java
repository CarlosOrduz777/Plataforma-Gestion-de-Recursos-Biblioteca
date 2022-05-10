package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Horario;

import java.util.List;

public interface HorarioDAO {

    public void save(Horario re) throws PersistenceException;

    public Horario load(int id) throws PersistenceException;

    public List<Horario> loadAllAvailable() throws PersistenceException;


}
