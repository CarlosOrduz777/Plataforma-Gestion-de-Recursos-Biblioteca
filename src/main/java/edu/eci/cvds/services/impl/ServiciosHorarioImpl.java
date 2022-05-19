package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.HorarioDAO;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.OpcionRecurrencia;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.ServiciosHorario;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ServiciosHorarioImpl implements ServiciosHorario {

    @Inject
    private HorarioDAO horarioDAO;


    public List<Horario> consultarHorario(int id) throws PersistenceException{
        try {
            return horarioDAO.consultarHorario(id);
        } catch (ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Horario> consultarHorarios() throws PersistenceException {
        try {
            return horarioDAO.consultarHorarios();
        }catch (ParseException e){
            throw new PersistenceException(e.getMessage());
        }

    }

    @Override
    public void reservarRecurso(String fecha, String horainicial, String horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, Date fecharecurrencia, String estado) throws ServicesException {
        try{
            Date dateFormatted = new SimpleDateFormat("YYYY/MM/DD").parse(fecha);
            java.sql.Date dateSQL = new java.sql.Date(dateFormatted.getTime());
            Timestamp initTimeStamp = convertToTimestamp(fecha+' '+horainicial);
            Timestamp finalTimeStamp = convertToTimestamp(fecha+' '+horafinal);
            if (recurrencia != OpcionRecurrencia.UNA_VEZ){
                java.sql.Date recurrencedateSQL = new java.sql.Date(fecharecurrencia.getTime());
                crearReservaciones(dateSQL,horainicial,horafinal,idrecurso,idusuario,recurrencia,recurrencedateSQL,estado);
            }else {
                horarioDAO.reservarRecurso(dateSQL,initTimeStamp,finalTimeStamp,idrecurso,idusuario, recurrencia,dateSQL,estado);
            }
        }catch (ParseException parseException){
            throw new ServicesException("El valor ingresado no es una fecha valida", parseException);
        }
    }

    private Timestamp convertToTimestamp(String time) throws ParseException {
        Date timeFormatted = new SimpleDateFormat("YYYY/MM/DD hh:mm").parse(time);
        Timestamp timeStamp = new Timestamp(timeFormatted.getTime());
        return timeStamp;
    }
    private Timestamp convertToTimestamp(LocalDate date, String time) throws ParseException {
        Date timeFormatted = new SimpleDateFormat("YYYY-MM-DD hh:mm").parse(java.sql.Date.valueOf(date).toString()+' '+time);
        Timestamp timeStamp = new Timestamp(timeFormatted.getTime());
        return timeStamp;
    }

    public void crearReservaciones(java.sql.Date fecha, String horainicial, String horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, java.sql.Date fecharecurrencia, String estado) throws ParseException {
        switch (recurrencia){
            case DIARIO:
                crearVariasReservaciones(fecha, horainicial, horafinal, idrecurso, idusuario, recurrencia, fecharecurrencia, estado,1);
                break;
            case SEMANAL:
                crearVariasReservaciones(fecha, horainicial, horafinal, idrecurso, idusuario, recurrencia, fecharecurrencia, estado,7);
                break;
            case MENSUAL:
                crearReservacionesMes(fecha, horainicial, horafinal, idrecurso, idusuario, recurrencia, fecharecurrencia, estado);
                break;
        }
    }

    private void crearReservacionesMes(java.sql.Date fecha, String horainicial, String horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, java.sql.Date fecharecurrencia, String estado) throws ParseException {
        LocalDate dateLocal=fecha.toLocalDate();
        for (LocalDate currentDate = dateLocal; currentDate.isBefore(fecharecurrencia.toLocalDate().plusDays(1)); currentDate=currentDate.plusMonths(1)) {
            if (currentDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
                Timestamp initHourTimestamp = this.convertToTimestamp(currentDate,horainicial);
                Timestamp finalHourTimestamp = this.convertToTimestamp(currentDate,horafinal);
                horarioDAO.reservarRecurso(java.sql.Date.valueOf(currentDate),initHourTimestamp,finalHourTimestamp,idrecurso,idusuario, recurrencia,fecharecurrencia,estado);
            }
        }
    }

    private void crearVariasReservaciones(java.sql.Date fecha, String horainicial, String horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, java.sql.Date fecharecurrencia, String estado,int days) throws ParseException{
        LocalDate dateLocal=fecha.toLocalDate();
        for (LocalDate currentDate = dateLocal; currentDate.isBefore(fecharecurrencia.toLocalDate().plusDays(1)); currentDate=currentDate.plusDays(days)) {
            if (currentDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
                Timestamp initHourTimestamp = this.convertToTimestamp(currentDate,horainicial);
                Timestamp finalHourTimestamp = this.convertToTimestamp(currentDate,horafinal);
                horarioDAO.reservarRecurso(java.sql.Date.valueOf(currentDate),initHourTimestamp,finalHourTimestamp,idrecurso,idusuario, recurrencia,fecharecurrencia,estado);
            }
        }
    }


}
