package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Horario;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author
 */
public interface HorarioMapper {

    public Horario consultarHorario(@Param("id") int id);

    /**
     * Insertar un horario
     * @param horario, Objeto recurso a insertar
     */
    public void insertarHorario(@Param("hor") Horario hor);


    /**
     * Consultar todos los recursos
     * @return
     */
    public List<Horario> consultarHorariosDisponibles();



}
