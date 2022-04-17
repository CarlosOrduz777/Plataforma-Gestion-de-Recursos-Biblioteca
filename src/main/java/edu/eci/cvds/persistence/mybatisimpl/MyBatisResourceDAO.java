package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.persistence.ResourceDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ResourceMapper;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBatisResourceDAO implements ResourceDAO {

    private ResourceMapper resourceMapper;

    @Override
    public void registerResources() throws PersistenceException {
        try {
            resourceMapper.registerResource();
        }catch (Exception e){
            throw new PersistenceException("Error al registrar el recurso");
        }
    }
}
