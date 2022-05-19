package edu.eci.cvds.managedbeans;


import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@ManagedBean(name = "bookingBean")
@RequestScoped
public class BookingBean extends BasePageBean{
    private Date fechaInicio;
    private Date fechaFin;

    @Getter @Setter private String tipoReserva;
    @Inject
    private ECIStuffServices eciStuffServices;

    @Setter @Getter private Booking booking;

    public void registerBooking(Date fechaInicio, Date fechaFin,int userId,int resourceId,String tipoReserva) throws ServicesException, ParseException {
        try {

            long timeInMilliSeconds = fechaInicio.getTime();
            java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
            long timeInMilliSeconds2 = fechaFin.getTime();
            java.sql.Date date2 = new java.sql.Date(timeInMilliSeconds2);
            eciStuffServices.registerBooking(date1,date2,userId,resourceId,tipoReserva);
            eciStuffServices.changeResourceState(resourceId);
        }catch (Exception e){
            throw e;
        }
    }

    public Booking consultBooking() throws ServicesException {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("------------"+id+"---------------------");
            booking =  eciStuffServices.consultBooking(id);
            return booking;
        } catch (ServicesException ex) {
            throw new ServicesException(ex.getMessage());
        }
    }
    public String getInicioDisponibilidad(int idRecurso) throws ServicesException{
        try {
            System.out.println("--------------------"+idRecurso+"-----------------------");
            System.out.println("-----------"+eciStuffServices.getInicioDisponibilidad(idRecurso)+"-----------------");
            System.out.println("----------------------"+eciStuffServices.getInicioDisponibilidad(idRecurso).getiDisp()+"--------------------");
            System.out.println("-----------------"+eciStuffServices.getInicioDisponibilidad(idRecurso).getiDisp().toString()+"----------------------------");
            return eciStuffServices.getInicioDisponibilidad(idRecurso).getiDisp().toString();
        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }
    public String getFinDisponibilidad(int idRecurso) throws ServicesException{
        try {
            return eciStuffServices.getInicioDisponibilidad(idRecurso).getfDisp().toString();
        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }

    public Date addTwoHours(){
        if(fechaInicio != null){
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy : HH.mm");
            Calendar ahora = Calendar.getInstance();
            ahora.setTime(fechaInicio);
            ahora.add(Calendar.HOUR, 2);
            Date fecha = ahora.getTime();

            return fecha;
        }
        return new Date();
    }
    public void cancelBooking(int idBooking)throws ServicesException{
        try {
            eciStuffServices.cancelBooking(idBooking);
        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }


    public Date getFechaFin() {
        return fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void showErrors(String error){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", error));
    }
}
