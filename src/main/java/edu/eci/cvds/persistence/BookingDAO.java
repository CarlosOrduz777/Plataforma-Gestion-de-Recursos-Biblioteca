package edu.eci.cvds.persistence;

import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;
import java.util.List;

public interface BookingDAO {
    public void registerBooking(Date fechaInicio, Date fechaFin,int userId, int resourceId) throws PersistenceException;
    public List<?> consultBookings() throws edu.eci.cvds.persistence.PersistenceException;
}
