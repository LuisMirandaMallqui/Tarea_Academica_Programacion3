package com.mycompany.squirlearnws.inciNoti;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.squirlearn.model.inciNoti.ListadoNotificacionesDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.pucp.edu.squirlearn.business.inciNoti.NotificacionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Notificacion")
public class Notificacion {

    private NotificacionBo notificacionBo;
    
    public Notificacion(){
        this.notificacionBo = new NotificacionBo();
    }
    
    @WebMethod(operationName = "insertarNotificacion")
    public Integer insertarNotificacion(
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "personaId") Integer personaId, 
            @WebParam(name = "fecha") String fecha){
            
        return this.notificacionBo.insertar(mensaje, personaId,fecha);
    }
            

    @WebMethod(operationName = "listarPorPersonaNotificacion")
    public ListadoNotificacionesDto listarPorPersonaNotificacion(
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "pagina") Integer pagina,
            @WebParam(name = "registrosPorPagina") Integer registrosPorPagina) {
        return this.notificacionBo.listarPorPersona(personaId, pagina, registrosPorPagina);
    }

    @WebMethod(operationName = "obtenerPorIdNotificacion")
    public NotificacionDto obtenerPorIdNotificacion(
            @WebParam(name = "id") Integer id) {
        return this.notificacionBo.obtenerPorId(id);
    }

}
