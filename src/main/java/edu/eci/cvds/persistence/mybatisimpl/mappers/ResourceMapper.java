package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Resource;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    void registerResource(@Param("r") Resource resource);
}
