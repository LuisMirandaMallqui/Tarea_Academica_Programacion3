
package pe.pucp.edu.squirlearn.business.publicacion;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.PublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;


public class PublicacionBo {
    
    private PublicacionDao publicacionDao;
    
    public PublicacionBo (){
        this.publicacionDao = new PublicacionDaoImpl();
    }
    
    public Integer insertar(Integer itemId, Integer personaId){
        PublicacionDto publicacionDto= new PublicacionDto();
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(itemId);
        PersonaDto personaDto = new PersonaDto();
        personaDto.setPersonaId(personaId);
        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();
        estadoPublicacion.setEstadoPublicacionId(1);
        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        publicacionDto.setItem(itemDto);
        publicacionDto.setPersona(personaDto);
        return this.publicacionDao.insertar(publicacionDto);
    }
    
    public Integer modificar(Integer publicacionId, Integer estadoId, Integer calificacion){
        PublicacionDto publicacionDto= new PublicacionDto();
        publicacionDto.setPublicacionId(publicacionId);
        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();
        estadoPublicacion.setEstadoPublicacionId(estadoId);
        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        publicacionDto.setCalificacion(calificacion);
        return this.publicacionDao.modificar(publicacionDto);
    }
    
    public ArrayList<PublicacionDto> listarPorEstado(Integer estadoId){
        return this.publicacionDao.listarPorEstado(estadoId); //necesita implementación
    }
    
    public ArrayList<PublicacionDto> listarPorDueno(Integer personaId){
        return this.publicacionDao.listarPorEstado(personaId); //necesita implementación
    }
    
    public PublicacionDto obtenerPorId(Integer id){
        return this.publicacionDao.obtenerPorId(id);
    }
}
