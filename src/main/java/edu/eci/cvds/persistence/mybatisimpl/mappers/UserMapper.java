package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Resource;

import java.util.List;

public interface UserMapper {
    void createUser();
    List<Resource> consultResources();
}
