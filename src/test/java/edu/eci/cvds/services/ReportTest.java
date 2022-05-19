package edu.eci.cvds.services;

import com.github.sdorra.shiro.ShiroRule;
import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
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

public class ReportTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private SecurityUtils securityUtils;
    @InjectMocks
    private ECIStuffServicesImpl eciStuffServices;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        //User
        User user = new User(1,"Francisco Rojas","Rojas-m", "Administrador");
        //Resource
        Resource resource = new Resource(1, "R1", "Ubi", 54,"Sala");

    }

    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testGetReportByResourceMan() {
        try {
            when(userDAO.getReportByResourceMan()).thenReturn(Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.getReportByResourceMan());
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
    public void testgetReportByResourceMen() {
        try {
            when(userDAO.getReportByResourceMen()).thenReturn(Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.getReportByResourceMen());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReportByResourceRec() {
        try {
            when(userDAO.getReportByResourceRec()).thenReturn(Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.getReportByResourceRec());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReportByResourceCan() {
        try {
            when(userDAO.getReportByResourceCan()).thenReturn(Arrays.asList());
            Assert.assertEquals(Arrays.asList(),eciStuffServices.getReportByResourceCan());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ShiroRule rule = new ShiroRule();
}

