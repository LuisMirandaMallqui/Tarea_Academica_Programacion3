
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
    
    public FormaPago(){
        this.formaPagoBo = new FormaPagoBo();
    }
    
    @WebMethod(operationName = "listarTodosFormaPago")
    public ArrayList listarTodosFormaPago() {
        return this.formaPagoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdFormaPago")
    public FormaPagoDto obtenerPorIdFormaPago(@WebParam(name = "id") Integer id) {
        return this.formaPagoBo.obtenerPorId(id);
    }
}
