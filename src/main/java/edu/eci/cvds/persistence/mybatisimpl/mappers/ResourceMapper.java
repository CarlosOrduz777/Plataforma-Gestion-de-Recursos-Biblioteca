package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Resource;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ResourceMapper {
    void registerResource(@Param("r") Resource resource);
    List<Resource> consultResources();
    List<Resource> consultAllResources();

    Resource getResourceById(@Param("id") int id);

    void changeResourceState(@Param("idResource")int idResource);
}
