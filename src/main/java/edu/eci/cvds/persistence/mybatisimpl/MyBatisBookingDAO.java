package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.BookingDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.BookingMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;

public class MyBatisBookingDAO implements BookingDAO {

    @Inject
    private BookingMapper bookingMapper;


    @Override
    public void registerBooking(Date fechaInicio, Date fechaFin,int userId,int resourceId,String tipoReserva) throws PersistenceException {
        try {
            bookingMapper.registerBooking(fechaInicio,fechaFin,userId,resourceId,tipoReserva);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Booking consultBooking(int id) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return bookingMapper.consultBooking(id);
        }catch (Exception e){
            throw new edu.eci.cvds.persistence.PersistenceException(e.getMessage());
        }
    }

    @Override
    public Resource getInicioDisponibilidad(int idRecurso) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return bookingMapper.getInicioDisponibilidad(idRecurso);
        }catch (Exception e){
            throw new edu.eci.cvds.persistence.PersistenceException(e.getMessage());
        }
    }

    @Override
    public void cancelBooking(int idBooking) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            bookingMapper.cancelBooking(idBooking);
        }catch (Exception e){
            throw new edu.eci.cvds.persistence.PersistenceException(e.getMessage());
        }
    }


}
