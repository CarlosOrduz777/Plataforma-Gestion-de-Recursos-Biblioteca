package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Horario implements Serializable{

    private int idhorario;

    private int idusuario;

    private int idrecurso;

    private Date fecha;

    private Time horainicial;

    private Time horafinal;



    public Horario() {
    }

    public Horario(int idhorario, int idusuario, int idrecurso, Date fecha, Time horainicial, Time horafinal) {
        this.idhorario = idhorario;
        this.idusuario = idusuario;
        this.idrecurso = idrecurso;
        this.fecha = fecha;
        this.horainicial = horainicial;
        this.horafinal = horafinal;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(int idrecurso) {
        this.idrecurso = idrecurso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHorainicial() {
        return horainicial;
    }

    public void setHorainicial(Time horainicial) {
        this.horainicial = horainicial;
    }

    public Time getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Time horafinal) {
        this.horafinal = horafinal;
    }
}
