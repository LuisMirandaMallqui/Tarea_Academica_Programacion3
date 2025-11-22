/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public Integer obtenerId(String nombreMonedaBuscada ){
        
        ArrayList<EstadoItemDto> lista = estadoItemDao.listarTodos();
        EstadoItemDto encontrado = lista.stream()
            .filter(m -> (m.getNombre().toUpperCase()).equalsIgnoreCase(nombreMonedaBuscada))
            .findFirst()
            .orElse(null);
                
        return encontrado.getEstadoItemId();
    }
    
}
