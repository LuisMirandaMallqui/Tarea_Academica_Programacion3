/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.comprobante.DetalleComprobanteDao;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.DetalleComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

/**
 *
 * @author gabri
 */
public class DetalleComprobanteBo {
    
    private DetalleComprobanteDao detalleComprobanteDao;
    
    public DetalleComprobanteBo(){
        this.detalleComprobanteDao = new DetalleComprobanteDaoImpl();
    }
    
    public Integer insertar(String descripcion, Double precio, Integer itemId,
            Integer alquilerId, Integer comprobanteId, String usuario){
        DetalleComprobanteDto detalleComprobanteDto = new DetalleComprobanteDto();
        
        ItemDto item = new ItemDto();
        item.setItemId(itemId);
        AlquilerDto alquiler = new AlquilerDto();
        alquiler.setAlquilerId(alquilerId);
        ComprobanteDto comprobante = new ComprobanteDto();
        comprobante.setComprobanteId(comprobanteId);
        
        detalleComprobanteDto.setDescripcion(descripcion);
        detalleComprobanteDto.setPrecio(precio);
        detalleComprobanteDto.setItem(item);
        detalleComprobanteDto.setAlquiler(alquiler);
        detalleComprobanteDto.setComprobante(comprobante);
        detalleComprobanteDto.setUsuario(usuario);
        
        return this.detalleComprobanteDao.insertar(detalleComprobanteDto);
    }
    
    public ArrayList<DetalleComprobanteDto> listarPorComprobante(Integer comprabanteId){
        return this.detalleComprobanteDao.listarPorComprobante(comprabanteId); // necesita implementación
    }
    
    public DetalleComprobanteDto obtenerPorId(Integer id){
        return this.detalleComprobanteDao.obtenerPorId(id);
    }
}
