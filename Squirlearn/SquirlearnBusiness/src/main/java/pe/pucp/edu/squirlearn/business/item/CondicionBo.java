/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.CondicionDao;
import pe.edu.pucp.squirlearn.daoImpl.item.CondicionDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;

/**
 *
 * @author gabri
 */
public class CondicionBo {
    
    private CondicionDao condicionDao;
    
    public CondicionBo(){
        this.condicionDao = new CondicionDaoImpl();
    }
    
    public ArrayList<CondicionDto> listarTodos(){
        return this.condicionDao.listarTodos();
    }
    
    public CondicionDto obtenerPorId(Integer id){
        return this.condicionDao.obtenerPorId(id);
    }
    
}
