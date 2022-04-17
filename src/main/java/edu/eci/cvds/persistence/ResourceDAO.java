package edu.eci.cvds.persistence;

import edu.eci.cvds.services.ServicesException;
import org.apache.ibatis.exceptions.PersistenceException;

public interface ResourceDAO {
    public void registerResources(String nombre, String ubicacion, String tipo, String capacidad, String inicioDisp, String finDisp) throws PersistenceException;
}
