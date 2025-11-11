/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.persona.EstadoPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.persona.EstadoPersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;


/**
 *
 * @author gabri
 */
public class EstadoPersonaBo {
    
    private EstadoPersonaDao estadoPersonaDao;

    public EstadoPersonaBo() {
        this.estadoPersonaDao = new EstadoPersonaDaoImpl();
    }
    
    public ArrayList<EstadoPersonaDto> listarTodos(){
        return this.estadoPersonaDao.listarTodos();
    }
    
    public EstadoPersonaDto obtenerPorId(Integer id){
        return this.estadoPersonaDao.obtenerPorId(id);
    }
    
}
