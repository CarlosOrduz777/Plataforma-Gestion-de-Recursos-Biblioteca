package edu.eci.cvds.services;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;

import java.util.List;

public interface ECIStuffServices {
    /**
     * Insertar usuarios
     *
     * @throws ServicesException
     */
    public void createUsers() throws ServicesException;
    List<Resource> consultResources() throws  ServicesException;

    public void signIn(String email, String password) throws  ServicesException;

    public void registerResources(Resource resource) throws  ServicesException;

}
