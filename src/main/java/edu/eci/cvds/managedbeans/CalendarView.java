package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.ServiciosHorario;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "calendarView")
@ApplicationScoped
public class CalendarView extends BasePageBean {

    private Timestamp horainicial;
    private Timestamp horafinal;
    private String recurrencia;
    private Date fecharecurrencia;
    private Horario horario;

    @Inject
    private ServiciosHorario serviciosHorario;

    public List<Horario> getHorarios(){
        return serviciosHorario.consultarHorarios();
    }

    public Timestamp getHorainicial() {
        return horainicial;
    }

    public void setHorainicial(Timestamp horainicial) {
        this.horainicial = horainicial;
    }

    public Timestamp getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Timestamp horafinal) {
        this.horafinal = horafinal;
    }

    public String getRecurrencia() {
        return recurrencia;
    }

    public void setRecurrencia(String recurrencia) {
        this.recurrencia = recurrencia;
    }

    public Date getFecharecurrencia() {
        return fecharecurrencia;
    }

    public void setFecharecurrencia(Date fecharecurrencia) {
        this.fecharecurrencia = fecharecurrencia;
    }

    public Horario getHorario() { return horario; }

    public void setHorario(Horario horario) {  this.horario = horario;  }


    // Calendario
    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    private int eventId;

    public void loadEvents() {
        eventModel = new DefaultScheduleModel();
        List<Horario> horarios = serviciosHorario.consultarHorario(1);
        for (Horario h : horarios){
            event = new DefaultScheduleEvent("Reserva",h.getHorainicial(), h.getHorafinal());
            eventModel.addEvent(event);
            event.setId(String.valueOf(h.getIdhorario()));
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public int getEventId() {
        return eventId;
    }

    public int setEventId() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        return Integer.parseInt(request.getParameter("id"));
    }
}