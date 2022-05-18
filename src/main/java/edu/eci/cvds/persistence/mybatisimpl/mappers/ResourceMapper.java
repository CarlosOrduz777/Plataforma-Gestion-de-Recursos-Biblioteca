package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Resource;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ResourceMapper {
    void registerResource(@Param("r") Resource resource);
    List<Resource> consultResources();

    Resource getResourceById(@Param("id") int id);
}
