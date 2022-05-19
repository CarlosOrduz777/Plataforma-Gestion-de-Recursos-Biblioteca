package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Report;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.BookingDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import lombok.Generated;
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

import java.sql.Date;
import java.util.List;

public class ECIStuffServicesImpl implements ECIStuffServices {

    @Inject
    private UserDAO userDAO;
    @Inject
    private ResourceDAO resourceDAO;
    @Inject
    private BookingDAO bookingDAO;

    private final static Logger log = LoggerFactory.getLogger(ECIStuffServices.class);

    @Override
    @lombok.Generated
    public void signIn(String email, String password) throws ServicesException{
        System.out.println("--------ECIStuffServicesImpl--------");
        System.out.println("--------SignIn--------");
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
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
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
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

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
    @lombok.Generated
    public  void logOut() throws ServicesException{
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public List<Resource> consultAllResources() throws ServicesException {
        try{
            return resourceDAO.consultAllResources();
        }catch (PersistenceException e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public void registerResources(Resource resource) throws ServicesException {
        try{
            resourceDAO.registerResources(resource);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/consultarRecursos.xhtml");
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido registrar el recurso"));
            log.info("No se ha podido registrar el recurso");
            throw new ServicesException("No se ha podido registrar el recurso", e);
        }
    }

    @Override
    public void registerBooking(Date fechaInicio, Date fechaFin,int userId,int resourceId,String tipoReserva) throws ServicesException {
        try{
            bookingDAO.registerBooking(fechaInicio,fechaFin,userId,resourceId,tipoReserva);
        }catch (Exception e){
            throw new ServicesException("No se ha podido registrar la reserva", e);
        }
    }

    @Override
    public Booking consultBooking(int id) throws ServicesException {
        try{
            Booking booking = bookingDAO.consultBooking(id);
            User user = getUserById(booking.getUsuario_id());
            Resource resource = getResourceById(booking.getRecurso_id());
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            Booking bookingDetail;
            if (currentUser.hasRole("Administrador")){
                bookingDetail = new Booking(booking, user.getNombre(), user.getEmail(), resource.getNombre(), resource.getUbicacion(), resource.getTipo());
            }else{
                bookingDetail = new Booking(booking, resource.getNombre(), resource.getUbicacion(), resource.getTipo());
            }
            return bookingDetail;
        }catch (PersistenceException e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public Resource getResourceById(int id) throws ServicesException {
        try{
            return resourceDAO.getResourceById(id);
        }catch (PersistenceException e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public User getUserById(int id) throws ServicesException {
        try{
            return userDAO.getUserById(id);
        }catch (PersistenceException e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public User getUserIdByEmail(String email) throws ServicesException {
        try{
            return userDAO.getUserIdByEmail(email);
        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Booking> viewBookingUser() throws ServicesException{
        try{
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            List<Booking> bookings = userDAO.viewBookingUser((String) session.getAttribute("email"));
            System.out.println('[');
            for (Booking b: bookings) {
                System.out.print(b);
                System.out.print(", ");
            }
            System.out.print(']');
            return bookings;
        }catch (Exception e){
            throw new ServicesException("No se ha podido traer Reservas para el usuario Actual", e);
        }
    }

    @Override
    public Resource getInicioDisponibilidad(int idRecurso) throws ServicesException {
        try{
            return bookingDAO.getInicioDisponibilidad(idRecurso);
        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public void changeResourceState(int idResource) throws ServicesException {
        try{
           resourceDAO.changeResourceState(idResource);
        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Report> getReportByAdmin() {
        return userDAO.getReportByAdmin();
    }
}
