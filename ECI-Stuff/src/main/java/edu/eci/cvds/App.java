package edu.eci.cvds;

import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.impl.ECIStuffServicesImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ServicesException {
        ECIStuffServicesImpl eciStuffServices = new ECIStuffServicesImpl();
        eciStuffServices.createUsers();
        System.out.println( "===== fin =====" );
    }
}
