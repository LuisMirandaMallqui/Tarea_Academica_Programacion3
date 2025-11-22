package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.chat.EstadoChatDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.EstadoChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

/**
 *
 * @author gabri
 */
public class EstadoChatBo {
    
    private EstadoChatDao estadoChatDao;
    
    public EstadoChatBo(){
        this.estadoChatDao = new EstadoChatDaoImpl();
    }
    
    public ArrayList<EstadoChatDto> listarTodos(){
        return this.estadoChatDao.listarTodos();
    }
    
    public EstadoChatDto obtenerPorId(Integer id){
        return this.estadoChatDao.obtenerPorId(id);
    }
    
}
