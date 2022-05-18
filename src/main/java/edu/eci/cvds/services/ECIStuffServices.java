package edu.eci.cvds.services;

import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;

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
    void registerBooking(Date fechaInicio, Date fechaFin,int userId,int resourceId,String tipoReserva) throws ServicesException;
    Booking consultBooking(int id) throws ServicesException;
    User getUserIdByEmail(String email) throws ServicesException;
    public User getUserById(int id) throws ServicesException;
    public Resource getResourceById(int id) throws ServicesException;

    public void logOut() throws  ServicesException;

    public List<Booking> viewBookingUser() throws ServicesException;

    public Resource getInicioDisponibilidad(int idRecurso) throws ServicesException;

}
