package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Bean para la interfaz de usuario de las decanaturas
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@ApplicationScoped
public class UserBean extends BasePageBean {
	private int idRecurso;
	private int idUser;
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
			System.out.println(email);
		}catch (ServicesException ex){
			throw ex;
		}
	}

	public String getEmail() {
		return email;
	}

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public User getUserIdByEmail(int idRecurso) throws ServicesException{
		this.idRecurso = idRecurso;
		System.out.println(this.idRecurso);
		System.out.println(this.email);
		try{

			User result = eciStuffServices.getUserIdByEmail(this.email);
			this.idUser = result.getId();
			System.out.println(result);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/reservarRecurso.xhtml");
			return result;
		}catch (Exception e){
			throw new ServicesException(e.getMessage());
		}
	}
}
