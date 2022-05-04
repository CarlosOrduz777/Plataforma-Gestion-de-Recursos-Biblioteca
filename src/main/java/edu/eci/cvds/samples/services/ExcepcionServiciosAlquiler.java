package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception {

    public static final String NO_RESOURCE_REGISTRED = "El recurso que se esta buscando no se encuentra registrado";

    public ExcepcionServiciosAlquiler (String message){
        super(message);
    }

    public  ExcepcionServiciosAlquiler(String message, Exception e){
        super(message, e);
    }

}
