package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.FormatoDao;
import pe.edu.pucp.squirlearn.daoImpl.item.FormatoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;

/**
 *
 * @author gabri
 */
public class FormatoBo {
    
    private FormatoDao formatoDao;
    
    public FormatoBo(){
        this.formatoDao = new FormatoDaoImpl();
    }
    
    public ArrayList<FormatoDto> listarTodos(){
        return this.formatoDao.listarTodos();
    }
    
    public FormatoDto obtenerPorId(Integer id){
        return this.formatoDao.obtenerPorId(id);
    }
    
}
