package edu.eci.cvds.managedbeans;

import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "resourceBean")
@RequestScoped
public class ResourceBean extends BasePageBean{

    @Inject
    private ECIStuffServices eciStuffServices;

    public void registerResource() throws ServicesException{
        try{
            eciStuffServices.registerResources();
        }catch (ServicesException e){
            throw  e;
        }
    }
}
