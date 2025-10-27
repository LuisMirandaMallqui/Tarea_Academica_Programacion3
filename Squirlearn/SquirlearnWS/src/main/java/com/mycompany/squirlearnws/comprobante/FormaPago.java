
package com.mycompany.squirlearnws.comprobante;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;
import pe.pucp.edu.squirlearn.business.comprobante.FormaPagoBo;


@WebService(serviceName = "FormaPago")
public class FormaPago {

    private FormaPagoBo formaPagoBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList listarTodos() {
        return this.formaPagoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public FormaPagoDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.formaPagoBo.obtenerPorId(id);
    }
}
