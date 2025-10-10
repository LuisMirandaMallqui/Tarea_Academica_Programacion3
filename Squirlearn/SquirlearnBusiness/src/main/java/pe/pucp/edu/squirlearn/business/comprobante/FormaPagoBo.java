
package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.comprobante.FormaPagoDao;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.FormaPagoDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;

public class FormaPagoBo {
    
    private FormaPagoDao formaPagoDao;
    
    public FormaPagoBo(){
        this.formaPagoDao = new FormaPagoDaoImpl();
    }
    
    public ArrayList<FormaPagoDto> listarTodos(){
        return this.formaPagoDao.listarTodos();
    }
    
    public FormaPagoDto obtenerPorId(Integer id){
        return this.formaPagoDao.obtenerPorId(id);
    }
}
