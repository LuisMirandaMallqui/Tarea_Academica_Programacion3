package pe.pucp.edu.squirlearn.business.item;

import pe.edu.pucp.squirlearn.dao.item.ItemDao;
import pe.edu.pucp.squirlearn.daoImpl.item.ItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.edu.pucp.squirlearn.model.item.ColorDto;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class ItemBo {
    
    private ItemDao itemDao;
    
    public ItemBo(){
        this.itemDao = new ItemDaoImpl();
    }
    
    public Integer insertar(Double precio, String nombre,String descripcion ,Boolean esVenta ,
            Integer colorId, Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId,String usuarioCreacion){
        ItemDto itemdto = new ItemDto();
        
        ColorDto color = new ColorDto();
        color.setColorId(colorId);
        CondicionDto condicion = new CondicionDto();
        condicion.setCondicionId(condicionId);
        TamanoDto tamano = new TamanoDto();
        tamano.setTamanoId(tamanoId);
        FormatoDto formato = new FormatoDto();
        formato.setFormatoId(formatoId);
        CategoriaDto categoria = new CategoriaDto();
        categoria.setCategoriaId(categoriaId);
        SubcategoriaDto subcategoria = new SubcategoriaDto();
        subcategoria.setSubcategoriaId(subcategoriaId);
        EstadoItemDto estado = new EstadoItemDto();
        estado.setEstadoItemId(1);
        
        itemdto.setPrecio(precio);
        itemdto.setNombre(nombre);
        itemdto.setDescripcion(descripcion);
        itemdto.setEsVenta(esVenta);
        itemdto.setColor(color);
        itemdto.setCondicion(condicion);
        itemdto.setTamano(tamano);
        itemdto.setFormato(formato);
        itemdto.setCategoria(categoria);
        itemdto.setSubcategoria(subcategoria);
        itemdto.setEstadoItem(estado);
        itemdto.setusuarioCreacion(usuarioCreacion);
        return this.itemDao.insertar(itemdto);
    }
    
    public Integer modificar(Integer id,Double precio,String nombre, String descripcion, Boolean esVenta ,
            Integer colorId, Integer estadoId ,Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId,String usuario,String usuarioCreacion,String usuarioModificacion){
        ItemDto itemdto = new ItemDto();
        
        ColorDto color = new ColorDto();
        color.setColorId(colorId);
        CondicionDto condicion = new CondicionDto();
        condicion.setCondicionId(condicionId);
        TamanoDto tamano = new TamanoDto();
        tamano.setTamanoId(tamanoId);
        FormatoDto formato = new FormatoDto();
        formato.setFormatoId(formatoId);
        CategoriaDto categoria = new CategoriaDto();
        categoria.setCategoriaId(categoriaId);
        SubcategoriaDto subcategoria = new SubcategoriaDto();
        subcategoria.setSubcategoriaId(subcategoriaId);
        EstadoItemDto estado = new EstadoItemDto();
        estado.setEstadoItemId(estadoId);
        
        itemdto.setItemId(id);
        itemdto.setPrecio(precio);
        itemdto.setNombre(nombre);
        itemdto.setDescripcion(descripcion);
        itemdto.setEsVenta(esVenta);
        itemdto.setColor(color);
        itemdto.setCondicion(condicion);
        itemdto.setTamano(tamano);
        itemdto.setFormato(formato);
        itemdto.setCategoria(categoria);
        itemdto.setSubcategoria(subcategoria);
        itemdto.setEstadoItem(estado);
        itemdto.setusuarioCreacion(usuarioCreacion);
        itemdto.setusuarioModificacion(usuarioModificacion);
        return this.itemDao.modificar(itemdto);
    }
    
    
    public ItemDto obtenerPorId(Integer id){
        return this.itemDao.obtenerPorId(id);
    }
    
    
}
