package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    public void create() throws PersistenceException;

    User getUserIdByEmail(String email) throws PersistenceException;


    User getUserById(int id) throws PersistenceException;
}
