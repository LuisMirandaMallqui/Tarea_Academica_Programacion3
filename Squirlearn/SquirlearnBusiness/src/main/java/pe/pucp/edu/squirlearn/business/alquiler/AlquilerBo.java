package pe.pucp.edu.squirlearn.business.alquiler;

import java.util.ArrayList;
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
    
   
    public Integer insertar(Integer personaId, Integer itemId, String inicio,
            String fin , Double monto, String usuarioCreacion){
        AlquilerDto alquilerDto = new AlquilerDto();
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        ItemDto item = new ItemDto();
        item.setItemId(itemId);
        
        alquilerDto.setPersona(persona);
        alquilerDto.setItem(item);
        alquilerDto.setFechaInicio(inicio);
        if(fin.compareTo("0")==0) fin=null;
        alquilerDto.setFechaFin(fin);
        alquilerDto.setMonto(monto);
        alquilerDto.setUsuarioCreacion(usuarioCreacion);
        alquilerDto.setDevuelto(Boolean.FALSE);
        
        return this.alquilerDao.insertar(alquilerDto);
    }
    
    public Integer Modificar(Integer id,Integer personaId, Integer itemId, String inicio,
            String fin , Double monto, Boolean devuelto){
        AlquilerDto alquilerDto = new AlquilerDto();
        
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        ItemDto item = new ItemDto();
        item.setItemId(itemId);
        
        alquilerDto.setPersona(persona);
        alquilerDto.setItem(item);
        if(fin.compareTo("0")==0) fin=null;
        alquilerDto.setFechaFin(fin);
        alquilerDto.setFechaInicio(inicio);
        alquilerDto.setMonto(monto);
        alquilerDto.setAlquilerId(id);
        alquilerDto.setDevuelto(devuelto);
        
        return this.alquilerDao.modificar(alquilerDto);
    }
    
    
    public ArrayList<AlquilerDto> listarPorDueno(Integer personaId){
        return this.alquilerDao.listarPorDueno(personaId); 
    }
    
    public AlquilerDto obtenerPorId(Integer id){
        return this.alquilerDao.obtenerPorId(id);
    }
    
    public ArrayList<AlquilerDto> listarTodos() {
        return (ArrayList<AlquilerDto>) this.alquilerDao.listarTodos();
    }
}
