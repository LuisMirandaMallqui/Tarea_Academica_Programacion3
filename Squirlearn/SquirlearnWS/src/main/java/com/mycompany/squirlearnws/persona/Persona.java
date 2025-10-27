/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.persona;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.pucp.edu.squirlearn.business.persona.PersonaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Persona")
public class Persona {

    private PersonaBo personaBo;
    
    public Persona(){
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
            @WebParam(name = "rol") Integer rol,
            @WebParam(name = "creadorId") Integer creadorId) {
        return this.personaBo.insertar(nombres, primerApellido, segundoApellido, codigo, correo, contrasena, rol, creadorId);
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
            @WebParam(name = "rol") Integer rol,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "fechaCreacion") Date fechaCreacion,
            @WebParam(name = "creadorId") Integer creadorId,
            @WebParam(name = "modificadorId") Integer modificadorId) {
        return this.personaBo.modificar(id, nombres, primerApellido, segundoApellido, codigo, correo, contrasena,
                rol, estadoId, fechaCreacion, creadorId, modificadorId);
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
