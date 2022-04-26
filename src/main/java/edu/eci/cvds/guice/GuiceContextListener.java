package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.ResourceDAO;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisResourceDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUserDAO;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.impl.ECIStuffServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.PostgreSQL);

				setEnvironmentId("development");

				setClassPathResource("mybatis-config.xml");

				// Hacer la inyeccion de dependencias
				bind(ResourceDAO.class).to(MyBatisResourceDAO.class);
				bind(ECIStuffServices.class).to(ECIStuffServicesImpl.class);
			}
		}

		);
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}