package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.HorarioDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.HorarioMapper;
import edu.eci.cvds.samples.entities.Horario;

import java.util.List;

public class MyBATISHorarioDAO implements HorarioDAO {

    @Inject
    private HorarioMapper horarioMapper;


    @Override
    public void save(Horario re) throws PersistenceException {
        try {
            horarioMapper.insertarHorario(re);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al agregar horario",e);
        }

    }

    @Override
    public Horario load(int id) throws PersistenceException {
        try{
            return horarioMapper.consultarHorario(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el horario" + id, e);
        }
    }

    @Override
    public List<Horario> loadAllAvailable() throws PersistenceException {
        try{
            return horarioMapper.consultarHorariosDisponibles();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los horarios", e);
        }
    }

}