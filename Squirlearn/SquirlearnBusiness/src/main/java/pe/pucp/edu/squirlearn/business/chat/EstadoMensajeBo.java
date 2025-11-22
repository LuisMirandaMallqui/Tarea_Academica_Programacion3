package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.chat.EstadoMensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.EstadoMensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;

public class EstadoMensajeBo {
    
    private EstadoMensajeDao estadoMensajeDao;
    
    public EstadoMensajeBo(){
        this.estadoMensajeDao = new EstadoMensajeDaoImpl();
    }
    
    public ArrayList<EstadoMensajeDto> listarTodos(){
        return this.estadoMensajeDao.listarTodos();
    }
    
    public EstadoMensajeDto obtenerPorId(Integer id){
        return this.estadoMensajeDao.obtenerPorId(id);
    }
}
