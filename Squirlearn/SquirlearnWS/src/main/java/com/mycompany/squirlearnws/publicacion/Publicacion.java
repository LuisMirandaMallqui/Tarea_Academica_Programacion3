package com.mycompany.squirlearnws.publicacion;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;
import pe.pucp.edu.squirlearn.business.publicacion.PublicacionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Publicacion")
public class Publicacion {

    private PublicacionBo publicacionBo;

    public Publicacion() {
        this.publicacionBo = new PublicacionBo();
    }

    @WebMethod(operationName = "insertarPublicacion")
    public Integer insertar(
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "usuario") String usuario) {
        return this.publicacionBo.insertar(itemId, personaId, usuario);
    }

    @WebMethod(operationName = "modificarPublicacion")
    public Integer modificarPublicacion(
            @WebParam(name = "publicacionId") Integer publicacionId,
            @WebParam(name = "fechaAlta") Date fechaAlta,
            @WebParam(name = "fechaBaja") Date fechaBaja,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "calificacion") Integer calificacion,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "usuarioCreacion") String usuarioCreacion) {
        return this.publicacionBo.modificar(publicacionId, fechaAlta, fechaBaja, estadoId, itemId,
                personaId, calificacion, usuarioCreacion,usuario);
    }

    @WebMethod(operationName = "listarPorEstadoPublicacion")
    public ArrayList<PublicacionDto> listarPorEstadoPublicacion(@WebParam(name = "estadoId") Integer estadoId) {
        return this.publicacionBo.listarPorEstado(estadoId);
    }

    @WebMethod(operationName = "listarPorDuenoPublicacion")
    public ArrayList<PublicacionDto> listarPorDuenoPublicacion(@WebParam(name = "personaId") Integer personaId) {
        return this.publicacionBo.listarPorDueno(personaId);
    }

    @WebMethod(operationName = "obtenerPorIdPublicacion")
    public PublicacionDto obtenerPorIdPublicacion(@WebParam(name = "id") Integer id) {
        return this.publicacionBo.obtenerPorId(id);
    }

    @WebMethod(operationName = "listarPorFiltrosPublicacion")
    public ArrayList<PublicacionDto> listarPorFiltrosPublicacion(
            @WebParam(name = "terminoBusqueda") String terminoBusqueda, // CON ITEM
            @WebParam(name = "esVenta") Boolean esVenta, // De ITEM
            @WebParam(name = "idCategoria") Integer idCategoria, // De ITEM
            @WebParam(name = "idSubcategoria") Integer idSubcategoria, // De ITEM
            @WebParam(name = "idColores") Integer idColores, // De ITEM
            @WebParam(name = "idTamanos") Integer idTamanos, // De ITEM
            @WebParam(name = "idFormatos") Integer idFormatos, // De ITEM
            @WebParam(name = "idCondicion") Integer idCondicion){ // De ITEM
//            @WebParam(name = "idEstado") Integer idEstado) { // De PUB
        return this.publicacionBo.listarPorFiltrosPublicacion(terminoBusqueda, esVenta, idCategoria, idSubcategoria, idColores,
                idTamanos, idFormatos, idCondicion);
    }
}