package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Resource;

import java.util.List;

public interface UserDAO {
    public void create() throws PersistenceException;

    public List<Resource> consultResources() throws PersistenceException;
}
