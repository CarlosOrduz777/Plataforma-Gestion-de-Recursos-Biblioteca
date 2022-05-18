package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISHorarioDAO;
import edu.eci.cvds.services.ServiciosHorario;
import edu.eci.cvds.services.ServiciosReservar;
import edu.eci.cvds.services.impl.ServiciosHorarioImpl;
import edu.eci.cvds.services.impl.ServiciosReservarImpl;
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
                                                         bind(HorarioDAO.class).to(MyBATISHorarioDAO.class);
                                                         bind(ServiciosReservar.class).to(ServiciosReservarImpl.class);
                                                         bind(ServiciosHorario.class).to(ServiciosHorarioImpl.class);

                                                     }
                                                 }

        );
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}