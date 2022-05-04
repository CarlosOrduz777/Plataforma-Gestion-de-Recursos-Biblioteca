package edu.eci.cvds.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;

public interface BookingMapper {
    public void registerBooking(@Param("fI") Date fechaInicio, @Param("fE") Date fechaFin,@Param("ui") int userId,@Param("ri") int resourceId);
}
