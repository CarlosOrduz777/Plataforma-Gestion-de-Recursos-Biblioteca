package edu.eci.cvds.samples.services;

public class ExcepcionServiciosVisualizar extends Exception {

    public static final String NO_RESOURCE_REGISTRED = "El recurso que se esta buscando no se encuentra registrado";

    public ExcepcionServiciosVisualizar(String message){
        super(message);
    }

    public ExcepcionServiciosVisualizar(String message, Exception e){
        super(message, e);
    }

}
