package edu.eci.cvds.persistence;

import edu.eci.cvds.services.ServicesException;
import org.apache.ibatis.exceptions.PersistenceException;

public interface ResourceDAO {
    public void registerResources() throws PersistenceException;
}
