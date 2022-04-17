package edu.eci.cvds.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    void registerResource(@Param("nombre") String nombre, @Param("ubicacion") String ubicacion, @Param("tipo") String tipo, @Param("capacidad") String capacidad, @Param("iDisp") String iDisp, @Param("fDisp") String fDisp);
}
