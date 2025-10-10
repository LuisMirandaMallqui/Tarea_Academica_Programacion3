
package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.comprobante.MonedaPagoDao;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.MonedaPagoDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;


public class MonedaPagoBo {
    
    private MonedaPagoDao monedaPagoDao;
    
    public MonedaPagoBo(){
        this.monedaPagoDao = new MonedaPagoDaoImpl();
    }
    
    public ArrayList<MonedaPagoDto> listarTodos(){
        return this.monedaPagoDao.listarTodos();
    }
    
    public MonedaPagoDto obtenerPorId(Integer id){
        return this.monedaPagoDao.obtenerPorId(id);
    }
    
}
