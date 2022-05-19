package edu.eci.cvds.services;

import edu.eci.cvds.entities.Horario;

import org.apache.ibatis.exceptions.PersistenceException;
import java.util.Date;
import java.util.List;

public interface ServiciosHorario {


    List<Horario> consultarHorario(int id) throws PersistenceException;

    List<Horario> consultarHorarios() throws PersistenceException;

    void reservarRecurso(String fecha, String horainicial, String horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, Date fecharecurrencia, String estado) throws ServicesException;

}