package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;

public interface BookingDAO {
    public void registerBooking(Date fechaInicio, Date fechaFin,int userId, int resourceId) throws PersistenceException;
    public Booking consultBooking(int id) throws edu.eci.cvds.persistence.PersistenceException;
}
