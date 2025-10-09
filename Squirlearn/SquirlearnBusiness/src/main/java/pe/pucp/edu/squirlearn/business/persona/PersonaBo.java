
package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.persona.PersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.persona.PersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;
import pe.pucp.edu.squirlearn.business.util.Cifrado;

/**
 *
 * @author gabri
 */
public class PersonaBo {
    
    private PersonaDao personaDao;
    
    public PersonaBo(){
        personaDao = new PersonaDaoImpl();
    }
    
    public Integer insertar(String nombres, String primerApellido, String segundoApellido, 
            String codigo, String correo, String contrasena, Integer rol){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setNombres(nombres);
        personaDto.setPrimerApellido(primerApellido);
        personaDto.setSegundoApellido(segundoApellido);
        personaDto.setCodigo(codigo);
        personaDto.setCorreo(correo);
        personaDto.setContrasena(contrasena);
        RolPersonaDto rolPersona = new RolPersonaDto();
        rolPersona.setRolPersonaId(rol);
        personaDto.setRolPersona(rolPersona);
        EstadoPersonaDto estado = new EstadoPersonaDto();
        estado.setEstadoPersonaId(1);
        personaDto.setEstadoPersona(estado);
        
        return this.personaDao.insertar(personaDto);
    }
    
    public Integer modificar(Integer id, String correo, String contrasena,Integer estadoPersona
            , Integer idModifcador){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setPersonaId(id);
        personaDto.setCorreo(correo);
        personaDto.setContrasena(Cifrado.cifrarMD5(contrasena));
        EstadoPersonaDto estado = new EstadoPersonaDto();
        estado.setEstadoPersonaId(estadoPersona);
        personaDto.setEstadoPersona(estado);
        personaDto.setUsuarioModificacion(idModifcador);
        
        return this.personaDao.modificar(personaDto);
    }
    
    public ArrayList<PersonaDto> listarPorEstado(Integer estadoId){
        return this.personaDao.listarPorEstado(Integer estadoId); //necesita implementación
    }
    
    public PersonaDto logIn(String correo, String contrasena){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setCorreo(correo);
        this.personaDao.buscarPorCorreo(correo);//necesita implementación
        if(Cifrado.descifrarMD5(personaDto.getContrasena()).equals(contrasena))
            return personaDto;
        else
            return null;
    }
    
    public PersonaDto obtenerPorId(Integer id){
        return this.personaDao.obtenerPorId(id);
    }
    
    public PersonaDto obtenerPorCodigo(String codigo){
        return this.personaDao.obtenerPorCodigo(codigo); //necesita implementación 
    }
}
