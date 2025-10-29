
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.TamañoDao;
import pe.edu.pucp.squirlearn.daoImpl.item.TamañoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class TamanoBo {
    
    private TamañoDao tamanoDao;
    
    public TamanoBo(){
        this.tamanoDao = new TamañoDaoImpl();
    }
    
    public ArrayList<TamanoDto> listarTodos(){
        return this.tamanoDao.listarTodos();
    }
    
    public TamanoDto obtenerPorId(Integer id){
        return this.tamanoDao.obtenerPorId(id);
    }
}
