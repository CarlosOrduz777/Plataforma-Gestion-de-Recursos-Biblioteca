package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Horario implements Serializable{

    private int idhorario;
    private int idusuario;
    private int idrecurso;
    private Date fecha;
    private Timestamp horainicial;
    private Timestamp horafinal;
    private String estado;
    private String recurrencia;
    private Date fecharecurrencia;



    public Horario() {
        super();
    }

    public Horario(int idhorario, int idusuario, int idrecurso, Date fecha, Timestamp horainicial, Timestamp horafinal, String estado, String recurrencia, Date fecharecurrencia) {
        this.idhorario = idhorario;
        this.idusuario = idusuario;
        this.idrecurso = idrecurso;
        this.fecha = fecha;
        this.horainicial = horainicial;
        this.horafinal = horafinal;
        this.estado = estado;
        this.recurrencia = recurrencia;
        this.fecharecurrencia = fecharecurrencia;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Horario{" +
                "idhorario=" + idhorario +
                ", idusuario=" + idusuario +
                ", idrecurso=" + idrecurso +
                ", fecha=" + fecha +
                ", horainicial=" + horainicial +
                ", horafinal=" + horafinal +
                ", estado='" + estado + '\'' +
                ", recurrencia='" + recurrencia + '\'' +
                ", fecharecurrencia=" + fecharecurrencia +
                '}';
    }
}
