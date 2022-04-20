package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.services.ECIStuffServices;
import edu.eci.cvds.services.ServicesException;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.sql.Date;
import java.text.SimpleDateFormat;

@ManagedBean(name = "resourceBean")
@RequestScoped
public class ResourceBean extends BasePageBean{

    @Inject
    private ECIStuffServices eciStuffServices;

    @Getter @Setter private String nombre;
    @Getter @Setter private String ubicacion;
    @Getter @Setter private String tipo;
    @Getter @Setter private String capacidad;
    @Getter @Setter private String iDisp;
    @Getter @Setter private String fDisp;

    public void registerResource() throws ServicesException{
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(iDisp);
            Date iDispSql = new Date(parsed.getTime());

            parsed = format.parse(fDisp);
            Date fDispSql = new Date(parsed.getTime());

            Resource resource = new Resource(this.nombre, this.ubicacion, this.capacidad, this.tipo , iDispSql, fDispSql);

            eciStuffServices.registerResources(resource);

            System.out.println("Recurso Agregado: " + resource.toString());

        }catch (Exception e){
            throw new ServicesException(e.getMessage());
        }
    }
}
