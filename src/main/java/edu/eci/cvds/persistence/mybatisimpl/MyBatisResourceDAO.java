package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.ResourceDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ResourceMapper;
import org.apache.ibatis.exceptions.PersistenceException;

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
}
