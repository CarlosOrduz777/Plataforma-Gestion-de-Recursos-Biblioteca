package edu.eci.cvds.persistence;

import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;

public interface BookingDAO {
    public void registerBooking(Date fechaInicio, Date fechaFin,int userId, int resourceId) throws PersistenceException;
}
