package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Report;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    public void create() throws PersistenceException;

    public User getUserIdByEmail(String email) throws PersistenceException;

    public List<Booking> viewBookingUser(String email) throws PersistenceException;

    User getUserById(int id) throws PersistenceException;

    List<Report> getReportByResourceMan();

    List<Report> getReportByResourceMen();

    List<Report> getReportByResourceRec();

    List<Report> getReportByResourceCan();
}
