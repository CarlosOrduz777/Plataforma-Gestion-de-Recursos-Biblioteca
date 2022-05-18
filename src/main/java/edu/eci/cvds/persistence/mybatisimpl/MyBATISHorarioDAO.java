package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.HorarioMapper;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.OpcionRecurrencia;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public class MyBATISHorarioDAO implements HorarioDAO {

    @Inject
    private HorarioMapper horarioMapper;


    @Override
    public void reservarRecurso(Date fecha, Timestamp horainicial, Timestamp horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, Date fecharecurrencia, String estado){
        try {
            horarioMapper.reservarRecurso(fecha, horainicial, horafinal, idrecurso, idusuario, recurrencia.toString(), fecharecurrencia, estado);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al agregar horario",e);
        }
    }


    public List<Horario> consultarHorario(int id) throws ParseException {
        try{
            return horarioMapper.consultarHorario(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar el horario" + id, e);
        }
    }


    @Override
    public List<Horario> consultarHorarios() throws ParseException {
        try{
            return horarioMapper.consultarHorarios();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los horarios", e);
        }
    }

}