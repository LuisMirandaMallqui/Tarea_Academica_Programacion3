package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.inciNoti.MotivoDao;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.MotivoDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;

public class MotivoBo {
    
    private MotivoDao motivoDao;
    
    public MotivoBo(){
        this.motivoDao = new MotivoDaoImpl();
    }
    
    public ArrayList<MotivoDto> listarTodos(){
        return this.motivoDao.listarTodos();
    }
    
    public MotivoDto obtenerPorId(Integer id){
        return this.motivoDao.obtenerPorId(id);
    }
    
}
