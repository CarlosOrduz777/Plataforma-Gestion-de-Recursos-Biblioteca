package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoMapper;
import edu.eci.cvds.samples.entities.Recurso;

import java.sql.Date;
import java.util.List;

public class MyBATISRecursoDAO implements RecursoDAO {

    @Inject
    private RecursoMapper recursoMapper;


    @Override
    public void save(Recurso re) throws PersistenceException {
        try {
            recursoMapper.insertarRecurso(re);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al agregar recurso",e);
        }

    }

    @Override
    public Recurso load(int id) throws PersistenceException {
        try{
            return recursoMapper.consultarRecurso(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el recurso" + id, e);
        }
    }

    @Override
    public List<Recurso> loadAllAvailable() throws PersistenceException {
        try{
            return recursoMapper.consultarRecursosDisponibles();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los recursos", e);
        }
    }
    @Override
    public List<Recurso> loadAllNotAvailable() throws PersistenceException {
        try{
            return recursoMapper.consultarRecursosNoDisponibles();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los recursos", e);
        }
    }

}