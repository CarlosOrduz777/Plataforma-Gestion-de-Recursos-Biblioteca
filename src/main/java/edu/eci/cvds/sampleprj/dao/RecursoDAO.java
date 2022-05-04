package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Recurso;

import java.sql.Date;
import java.util.List;

public interface RecursoDAO {

    public void save(Recurso re) throws PersistenceException;

    public Recurso load(int id) throws PersistenceException;

    public List<Recurso> loadAllAvailable() throws PersistenceException;
    public List<Recurso> loadAllNotAvailable() throws PersistenceException;


}
