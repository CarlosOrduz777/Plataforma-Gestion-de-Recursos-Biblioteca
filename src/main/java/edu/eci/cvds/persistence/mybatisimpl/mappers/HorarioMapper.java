package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import edu.eci.cvds.entities.Horario;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author
 */
public interface HorarioMapper {

    /**
     * Consultar todos los horarios
     * @return
     */
    public List<Horario> consultarHorarios();

    public List<Horario> consultarHorario(@Param("id") int id);

    public void reservarRecurso(@Param("fecha") java.sql.Date fecha, @Param("horainicial") Timestamp horainicial, @Param("horafinal") Timestamp horafinal, @Param("idrecurso") int idrecurso, @Param("idusuario") int idusuario, @Param("recurrencia") String recurrencia, @Param("fecharecurrencia") Date fecharecurrencia, @Param("estado") String estado);

    public void reservarRecurso(@Param("fecha") java.sql.Date fecha, @Param("horainicial") Timestamp horainicial, @Param("horafinal") Timestamp horafinal, @Param("idrecurso") int idrecurso, @Param("idusuario") int idusuario, @Param("recurrencia") String recurrencia, @Param("fecharecurrencia") Date fecharecurrencia);



}
