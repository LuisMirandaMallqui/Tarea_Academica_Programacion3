package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.persona.RolPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.persona.RolPersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;

public class RolPersonaBo {
    
    private RolPersonaDao rolPersonaDao;

    public RolPersonaBo() {
        this.rolPersonaDao = new RolPersonaDaoImpl();
    }
    
    
    public ArrayList<RolPersonaDto> listarTodos(){
        return this.rolPersonaDao.listarTodos();
    }
    
    public RolPersonaDto obtenerPorId(Integer id){
        return this.rolPersonaDao.obtenerPorId(id);
    }
    
    
}
