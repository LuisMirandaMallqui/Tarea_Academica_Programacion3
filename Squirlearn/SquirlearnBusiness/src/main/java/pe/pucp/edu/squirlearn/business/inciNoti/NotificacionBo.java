package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.inciNoti.NotificacionDao;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.NotificacionDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.ListadoNotificacionesDto;

import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class NotificacionBo {

    private NotificacionDao notificacionDao;

    public NotificacionBo() {
        this.notificacionDao = new NotificacionDaoImpl();
    }

    public Integer insertar(String mensaje, Integer personaId,String fecha) {
        NotificacionDto notificacionDto = new NotificacionDto();

        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);

        notificacionDto.setMensaje(mensaje);
        notificacionDto.setPersona(persona);
        notificacionDto.setFecha(fecha);
        return this.notificacionDao.insertar(notificacionDto);
    }
    
    public ListadoNotificacionesDto listarPorPersona(Integer personaID, Integer pagina, Integer registrosPorPagina){
        
        ListadoNotificacionesDto listado = new ListadoNotificacionesDto();
        listado.setLista(this.notificacionDao.listarPorPersona(personaID, pagina, registrosPorPagina));
        listado.setTotalRegistros(this.notificacionDao.listarPorPersonaCantidad(personaID)); // VA PAGINACION?
        
        return listado;
    }

    public NotificacionDto obtenerPorId(Integer id) {
        return this.notificacionDao.obtenerPorId(id);
    }
}
