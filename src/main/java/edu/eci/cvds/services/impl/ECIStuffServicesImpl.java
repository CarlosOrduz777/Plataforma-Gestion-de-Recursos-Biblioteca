package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;

public class ECIStuffServicesImpl implements ECIStuffServices {
    @Inject
    private UserDAO userDAO;
    @Override
    public void createUsers() throws ServicesException {
        try{
            userDAO.create();
        }catch (PersistenceException e){
            throw new ServicesException("No se puede crear Usuario", e);
        }
    }
}
