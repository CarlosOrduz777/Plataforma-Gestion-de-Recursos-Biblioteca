package edu.eci.cvds.services;

import com.github.sdorra.shiro.ShiroRule;
import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.BookingDAO;
import edu.eci.cvds.persistence.ResourceDAO;
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

public class BookingTest {
    @Mock
    private BookingDAO bookingDAO;
    @Mock
    private SecurityUtils securityUtils;
    @InjectMocks
    private ECIStuffServicesImpl eciStuffServices;

    private Booking booking;
    private Booking booking1;
    private Booking booking2;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        //User
        User user = new User(1,"Francisco Rojas","Rojas-m", "Administrador");
        //Resource
        Resource resource = new Resource(1, "R1", "Ubi", 54,"Sala");
        //Bookings
        booking = new Booking(1,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"diaria");
        booking1 = new Booking(2,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"semanal");
        booking2 = new Booking(3,new Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"mensual");


    }

    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testConsultBooking() {
        try {
            when(bookingDAO.consultBooking(1)).thenReturn(booking);
            Assert.assertNotNull(eciStuffServices.consultBooking(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ShiroRule rule = new ShiroRule();
}

