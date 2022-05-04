package edu.eci.cvds.services;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ECIStuffServices {
    /**
     * Insertar usuarios
     *
     * @throws ServicesException
     */
    public void createUsers() throws ServicesException;
    public void signIn(String email, String password) throws  ServicesException;
    List<Resource> consultResources() throws  ServicesException;
    public void registerResources(Resource resource) throws  ServicesException;
    void registerBooking(Date fechaInicio, Date fechaFin,int userId,int resourceId) throws ServicesException;
    List<?> consultBookings() throws ServicesException;
    User getUserIdByEmail(String email) throws ServicesException;

    public void logOut() throws  ServicesException;

}
