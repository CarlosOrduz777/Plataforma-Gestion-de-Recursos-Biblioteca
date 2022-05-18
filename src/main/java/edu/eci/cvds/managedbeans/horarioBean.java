package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.ServiciosHorario;
import edu.eci.cvds.services.ServicesException;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "horarioBean")
@SessionScoped
public class horarioBean extends BasePageBean {

    @Inject
    private ServiciosHorario serviciosHorario;



    private Horario horario;
    private List<Horario> added;

    /**
     * Retorna una lista con la informacion de los clientes almacenados en la base de datos
     * @return todos los clientes de la base de datos
     * @throws ServicesException
     */
    public horarioBean(){
        added = new ArrayList<Horario>();
    }

    public List<Horario> consultarHorarios() throws ServicesException {
        try {
            return serviciosHorario.consultarHorarios();
        } catch (Exception e) {
            throw new ServicesException("Error al consultar la tabla horarios");
        }
    }


    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}