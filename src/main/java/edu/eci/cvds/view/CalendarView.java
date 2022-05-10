package edu.eci.cvds.view;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean(name = "calendarView")
@SessionScoped
public class CalendarView implements Serializable {

    private Date fecha;
    private String text3;
    private String text4;
    private int number;
    private String recurso;
    private Map<String, String> recursos;

    @PostConstruct
    public void init() {
        recursos = new HashMap<>();
        recursos.put("Sala", "Sala de estudio");
        recursos.put("Computo", "Equipo de computo");
        recursos.put("Multimedia", "Equipo multimedia");

    }



    public void increment() {
        number++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public Map<String, String> getRecursos() {
        return recursos;
    }

    public void setRecursos(Map<String, String> recursos) {
        this.recursos = recursos;
    }


}