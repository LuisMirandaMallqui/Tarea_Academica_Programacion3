package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import java.sql.Date;
import pe.edu.pucp.squirlearn.dao.inciNoti.IncidenciaDao;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.IncidenciaDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;


public class IncidenciaBo {
    
    private IncidenciaDao incidenciaDao;
    
    public IncidenciaBo(){
        this.incidenciaDao = new IncidenciaDaoImpl();
    }
    
    public Integer insertar(String descripcion, Integer notificcionId, Integer personaId,
            Integer motivoId, Integer creador){
        IncidenciaDto incidenciaDto = new IncidenciaDto();
        
        NotificacionDto notificacion = new NotificacionDto();
        notificacion.setNotificacionId(notificcionId);
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        MotivoDto motivo = new MotivoDto();
        motivo.setMotivoId(motivoId);
        
        incidenciaDto.setDescripcion(descripcion);
        incidenciaDto.setNotificacion(notificacion);
        incidenciaDto.setPersona(persona);
        incidenciaDto.setMotivo(motivo);
        incidenciaDto.setUsuarioCreacion(creador);
        
        return this.incidenciaDao.insertar(incidenciaDto);
    }
    
    public Integer modificar(Integer id,String descripcion , Date fechaCreacion, Date fechaSolucion, 
            Integer notificcionId, Integer personaId, Integer motivoId, Integer resuelto,
            Integer creadorId,Integer solucionadorID, Integer modicadorId){
        IncidenciaDto incidenciaDto = new IncidenciaDto();
        
        NotificacionDto notificacion = new NotificacionDto();
        notificacion.setNotificacionId(notificcionId);
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        MotivoDto motivo = new MotivoDto();
        motivo.setMotivoId(motivoId);
        
        incidenciaDto.setIncidenciaDto(id);
        incidenciaDto.setDescripcion(descripcion);
        incidenciaDto.setFechaCreacion(fechaCreacion);
        incidenciaDto.setFechaSolucion(fechaSolucion);
        incidenciaDto.setNotificacion(notificacion);
        incidenciaDto.setPersona(persona);
        incidenciaDto.setMotivo(motivo);
        incidenciaDto.setResuelto(resuelto);
        incidenciaDto.setUsuarioCreacion(creadorId);
        incidenciaDto.setUsuarioModificacion(modicadorId);
        incidenciaDto.setUsuarioSolucion(solucionadorID);
        
        return this.incidenciaDao.modificar(incidenciaDto); //falta implementación
    }
    
    
    public ArrayList<IncidenciaDto> listarPorResolucion(Boolean resuelto){
        return this.incidenciaDao.listarPorResolucion(resuelto); // necesita implementación
    }
    
    public IncidenciaDto obtenerPorId(Integer id){
        return this.incidenciaDao.obtenerPorId(id);
    }
}
