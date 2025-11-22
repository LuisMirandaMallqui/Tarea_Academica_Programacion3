
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.TamanoDao;
import pe.edu.pucp.squirlearn.daoImpl.item.TamanoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class TamanoBo {
    
    private TamanoDao tamanoDao;
    
    public TamanoBo(){
        this.tamanoDao = new TamanoDaoImpl();
    }
    
    public ArrayList<TamanoDto> listarTodos(){
        return this.tamanoDao.listarTodos();
    }
    
    public TamanoDto obtenerPorId(Integer id){
        return this.tamanoDao.obtenerPorId(id);
    }
}
