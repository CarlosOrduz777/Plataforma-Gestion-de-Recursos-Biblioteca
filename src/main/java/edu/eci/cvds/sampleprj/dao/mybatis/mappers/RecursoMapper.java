package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Recurso;

/**
 *
 * @author 2106913
 */
public interface RecursoMapper {

    public Recurso consultarRecurso(@Param("idrec") int id);

    /**
     * Insertar un recurso
     * @param recurso, Objeto recurso a insertar
     */
    public void insertarRecurso(@Param("rec") Recurso rec);


    /**
     * Consultar todos los recursos
     * @return
     */
    public List<Recurso> consultarRecursosDisponibles();

    public List<Recurso> consultarRecursosNoDisponibles();


}
