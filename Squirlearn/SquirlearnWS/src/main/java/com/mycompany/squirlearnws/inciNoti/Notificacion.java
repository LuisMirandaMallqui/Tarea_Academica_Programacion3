package com.mycompany.squirlearnws.inciNoti;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
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
            @WebParam(name = "motivoId") Integer motivoId) {
        return this.notificacionBo.insertar(mensaje, personaId, motivoId);
    }

    @WebMethod(operationName = "listarPorPersonaNotificacion")
    public ArrayList<NotificacionDto> listarPorPersonaNotificacion(
            @WebParam(name = "personaId") Integer personaId) {
        return this.notificacionBo.listarPorPersona(personaId);
    }

    @WebMethod(operationName = "obtenerPorIdNotificacion")
    public NotificacionDto obtenerPorIdNotificacion(
            @WebParam(name = "id") Integer id) {
        return this.notificacionBo.obtenerPorId(id);
    }

}
