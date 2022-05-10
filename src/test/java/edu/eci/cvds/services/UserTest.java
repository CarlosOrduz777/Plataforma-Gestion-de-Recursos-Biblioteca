package edu.eci.cvds.services;

import com.github.sdorra.shiro.ShiroRule;
import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.services.impl.ECIStuffServicesImpl;
import org.apache.shiro.SecurityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.github.sdorra.shiro.SubjectAware;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.when;

public class UserTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private SecurityUtils securityUtils;
    @InjectMocks
    private ECIStuffServicesImpl eciStuffServices;

    private User user;
    private Resource resource;
    private Booking booking;
    private Booking booking1;
    private Booking booking2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //User
        user = new User(1,"Francisco Rojas","Rojas-m", "Administrador");
        //Resource
        resource = new Resource(1, "R1", "Ubi", "si","Sala");
        //Bookings
        booking = new Booking(1,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId());
        booking1 = new Booking(2,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId());
        booking2 = new Booking(3,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId());
    }

    /**
     * Test for testViewBookingUser
     * Equivalence domain(null - notnull - Exception)
     */
    //notnull
    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testViewBookingUserNotNull() {
        try {
            when(userDAO.viewBookingUser(null)).thenReturn(Arrays.asList(booking, booking1, booking2));
            Assert.assertNotNull(eciStuffServices.viewBookingUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //null or <[]>
    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testViewBookingUserNull() {
        try {
            when(userDAO.viewBookingUser("None")).thenReturn(Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.viewBookingUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testViewBookingUserException() {
        try {
            when(userDAO.viewBookingUser("None")).thenReturn(Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.viewBookingUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Rule
    public ShiroRule rule = new ShiroRule();
}
