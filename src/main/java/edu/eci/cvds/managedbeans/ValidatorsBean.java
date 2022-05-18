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

}
