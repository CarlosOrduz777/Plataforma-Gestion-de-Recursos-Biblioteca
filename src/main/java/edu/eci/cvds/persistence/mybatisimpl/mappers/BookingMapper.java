package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Booking;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface BookingMapper {
    public void registerBooking(@Param("fI") Date fechaInicio, @Param("fE") Date fechaFin,@Param("ui") int userId,@Param("ri") int resourceId);
    public Booking consultBooking(@Param("id") int id);
}
