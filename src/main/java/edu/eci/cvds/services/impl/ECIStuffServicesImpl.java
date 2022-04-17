package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ResourceDAO;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;

public class ECIStuffServicesImpl implements ECIStuffServices {
    @Inject
    private UserDAO userDAO;

    @Inject
    private ResourceDAO resourceDAO;


    @Override
    public void createUsers() throws ServicesException {
        try{
            userDAO.create();
        }catch (PersistenceException e){
            throw new ServicesException("No se puede crear Usuario", e);
        }
    }

    @Override
    public void registerResources() throws ServicesException {
        try{
            resourceDAO.registerResources();
        }catch (Exception e){
            throw new ServicesException("No se ha podido registrar el recurso", e);
        }
    }
}
