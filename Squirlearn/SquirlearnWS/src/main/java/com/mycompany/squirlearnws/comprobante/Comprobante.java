package com.mycompany.squirlearnws.comprobante;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.pucp.edu.squirlearn.business.comprobante.ComprobanteBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Comprobante")
public class Comprobante {

    private ComprobanteBo comprobanteBo;
    
    public Comprobante(){
        this.comprobanteBo = new ComprobanteBo();
    }
    
    @WebMethod(operationName = "insertarComprobante")//cambiando el insertar comprobante
    public Integer insertarComprobante(
            @WebParam(name = "monto") Double monto,
            @WebParam(name = "transaccionId") String transaccionId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "formaPagoId") String formaPago,
            @WebParam(name = "monedaId") String moneda,
            @WebParam(name = "impuesto") Double impuesto,
            @WebParam(name = "fechaEmision") String fechaEmision,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "alquilerId") Integer alquilerId,
            @WebParam(name = "nombreProducto") String nombreProducto) {
        return this.comprobanteBo.insertar(monto, transaccionId, personaId, formaPago, moneda, impuesto,fechaEmision,usuario,
                itemId,alquilerId,nombreProducto);
    }

    @WebMethod(operationName = "listarPorDuenoComprobante")
    public ArrayList listarPorDuenoComprobante(
            @WebParam(name = "personaId") Integer personaId) {
        return this.comprobanteBo.listarPorDueno(personaId);
    }

    @WebMethod(operationName = "obtenerPorIdComprobante")
    public ComprobanteDto obtenerPorIdComprobante(
            @WebParam(name = "id") Integer id) {
        return this.comprobanteBo.obtenerPorId(id);
    }
    
}
