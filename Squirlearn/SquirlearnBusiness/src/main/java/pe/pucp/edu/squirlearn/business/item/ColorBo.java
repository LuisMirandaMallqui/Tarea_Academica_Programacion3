
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.ColorDao;
import pe.edu.pucp.squirlearn.daoImpl.item.ColorDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ColorDto;


public class ColorBo {
    
    private ColorDao colorDao;
    
    public ColorBo(){
        this.colorDao = new ColorDaoImpl();
    }
    
    public ArrayList<ColorDto> listarTodos(){
        return this.colorDao.listarTodos();
    }
    
    public ColorDto obtenerPorId(Integer id){
        return this.colorDao.obtenerPorId(id);
    }
    
}
