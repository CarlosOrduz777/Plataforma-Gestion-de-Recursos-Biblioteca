package edu.eci.cvds.managedbeans;

import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "validatorBean")
@RequestScoped
public class ValidatorsBean {
    @Setter public String userMail;
    public void validateEmail(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
            String emailInserted = (String)arg2;
        if ((emailInserted).trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("Credencial correo vacía o nula verifiqué"));
        } else if(emailInserted.trim().length() < 3 ){
            throw new ValidatorException(new FacesMessage("Credencial correo muy corta, proporcione mas de 3 caracteres"));
        } else if(emailInserted.trim().length() > 60){
            throw new ValidatorException(new FacesMessage("Numero de caracteres exedidos en credencial correo"));
        }
    }
    public void validatePassword(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        String passwordInserted = (String)arg2;
        if ((passwordInserted).trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("Credencial contraseña vacía o nula verifiqué"));
        } else if(passwordInserted.trim().length() < 3 ){
            throw new ValidatorException(new FacesMessage("Credencial contraseña muy corta, proporcione mas de 3 caracteres"));
        } else if(passwordInserted.trim().length() > 60) {
            throw new ValidatorException(new FacesMessage("Numero de caracteres exedidos en credencial contraseña"));
        }
    }

    public void validateName(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        String name = (String)arg2;
        if ((name).trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("Nombre vacío"));
        } else if(name.trim().length() < 5 ){
            throw new ValidatorException(new FacesMessage("El nombre es muy corto(Min: 5 Caracteres)"));
        } else if(name.trim().length() > 50) {
            throw new ValidatorException(new FacesMessage("El nombre es muy extenso(Max: 50 Caracteres)"));
        }
    }

    public void validateUbi(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        String ubi = (String)arg2;
        if ((ubi).trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("Ubicación vacía"));
        }else if(ubi.trim().length() > 20) {
            throw new ValidatorException(new FacesMessage("La ubicación es muy extensa(Max: 20 Caracteres)"));
        }
    }

    public void validateDesc(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        String ubi = (String)arg2;
        if(ubi.trim().length() > 400) {
            throw new ValidatorException(new FacesMessage("La descripción es muy extenso(Max: 400 Caracteres)"));
        }
    }

    public void validateCapacity(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        String cap = (String) arg2;
        int capacity = Integer.parseInt(cap);
        if (capacity==0) {
            throw new ValidatorException(new FacesMessage("Capacidad nula"));
        }else if(capacity > 500) {
            throw new ValidatorException(new FacesMessage("La capacidad debe ser menor a 500"));
        }
    }

    public boolean authenticated() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()){
            return true;
        }
        return false;
    }
    public boolean notAuthenticated() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            return true;
        }
        return false;
    }
    public boolean isAdmin() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated() && currentUser.hasRole("Administrador")){
            return true;
        }
        return false;
    }
    public boolean isComunidad(){
        Subject currentUser = SecurityUtils.getSubject();
        if (!(currentUser.isAuthenticated() && currentUser.hasRole("Administrador"))){
            return true;
        }
        return false;
    }

    public String getUserMail(){
        Subject currentUser = SecurityUtils.getSubject();
        return (String) currentUser.getPrincipal();
    }
    public boolean authenticatedAndAdmin(){
        return authenticated() && isAdmin();
    }

}
