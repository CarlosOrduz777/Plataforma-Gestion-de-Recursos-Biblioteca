package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.services.ServicesException;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface ResourceDAO {
    public void registerResources(Resource resource) throws PersistenceException;
    public List<Resource> consultResources() throws edu.eci.cvds.persistence.PersistenceException;
}
