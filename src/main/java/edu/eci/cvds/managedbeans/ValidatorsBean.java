package edu.eci.cvds.managedbeans;

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
}
