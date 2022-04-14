package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Bean para la interfaz de usuario de las decanaturas
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean extends BasePageBean {

	@Inject
	private ECIStuffServices eciStuffServices;

	public void createUser() throws Exception {
		try {
			eciStuffServices.createUsers();
		} catch (ServicesException ex) {
			throw ex;
		}
	}



}
