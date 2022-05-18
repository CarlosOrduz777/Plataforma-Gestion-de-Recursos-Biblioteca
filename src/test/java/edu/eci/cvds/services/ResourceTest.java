package edu.eci.cvds.services;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.services.ECIStuffServices;
import org.junit.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ResourceTest {
    @Inject
    ECIStuffServices eciStuffServices;

    Resource resource;

    public ResourceTest() {

    }

    @Before
    public void setUp() {
        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse("2022-03-01");
            Date inicio = new Date(parsed.getTime());

            parsed = format.parse("2022-03-20");
            Date fin = new Date(parsed.getTime());

            this.resource = new Resource("Nombre", "Ubicacion", "5", "sala", inicio, fin,false);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void registerResourceTest() {
        try{
            //int initialSize = eciStuffServices.consultResources().size();

            eciStuffServices.consultResources();

            //Assert.assertEquals(eciStuffServices.consultResources().size() , initialSize++);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeResourceStateTest(){
        try{

           List<Resource> result =  eciStuffServices.consultResources();
           Resource resource1 = result.get(0);

           int idResource = resource1.getId();
           boolean disponibilidad1 = resource1.isDisponible();
            eciStuffServices.changeResourceState(idResource);
            boolean disponibilidad2 = resource1.isDisponible();

           Assert.assertEquals(disponibilidad1,!disponibilidad2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
