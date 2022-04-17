package edu.eci.cvds.managedbeans;

import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "resourceBean")
@RequestScoped
public class ResourceBean extends BasePageBean{

    @Inject
    private ECIStuffServices eciStuffServices;

    private String nombre;
    private String ubicacion;
    private String tipo;
    private String capacidad;
    private String iDisp;
    private String fDisp;

    public void registerResource() throws ServicesException{
        try{
            eciStuffServices.registerResources(this.nombre, this.ubicacion, this.tipo, this.capacidad, this.iDisp, this.fDisp);
        }catch (ServicesException e){
            throw e;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getiDisp() {
        return iDisp;
    }

    public void setiDisp(String iDisp) {
        this.iDisp = iDisp;
    }

    public String getfDisp() {
        return fDisp;
    }

    public void setfDisp(String fDisp) {
        this.fDisp = fDisp;
    }
}
