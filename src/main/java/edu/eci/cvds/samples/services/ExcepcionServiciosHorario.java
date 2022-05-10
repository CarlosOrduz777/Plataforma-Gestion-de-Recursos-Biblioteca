package edu.eci.cvds.samples.services;

public class ExcepcionServiciosHorario extends Exception {

    public static final String NO_RESOURCE_REGISTRED = "El horario que se esta buscando no se encuentra registrado";

    public ExcepcionServiciosHorario(String message){
        super(message);
    }

    public ExcepcionServiciosHorario(String message, Exception e){
        super(message, e);
    }

}
