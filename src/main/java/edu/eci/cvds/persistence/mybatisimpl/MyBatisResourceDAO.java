package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.ResourceDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ResourceMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisResourceDAO implements ResourceDAO {
    @Inject
    private ResourceMapper resourceMapper;

    @Override
    public void registerResources(Resource resource) throws PersistenceException {
        try {
            resourceMapper.registerResource(resource);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }
    @Override
    public List<Resource> consultResources() throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return resourceMapper.consultResources();
        }catch (Exception e){
            throw new edu.eci.cvds.persistence.PersistenceException(e.getMessage());
        }
    }

    @Override
    public Resource getResourceById(int id) {
        try {
            return resourceMapper.getResourceById(id);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
