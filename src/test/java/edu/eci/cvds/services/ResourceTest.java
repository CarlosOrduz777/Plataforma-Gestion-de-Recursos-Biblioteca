package edu.eci.cvds.services;

import com.github.sdorra.shiro.ShiroRule;
import com.github.sdorra.shiro.SubjectAware;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.ResourceDAO;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.impl.ECIStuffServicesImpl;
import org.apache.shiro.SecurityUtils;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class ResourceTest {
    @Mock
    private ResourceDAO resourceDAO;
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
        booking = new Booking(1,new java.util.Date(122, 5,3),
                new java.util.Date(122, 6,3), user.getId(),resource.getId(),"diaria");
        booking1 = new Booking(2,new java.util.Date(122, 5,3),
                new java.util.Date(122, 6,3), user.getId(),resource.getId(),"semanal");
        booking2 = new Booking(3,new java.util.Date(122, 5,3),
                new Date(122, 6,3), user.getId(),resource.getId(),"mensual");


    }

    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testConsultResources() {
        try {
            when(resourceDAO.consultResources()).thenReturn(Arrays.asList());
            Assert.assertNotNull(eciStuffServices.consultResources());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testConsultAllResources() {
        try {
            when(resourceDAO.consultAllResources()).thenReturn(Arrays.asList());
            Assert.assertNotNull(eciStuffServices.consultAllResources());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testResourceById() {
        try {
            when(resourceDAO.getResourceById(1)).thenReturn((Resource) Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.getResourceById(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ShiroRule rule = new ShiroRule();
}
