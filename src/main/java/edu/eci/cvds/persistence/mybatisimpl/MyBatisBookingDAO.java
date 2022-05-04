package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.BookingDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.BookingMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;
import java.util.List;

public class MyBatisBookingDAO implements BookingDAO {

    @Inject
    private BookingMapper bookingMapper;


    @Override
    public void registerBooking(Date fechaInicio, Date fechaFin,int userId,int resourceId) throws PersistenceException {
        try {
            bookingMapper.registerBooking(fechaInicio,fechaFin,userId,resourceId);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<?> consultBookings() throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return bookingMapper.consultBookings();
        }catch (Exception e){
            throw new edu.eci.cvds.persistence.PersistenceException(e.getMessage());
        }
    }
}
