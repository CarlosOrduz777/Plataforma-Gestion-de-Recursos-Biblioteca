package edu.eci.cvds.services;

import java.util.Date;

public interface ServiciosReservar {
    public void reservarRecurso(String fecha, String horainicial, String horafinal, int idrecurso, int idusuario, OpcionRecurrencia recurrencia, Date fecharecurrencia, String estado) throws ServicesException;


}
