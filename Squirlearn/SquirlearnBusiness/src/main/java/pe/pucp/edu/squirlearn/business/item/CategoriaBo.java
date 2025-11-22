
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.CategoriaDao;
import pe.edu.pucp.squirlearn.daoImpl.item.CategoriaDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;

public class CategoriaBo {
    
    private CategoriaDao categoriaDao;
    
    public CategoriaBo(){
        this.categoriaDao = new CategoriaDaoImpl();
    }
    
    public ArrayList<CategoriaDto> listarTodos(){
        return this.categoriaDao.listarTodos();
    }
    
    public CategoriaDto obtenerPorId(Integer id){
        return this.categoriaDao.obtenerPorId(id);
    }
}
