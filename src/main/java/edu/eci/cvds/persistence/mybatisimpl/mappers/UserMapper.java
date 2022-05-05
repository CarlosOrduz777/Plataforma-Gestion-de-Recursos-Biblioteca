package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    void createUser();
    User getUserIdByEmail(@Param("email")String email);

    User getUserById(@Param("id") int id);
}
