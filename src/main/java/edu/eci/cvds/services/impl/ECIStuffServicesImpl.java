package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.ResourceDAO;

import java.util.List;

public class ECIStuffServicesImpl implements ECIStuffServices {

    @Inject
    private UserDAO userDAO;
    @Inject
    private ResourceDAO resourceDAO;

    public void createUsers() throws ServicesException {
        try {
            userDAO.create();
        } catch (PersistenceException e) {
            throw new ServicesException("No se puede crear Usuario", e);
        }
    }
    @Override
    public void signIn(String email, String password) throws ServicesException{
        System.out.println("--------ECIStuffServicesImpl--------");
        System.out.println("--------SignIn--------");
        Logger log = LoggerFactory.getLogger(ECIStuffServices.class);
        Subject currentUser = SecurityUtils.getSubject();
        // Do some stuff with a Session (no need for a web or EJB container!!!)
        Session session = currentUser.getSession();
        session.setAttribute("email", email);
        String value = (String) session.getAttribute("email");
        if (value.equals(email)) {
            log.info("Retrieved the correct value! [" + value + "]");
        }
        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(email, password);
            token.setRememberMe(true);
            log.info("Sale del IF authenticated");
            try {
                currentUser.login(token);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/pruebaEjemplo.xhtml");
                log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciales Incorrectas"));
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciales Incorrectas"));
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException | IOException ae) {
                //unexpected condition?  error?
                log.info(ae.getMessage());
            }
        }

        //say who they are:
        //print their identifying princip   al (in this case, a username):
        //log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        /*
        //test a role:
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //all done - log out!
        currentUser.logout();

        System.exit(0);
         */
            //throw new ServicesException("No se puede crear Usuario");
        }

    @Override
    public List<Resource> consultResources() throws ServicesException {
        try{
            return resourceDAO.consultResources();
        }catch (PersistenceException e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public void registerResources(Resource resource) throws ServicesException {
        try{
            resourceDAO.registerResources(resource);
        }catch (Exception e){
            throw new ServicesException("No se ha podido registrar el recurso", e);
        }
    }
}
