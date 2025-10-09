/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.inciNoti;

import pe.edu.pucp.squirlearn.dao.inciNoti.IncidenciaDao;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.IncidenciaDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

/**
 *
 * @author gabri
 */
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
    
    public Integer resolver(Integer id, Boolean resuelto, Integer solucionadorID, 
            Integer modicadorId){
        IncidenciaDto incidenciaDto = new IncidenciaDto();
        
        incidenciaDto.setIncidenciaDto(id);
        incidenciaDto.setResuelto(resuelto);
        incidenciaDto.setUsuarioModificacion(modicadorId);
        incidenciaDto.setUsuarioSolucion(solucionadorID);
        
        return this.incidenciaDao.resolver(incidenciaDto); //falta implementación
    }
}
