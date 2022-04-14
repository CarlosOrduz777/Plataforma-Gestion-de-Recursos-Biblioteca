package edu.eci.cvds.managedbeans;

import com.google.inject.Injector;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.Serializable;

public abstract class BasePageBean implements Serializable {

	private static final long serialVersionUID = -2084921068710522276L;
	private Injector injector;

	public Injector getInjector() {
		if (injector == null) {
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			injector = (Injector) servletContext.getAttribute(Injector.class.getName());
		}
		return injector;
	}

	public void setInjector(Injector injector) {
		this.injector = injector;
	}

	@PostConstruct
	public void init() {
		getInjector().injectMembers(this);
	}
}