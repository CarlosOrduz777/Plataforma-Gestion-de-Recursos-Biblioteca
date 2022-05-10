package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServiciosHorario;
import edu.eci.cvds.samples.services.ExcepcionServiciosHorario;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "HorarioBean")
@SessionScoped
public class horarioBean extends BasePageBean {

    @Inject
    private ServiciosHorario serviciosHorario;
    private Horario horario;
    private List<Horario> added;
    private List<Horario> horarios;

    /**
     * Retorna una lista con la informacion de los clientes almacenados en la base de datos
     * @return todos los clientes de la base de datos
     * @throws ExcepcionServiciosHorario
     */
    public horarioBean(){
        added = new ArrayList<Horario>();
    }

    public List<Horario> consultarHorariosDisponibles() throws ExcepcionServiciosHorario {
        try {
            horarios =  serviciosHorario.consultarHorariosDisponibles();
            System.out.println(horarios.get(0).getIdhorario());
            return horarios;
        } catch (Exception e) {
            throw new ExcepcionServiciosHorario("Error al consultar la tabla horarios");
        }
    }


    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}