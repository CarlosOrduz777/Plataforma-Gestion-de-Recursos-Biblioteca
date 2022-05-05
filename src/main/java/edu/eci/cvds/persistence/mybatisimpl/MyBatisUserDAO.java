package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UserMapper;
import edu.eci.cvds.entities.User;

import java.util.List;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    private UserMapper userMapper;
    @Override
    public void create() throws PersistenceException {
        try {
            userMapper.createUser();
        }catch (Exception e){
            throw new PersistenceException("No se Pudo crear Usuario por " + e.getMessage());
        }
    }

    @Override
    public User getUserIdByEmail(String email) throws PersistenceException {
        try {
            return userMapper.getUserIdByEmail(email);
        }catch (Exception e){
            throw new PersistenceException("No se Pudo consultar id de Usuario" + e.getMessage());
        }
    }


}
