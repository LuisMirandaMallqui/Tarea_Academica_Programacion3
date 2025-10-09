package pe.pucp.edu.squirlearn.business.alquiler;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.squirlearn.dao.alquiler.AlquilerDao;
import pe.edu.pucp.squirlearn.daoImpl.alquiler.AlquilerDaoImpl;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class AlquilerBo {
    
    private AlquilerDao alquilerDao;
    
    public AlquilerBo(){
        this.alquilerDao = new AlquilerDaoImpl();
    }
    
    public Integer insertar(Integer personaId, Integer itemId, Date inicio,
            Date fin , Double monto){
        AlquilerDto alquilerDto = new AlquilerDto();
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        ItemDto item = new ItemDto();
        item.setItemId(itemId);
        
        alquilerDto.setPersona(persona);
        alquilerDto.setItem(item);
        alquilerDto.setFechaFin(fin);
        alquilerDto.setFechaInicio(inicio);
        alquilerDto.setMonto(monto);
        alquilerDto.setUsuarioCreacion(personaId);
        alquilerDto.setDevuelto(Boolean.FALSE);
        
        return this.alquilerDao.insertar(alquilerDto);
    }
    
    public Integer devolver(Integer id, Integer modificiadorId){
        AlquilerDto alquilerDto = new AlquilerDto();
        
        alquilerDto.setAlquilerId(id);
        alquilerDto.setUsuarioModificacion(modificiadorId);
        alquilerDto.setDevuelto(Boolean.TRUE);
        
        return this.alquilerDao.devolver(alquilerDto);// falta implementación
    }
    
    
    public ArrayList<AlquilerDto> listarPorDueno(Integer personaId){
        return this.alquilerDao.listarPorDueno(personaId); // falta implementación
    }
    
    public AlquilerDto obtenerPorId(Integer id){
        return this.alquilerDao.obtenerPorId(id);
    }
}
