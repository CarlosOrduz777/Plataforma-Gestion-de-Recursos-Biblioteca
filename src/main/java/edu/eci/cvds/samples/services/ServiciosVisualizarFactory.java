package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISRecursoDAO;
import edu.eci.cvds.samples.services.impl.ServiciosVisualizarImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosVisualizarFactory {

    private static ServiciosVisualizarFactory instance = new ServiciosVisualizarFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
                bind(ServiciosVisualizar.class).to(ServiciosVisualizarImpl.class);
            }
        });
    }

    private ServiciosVisualizarFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosVisualizar getServiciosAlquiler(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosVisualizar.class);
    }


    public ServiciosVisualizar getServiciosAlquilerTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosVisualizar.class);
    }


    public static ServiciosVisualizarFactory getInstance(){
        return instance;
    }

}