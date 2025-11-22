package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.edu.pucp.squirlearn.dao.persona.PersonaDao;
import pe.edu.pucp.squirlearn.dao.persona.RolPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.persona.PersonaDaoImpl;
import pe.edu.pucp.squirlearn.daoImpl.persona.RolPersonaDaoImpl;
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
    private RolPersonaBo rolPersonaBo;
    
    public PersonaBo(){
        personaDao = new PersonaDaoImpl();
        rolPersonaBo = new RolPersonaBo();
    }
    
    public Integer insertar(String nombres, String primerApellido, String segundoApellido, 
            String codigo, String correo, String contrasena, String usuarioCreacion,String actividad){
        PersonaDto personaDto = new PersonaDto();
     
        EstadoPersonaDto estado = new EstadoPersonaDto();
        estado.setEstadoPersonaId(1);
        //aqui se cebe hacer el insert del rol de la persona en el DAO
        List<RolPersonaDto> roles = new ArrayList<RolPersonaDto>();
        RolPersonaDto rol = new RolPersonaDto();
        rol.setRolPersonaId(1);
        roles.add(rol);
        personaDto.setRolPersona(roles);
        personaDto.setNombres(nombres);
        personaDto.setPrimerApellido(primerApellido);
        personaDto.setSegundoApellido(segundoApellido);
        personaDto.setCodigo(codigo);
        personaDto.setCorreo(correo);
        personaDto.setContrasena(Cifrado.cifrarMD5(contrasena));  
        personaDto.setEstadoPersona(estado);
        personaDto.setusuarioCreacion(usuarioCreacion);
        personaDto.setusuarioModificacion(null);
        personaDto.setUltimaActividad(actividad);
        int result=0;
        PersonaDto per;
        if(!this.personaDao.existeUsuarioEnBD(personaDto)){
            result= this.personaDao.insertar(personaDto);
            per=this.personaDao.buscarPorCorreo(correo);
            this.rolPersonaBo.insertarTablaInter(1,per.getPersonaId());
        }
        
        return result;
    }
    
    public Integer modificar(Integer id, String nombres, String primerApellido, String segundoApellido, 
            String codigo, String correo, String contrasena,Integer estadoId ,
            String usuarioCreacion, String usuarioModificacion, String actividad){
        PersonaDto personaDto = new PersonaDto();
        
        personaDto.setContrasena(Cifrado.cifrarMD5(contrasena));
        EstadoPersonaDto estado = new EstadoPersonaDto();
        estado.setEstadoPersonaId(estadoId);
        
        personaDto.setPersonaId(id);
        personaDto.setNombres(nombres);
        personaDto.setPrimerApellido(primerApellido);
        personaDto.setSegundoApellido(segundoApellido);
        personaDto.setCodigo(codigo);
        personaDto.setCorreo(correo);
        personaDto.setEstadoPersona(estado);
        personaDto.setusuarioCreacion(usuarioCreacion);
        personaDto.setusuarioModificacion(usuarioModificacion);
        personaDto.setUltimaActividad(actividad);
        
        return this.personaDao.modificar(personaDto);
    }
    
    public PersonaDto logIn(String correo, String contrasena){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setCorreo(correo);
        PersonaDto perDto = this.personaDao.buscarPorCorreo(correo);
        if (perDto == null){
            System.out.println("No se encontro el usuario en la base de datos");
            return null;
        }
        if(Cifrado.descifrarMD5(perDto.getContrasena()).equals(contrasena))
            return perDto;
        else{
            System.out.println("No se pudo corroborar la contraseña");
            return null;
        }
    }
    
    public PersonaDto obtenerPorId(Integer id){
        return this.personaDao.obtenerPorId(id);
    }
    public ArrayList<PersonaDto> listarTodos(){
        return this.personaDao.listarTodos();
    }
    
    public PersonaDto obtenerPorCodigo(String codigo){
        return this.personaDao.obtenerPorCodigo(codigo); 
    }
}