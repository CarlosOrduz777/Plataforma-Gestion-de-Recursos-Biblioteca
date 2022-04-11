package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UserMapper;


import javax.persistence.PersistenceException;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    private UserMapper userMapper;
    @Override
    public void create() throws PersistenceException {
        try {
            userMapper.createUser();
        }catch (Exception e){
            throw new PersistenceException("No se Pudo crear Usuario");
        }
    }
}
