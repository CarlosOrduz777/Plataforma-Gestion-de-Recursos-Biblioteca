package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Horario;

import java.util.List;

public interface ServiciosHorario {


    public abstract Horario consultarHorario(int id) throws ExcepcionServiciosHorario;

    /**
     * @obj Consultar los items que tenga en su poder un cliente
     * @param idhorario identificador del cliente
     * @return el litado de detalle de los items rentados por el cliente
     * identificado con 'idcliente'
     * @throws ExcepcionServiciosHorario si el cliente no esta registrado
     */

    List<Horario> consultarHorariosDisponibles() throws ExcepcionServiciosHorario;




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
    public abstract void registrarHorario(Horario p) throws ExcepcionServiciosHorario;




}