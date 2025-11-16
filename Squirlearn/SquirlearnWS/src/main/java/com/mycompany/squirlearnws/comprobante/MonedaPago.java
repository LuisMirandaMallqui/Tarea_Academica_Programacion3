package com.mycompany.squirlearnws.comprobante;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;
import pe.pucp.edu.squirlearn.business.comprobante.MonedaPagoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "MonedaPago")
public class MonedaPago {

    private MonedaPagoBo monedaPagoBo;
    
    public MonedaPago(){
        this.monedaPagoBo = new MonedaPagoBo();
    }
    
    @WebMethod(operationName = "listarTodosMonedaPago")
    public ArrayList listarTodosMonedaPago() {
        return this.monedaPagoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdMonedaPago")
    public MonedaPagoDto obtenerPorIdMonedaPago(@WebParam(name = "id") Integer id) {
        return this.monedaPagoBo.obtenerPorId(id);
    }
}
