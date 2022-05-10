package edu.eci.cvds.sampleprj.dao;

/**
 *
 */
public class PersistenceException extends Exception {

    /**
     * Genera una excepcion con el mensaje dado
     * @param message mensaje de la excepción lanzada
     */
    public PersistenceException(String message){
        super(message);
    }

    /**
     * Genera una excepcion con el mensaje dado y una excepción
     * @param message mensaje de la excepción lanzada
     * @param e excepción
     */
    public PersistenceException(String message, Exception e){
        super(message, e);
    }


}