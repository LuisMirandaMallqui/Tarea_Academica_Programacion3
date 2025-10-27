
package com.mycompany.squirlearnws.alquiler;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.pucp.edu.squirlearn.business.alquiler.AlquilerBo;


@WebService(serviceName = "Alquiler")
public class Alquiler {

    private AlquilerBo alquilerBo;
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "id")Integer personaId,@WebParam(name = "itemId") Integer itemId, @WebParam(name = "fechaInicio")Date inicio,
            @WebParam(name = "fechaFin") Date fin , @WebParam(name = "monto") Double monto){
        return this.alquilerBo.insertar(personaId, itemId, inicio, fin, monto);
    }
    
    @WebMethod(operationName = "modificar")
    public Integer Modificar(@WebParam(name = "id") Integer id,@WebParam(name = "personaId") Integer personaId, @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "fechaInicio") Date inicio,@WebParam(name = "fechaFin") Date fin ,@WebParam(name = "monto") Double monto,
            @WebParam(name = "modificadorId") Integer modificiadorId, @WebParam(name = "devuelto") Boolean devuelto, @WebParam(name = "fechaCreacion")Date creacion,
            @WebParam(name = "creadorId") Integer creador){
        return this.alquilerBo.Modificar(id, personaId, itemId, inicio, fin, monto, modificiadorId, devuelto, creacion, creador);
    }
    
    @WebMethod(operationName = "listarPorDueno")
    public ArrayList<AlquilerDto> listarPorDueno(@WebParam(name = "personaId") Integer personaId){
        return this.alquilerBo.listarPorDueno(personaId);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public AlquilerDto obtenerPorId(@WebParam(name = "id") Integer id){
        return this.alquilerBo.obtenerPorId(id);
    }
    
}
