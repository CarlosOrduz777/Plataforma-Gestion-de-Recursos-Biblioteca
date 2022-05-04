package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Recurso;
import java.sql.Date;
import java.util.List;

public interface ServiciosAlquiler {


    public abstract Recurso consultarRecurso(int id) throws ExcepcionServiciosAlquiler;

    /**
     * @obj Consultar los items que tenga en su poder un cliente
     * @param idcliente identificador del cliente
     * @return el litado de detalle de los items rentados por el cliente
     * identificado con 'idcliente'
     * @throws ExcepcionServiciosAlquiler si el cliente no esta registrado
     */

    List<Recurso> consultarRecursosDisponibles() throws ExcepcionServiciosAlquiler;

    List<Recurso> consultarRecursosNoDisponibles() throws ExcepcionServiciosAlquiler;



    /**
     * @obj rejistrar el alkiler de un item
     * @pre numdias >=1
     * @param date fecha de rejistro del alquiler
     * @param docu identificacion de a quien se le cargara el alquiler
     * @param item el identificador del item a alquilar
     * @param numdias el numero de dias que se le prestara el item
     * @pos el item ya no debe estar disponible, y debe estar asignado al
     * cliente
     * @throws ExcepcionXX si el identificador no corresponde con un item, o si
     * el mismo ya esta alquilado
     */
    public abstract void registrarRecurso(Recurso p) throws ExcepcionServiciosAlquiler;




}