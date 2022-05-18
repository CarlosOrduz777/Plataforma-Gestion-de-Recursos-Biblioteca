package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Booking;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UserMapper;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class MyBatisUserDAOTest extends TestCase {
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private MyBatisUserDAO myBatisUserDAO;

    private User user;

    private Booking booking;
    private Booking booking1;
    private Booking booking2;

    @Before
    public void setUp() throws Exception {

        /**
         * super.setUp();
         *         MockitoAnnotations.initMocks(this);
         *         user = new User(1,"Francisco Rojas","Rojas-m", "Administrador");
         *         //Resource
         *         Resource resource = new Resource(1, "R1", "Ubi", "si","Sala");
         *         //Bookings
         *         booking = new Booking(1,new Date(122, 5,3),
         *                 new Date(122, 6,3), user.getId(),resource.getId());
         *         booking1 = new Booking(2,new Date(122, 5,3),
         *                 new Date(122, 6,3), user.getId(),resource.getId());
         *         booking2 = new Booking(3,new Date(122, 5,3),
         *                 new Date(122, 6,3), user.getId(),resource.getId());
         */

    }

    @Test
    /**
     * Test for testViewBookingUser
     * Equivalence domain(null - notnull - Exception)
     */
    //notnull
    public void testViewBookingUserNotNull() {
        try {
            when(userMapper.viewBookingUser("Rojas-m")).thenReturn(Arrays.asList(booking, booking1, booking2));
            System.out.println(user.getEmail());
            Assert.assertEquals(Arrays.asList(booking, booking1, booking2),
                    myBatisUserDAO.viewBookingUser(user.getEmail()));
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}