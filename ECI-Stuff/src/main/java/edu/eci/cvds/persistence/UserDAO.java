package edu.eci.cvds.persistence;

import javax.persistence.PersistenceException;

public interface UserDAO {
    public void create() throws PersistenceException;
}
