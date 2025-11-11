package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.EstadoItemDao;
import pe.edu.pucp.squirlearn.daoImpl.item.EstadoItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;

/**
 *
 * @author gabri
 */
public class EstadoItemBo {
    
    private EstadoItemDao estadoItemDao;
    
    public EstadoItemBo(){
        this.estadoItemDao = new EstadoItemDaoImpl();
    }
    
    public ArrayList<EstadoItemDto> listarTodos(){
        return this.estadoItemDao.listarTodos();
    }
    
    public EstadoItemDto obtenerPorId(Integer id){
        return this.estadoItemDao.obtenerPorId(id);
    }
    
}
