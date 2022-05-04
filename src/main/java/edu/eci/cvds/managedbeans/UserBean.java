package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
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
	private String email;
	private String password;

	@Inject
	private ECIStuffServices eciStuffServices;




	public void createUser() throws Exception {
		try {
			eciStuffServices.createUsers();
		} catch (ServicesException ex) {
			throw new ServicesException(ex.getMessage());
		}
	}

	public void signIn() throws Exception{
		try{
			System.out.println("SIGNIN");
			eciStuffServices.signIn(email, password);
		}catch (ServicesException ex){
			throw ex;
		}
	}

	public void logOut() throws Exception{
		try {
			System.out.println("====================LOGOUT========================");
			eciStuffServices.logOut();
		}catch (ServicesException ex) {
			throw ex;
		}
	}

	public List<Booking> viewBookingUser() throws Exception{
		try{
			return eciStuffServices.viewBookingUser();
		}catch (ServicesException ex){
			throw ex;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println(email);
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println(password);
		this.password = password;
	}
}
