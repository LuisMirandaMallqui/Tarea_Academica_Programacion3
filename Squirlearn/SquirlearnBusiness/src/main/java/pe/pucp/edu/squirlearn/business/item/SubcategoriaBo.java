/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.item.SubcategoriaDao;
import pe.edu.pucp.squirlearn.daoImpl.item.SubcategoriaDaoImpl;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;

/**
 *
 * @author gabri
 */
public class SubcategoriaBo {
    
    private SubcategoriaDao subcategoriaDao;
    
    public SubcategoriaBo(){
        this.subcategoriaDao = new SubcategoriaDaoImpl();
    }
    
    public ArrayList<SubcategoriaDto> listarPorCategoria(Integer categoriaId){
        return this.subcategoriaDao.listarPorCategoria(categoriaId);// necesita implementacion
    }
    
    public ArrayList<SubcategoriaDto> listarTodos(){
        return this.subcategoriaDao.listarTodos();
    }
    
    public SubcategoriaDto obtenerPorId(Integer id){
        return this.subcategoriaDao.obtenerPorId(id);
    }
    
}
