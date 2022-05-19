package edu.eci.cvds.managedbeans;


import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Matchers.doubleThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class UserBeanTest extends TestCase {

    @Mock
    private ECIStuffServices eciStuffServices;
    @InjectMocks
    private UserBean userBean;

    private Booking booking;
    private Booking booking1;
    private Booking booking2;


    public void setUp() throws Exception {

        super.setUp();
        MockitoAnnotations.initMocks(this);
        User user = new User(1,"Francisco Rojas","Rojas-m", "Administrador");
        //Resource
        Resource resource = new Resource(1, "R1", "Ubi", 54,"Sala");
        //Bookings
        booking = new Booking(1,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"diaria");
        booking1 = new Booking(2,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"mensual");
        booking2 = new Booking(3,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"semanal");

    }

    /**
     * Test for testViewBookingUser
     * Equivalence domain(null - notnull - ServicesException )
     */
    //notnull
    public void testViewBookingUserNotnull() {
        try {
            when(eciStuffServices.viewBookingUser()).thenReturn(Arrays.asList(booking, booking1, booking2));
            userBean.viewBookingUser();
            assertNotNull(userBean.getBookingsUser());
        } catch (Exception e) {
            assertEquals("java.lang.NullPointerException",e.toString());
        }
    }
    //null
    public void testViewBookingUserNull() {
        try {
            when(eciStuffServices.viewBookingUser()).thenReturn(null);
            userBean.viewBookingUser();
            assertNull(userBean.getBookingsUser());
        } catch (Exception e) {
            assertEquals("java.lang.NullPointerException",e.toString());
        }
    }
    //ServicesException
    public void testViewBookingUserServicesException(){
        try {
            doThrow(ServicesException.class).when(eciStuffServices).viewBookingUser();
            userBean.viewBookingUser();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertEquals(e.toString(),"edu.eci.cvds.services.ServicesException");
        }
    }

    /**
     * Test for testUpdateBookingsUser
     * Equivalence domain(updated - notupdated - ServicesException)
     */
    //updated
    public void testUpdateBookingsUserUpdated() {
        try {
            when(eciStuffServices.viewBookingUser()).thenReturn(null);
            userBean.updateBookingsUser();
            Assert.assertNull(userBean.getBookingsUser());
            when(eciStuffServices.viewBookingUser()).thenReturn(Arrays.asList(booking, booking1, booking2));
            Assert.assertEquals(Arrays.asList(booking, booking1, booking2),userBean.getBookingsUser());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    //notupdated
    public void testUpdateBookingsUserNotUpdated() {
        try {
            when(eciStuffServices.viewBookingUser()).thenReturn(null);
            userBean.updateBookingsUser();
            Assert.assertNull(userBean.getBookingsUser());
            when(eciStuffServices.viewBookingUser()).thenReturn(null);
            assertFalse(Arrays.asList(booking, booking1, booking2).equals(userBean.getBookingsUser()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    //ServicesException
    public void testUpdateBookingsUserServicesException() {
        try {
            doThrow(ServicesException.class).when(eciStuffServices).viewBookingUser();
            userBean.updateBookingsUser();
        } catch(Exception e) {
            assertEquals("edu.eci.cvds.services.ServicesException", e.toString());
        }
    }
}