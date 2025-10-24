
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.TamañoDao;
import pe.edu.pucp.squirlearn.daoImpl.item.TamañoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.TamañoDto;

public class TamanoBo {
    
    private TamañoDao tamanoDao;
    
    public TamanoBo(){
        this.tamanoDao = new TamañoDaoImpl();
    }
    
    public ArrayList<TamañoDto> listarTodos(){
        return this.tamanoDao.listarTodos();
    }
    
    public TamañoDto obtenerPorId(Integer id){
        return this.tamanoDao.obtenerPorId(id);
    }
}
