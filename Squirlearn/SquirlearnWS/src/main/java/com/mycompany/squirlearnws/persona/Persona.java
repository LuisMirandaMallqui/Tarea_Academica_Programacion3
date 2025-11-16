package com.mycompany.squirlearnws.persona;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.Date;
//import jakarta.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.XMLGregorianCalendar;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.pucp.edu.squirlearn.business.persona.PersonaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Persona")
public class Persona {

    private PersonaBo personaBo;

    public Persona() {
        this.personaBo = new PersonaBo();
    }

    @WebMethod(operationName = "insertarPersona")
    public Integer insertarPersona(
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "primerApellido") String primerApellido,
            @WebParam(name = "segundoApellido") String segundoApellido,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "ultimaActividad") String actividadXML) {
//        Date actividadDate = null;
//        if (actividadXML != null) {
//            actividadDate = actividadXML.toGregorianCalendar().getTime();
//        }
        return this.personaBo.insertar(nombres, primerApellido, segundoApellido,
                codigo, correo, contrasena, usuario, actividadXML);
    }

    @WebMethod(operationName = "modificarPersona")
    public Integer modificarPersona(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "primerApellido") String primerApellido,
            @WebParam(name = "segundoApellido") String segundoApellido,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "usuarioCreacion") String usuarioCreacion,
            @WebParam(name = "ultimaActividad") String actividad) {

        return this.personaBo.modificar(id, nombres, primerApellido, segundoApellido, codigo, correo, contrasena,
                estadoId, usuarioCreacion, usuario, actividad);
    }

    @WebMethod(operationName = "logInPersona")
    public PersonaDto logInPersona(
            @WebParam(name = "correo") String correo,
            @WebParam(name = "contrasena") String contrasena) {
        return this.personaBo.logIn(correo, contrasena);
    }

    @WebMethod(operationName = "obtenerPorIdPersona")
    public PersonaDto obtenerPorIdPersona(
            @WebParam(name = "id") Integer id) {
        return this.personaBo.obtenerPorId(id);
    }

    @WebMethod(operationName = "obtenerPorCodigoPersona")
    public PersonaDto obtenerPorCodigoPersona(
            @WebParam(name = "codigo") String codigo) {
        return this.personaBo.obtenerPorCodigo(codigo);
    }

}
