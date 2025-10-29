package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface SubcategoriaDao extends IDAO<SubcategoriaDto>{
    
    ArrayList<SubcategoriaDto> listarPorCategoria(Integer categoriaId);
}
