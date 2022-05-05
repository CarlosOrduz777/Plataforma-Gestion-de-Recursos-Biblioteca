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
        if (((String)arg2).trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("Credencial correo vacía o nula verifiqué"));
        }
    }
    public void validatePassword(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        if (((String)arg2).trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("Credencial contraseña vacía o nula verifiqué"));
        }
    }
}
