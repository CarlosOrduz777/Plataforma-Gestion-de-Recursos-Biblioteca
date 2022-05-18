package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.OpcionRecurrencia;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.text.ParseException;

public interface HorarioDAO {

    public void reservarRecurso(Date fecha, Timestamp horainicial, Timestamp horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, Date fecharecurrencia, String estado);

    public List<Horario> consultarHorario(int id) throws ParseException;

    public List<Horario> consultarHorarios() throws ParseException;

}
