package pe.pucp.edu.squirlearn.business.publicacion;

import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.PublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.daoImpl.item.ItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.edu.pucp.squirlearn.model.item.ColorDto;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;


public class PublicacionBo {
    
    private PublicacionDao publicacionDao;
    private ItemDaoImpl itemDao;
    
    public PublicacionBo (){
        this.publicacionDao = new PublicacionDaoImpl();
        this.itemDao = new ItemDaoImpl();
    }
    
    public Integer insertar(Integer itemId, Integer personaId, String usuarioCreacion,
            Double precio, String nombre,String descripcion ,Boolean esVenta ,
            Integer colorId, Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId) {
        
        PublicacionDto publicacionDto = new PublicacionDto();
        //Instanciar un item
        ItemDto itemdto = new ItemDto();
        itemdto.setItemId(itemId);
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
        //Asignar atributos item
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
        
        //Asignar atributos publicacion
        PersonaDto personaDto = new PersonaDto();
        personaDto.setPersonaId(personaId);
        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();
        estadoPublicacion.setEstadoPublicacionId(1);

        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        publicacionDto.setItem(itemdto);
        publicacionDto.setPersona(personaDto);
        publicacionDto.setusuarioCreacion(usuarioCreacion);
        
        return this.publicacionDao.insertar(publicacionDto) + this.itemDao.insertar(itemdto);
    }
    
    public Integer modificar(Integer publicacionId, String fechaAlta, String fechaBaja, 
            Integer estadoId, Integer itemId, Integer personaId, Integer calificacion, 
            String usuarioCreacion, String usuarioModificacion) {
        
        PublicacionDto publicacionDto = new PublicacionDto();
        

        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();
        estadoPublicacion.setEstadoPublicacionId(estadoId);
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(itemId);
        PersonaDto personaDto = new PersonaDto();
        personaDto.setPersonaId(personaId);

        publicacionDto.setPublicacionId(publicacionId);
        publicacionDto.setFechaAlta(fechaAlta);
        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        publicacionDto.setItem(itemDto);
        publicacionDto.setPersona(personaDto);
        publicacionDto.setCalificacion(calificacion);
        publicacionDto.setusuarioCreacion(usuarioCreacion);
        publicacionDto.setusuarioModificacion(usuarioModificacion);

        return this.publicacionDao.modificar(publicacionDto);
    }
     public ArrayList<PublicacionDto> listarPorEstado(Integer estadoId) {
        return this.publicacionDao.listarPorEstado(estadoId); //necesita implementación
    }

//    public ArrayList<PublicacionDto> listarPorFiltrosPublicacion(String terminoBusqueda, Boolean esVenta,
//            Integer idCategoria, Integer idSubcategoria, Integer idColores, Integer idTamanos, Integer idFormatos,
//            Integer idCondicion) {
//        return this.publicacionDao.listarPorFiltrosPublicacion(terminoBusqueda, esVenta, idCategoria, idSubcategoria, idColores,
//                idTamanos, idFormatos, idCondicion); //necesita implementación
//    }

    public ArrayList<PublicacionDto> listarPorDueno(Integer personaId) {
        return this.publicacionDao.listarPorDueno(personaId); //necesita implementación
    }

    public PublicacionDto obtenerPorId(Integer id) {
        return this.publicacionDao.obtenerPorId(id);
    }
}