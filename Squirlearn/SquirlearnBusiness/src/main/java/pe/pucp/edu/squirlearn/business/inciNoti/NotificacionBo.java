
package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.inciNoti.NotificacionDao;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.NotificacionDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;


public class NotificacionBo {
    
    private NotificacionDao notificacionDao;
    
    public NotificacionBo(){
        this.notificacionDao = new NotificacionDaoImpl();
    }
    
    public Integer insertar(String mensaje, Integer personaId, Integer motivoId){
        NotificacionDto notificacionDto = new NotificacionDto();
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        MotivoDto motivo = new MotivoDto();
        motivo.setMotivoId(motivoId);
        
        notificacionDto.setMensaje(mensaje);
        notificacionDto.setMotivo(motivo);
        notificacionDto.setPersona(persona);
        return this.notificacionDao.insertar(notificacionDto);
    }
    
    public ArrayList<NotificacionDto> listarPorPersona(Integer personaID){
        return this.notificacionDao.listarPorPersona(personaID);
    }
    
    public NotificacionDto obtenerPorId(Integer id){
        return this.notificacionDao.obtenerPorId(id);
    }
}
