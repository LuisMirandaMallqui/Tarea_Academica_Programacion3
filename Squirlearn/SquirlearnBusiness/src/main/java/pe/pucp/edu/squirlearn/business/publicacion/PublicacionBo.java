package pe.pucp.edu.squirlearn.business.publicacion;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionDao;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionShortDao;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.PublicacionDaoImpl;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.PublicacionShortDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.ListadoPublicacionGestionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;
import pe.pucp.edu.squirlearn.business.item.ItemBo;


public class PublicacionBo {
    
    private PublicacionDao publicacionDao;
    private ItemBo itemBo;
    private EstadoPublicacionBo estadoPublicacionBo;
    private PublicacionShortDao publicacionShortDao;
    
    private static final String ARCHIVO_CONFIGURACION = "cloud.properties";
    
    public PublicacionBo (){
        this.publicacionDao = new PublicacionDaoImpl();
        this.itemBo = new ItemBo();
        this.estadoPublicacionBo = new EstadoPublicacionBo();
        this.publicacionShortDao = new PublicacionShortDaoImpl();
    }
    
    public Integer insertar(Integer personaId, String usuarioCreacion, String estado,
            Double precio, String nombre,String descripcion ,Boolean esVenta ,
            Integer colorId, Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId, byte[] imagen) {
        
        Integer itemId = this.itemBo.insertar(precio, nombre, descripcion, esVenta, colorId,
                condicionId, tamanoId, formatoId, categoriaId, subcategoriaId,usuarioCreacion);
        PublicacionDto publicacionDto = new PublicacionDto();
        //Instanciar un item
        ItemDto itemdto = new ItemDto();
        itemdto.setItemId(itemId);
        
        //Asignar atributos publicacion
        PersonaDto personaDto = new PersonaDto();
        personaDto.setPersonaId(personaId);
        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();   
        estadoPublicacion.setEstadoPublicacionId(this.estadoPublicacionBo.obtenerId((estado).toUpperCase()));

        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        publicacionDto.setItem(itemdto);
        publicacionDto.setPersona(personaDto);
        publicacionDto.setusuarioCreacion(usuarioCreacion);
        
        String imagenURL = insertarImagenEnNube(imagen);
        publicacionDto.setImagenURL(imagenURL);
        
        return this.publicacionDao.insertar(publicacionDto);
    }
    
    public Integer modificar(Integer publicacionId, String usuario, String estado,
            Double precio, String nombre,String descripcion ,Boolean esVenta ,
            Integer colorId, Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId, byte[] imagen) {
        
        PublicacionDto publicacionDto = this.obtenerPorId(publicacionId);
        Integer itemId = publicacionDto.getItem().getItemId();
        this.itemBo.modificar(itemId, precio, nombre, descripcion, esVenta, colorId,
                condicionId, tamanoId, formatoId, categoriaId, subcategoriaId, usuario);

        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();
        estadoPublicacion.setEstadoPublicacionId(this.estadoPublicacionBo.obtenerId(estado.toUpperCase()));
        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        
        eliminarImagenEnNube(publicacionDto.getImagenURL());
        String imagenURL = insertarImagenEnNube(imagen);
        publicacionDto.setImagenURL(imagenURL);
         
        int numero = this.publicacionDao.modificar(publicacionDto);
         
        EstadoPublicacionDto nn=publicacionDto.getEstadoPublicacion() ;
        return nn.getEstadoPublicacionId();
    }
    
    public Cloudinary instanciarCloudinary(){
        Properties properties = new Properties();
        String nmArchivoConf = "/" + ARCHIVO_CONFIGURACION;
        try {
            properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
        } catch (IOException ex) {
            Logger.getLogger(PublicacionBo.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", properties.getProperty("cloud_name"),
                    "api_key", properties.getProperty("api_key"),
                    "api_secret", properties.getProperty("api_secret")));
        
        return cloudinary;
    }
    
    public String insertarImagenEnNube(byte[] imagen){
        String imagenURL = null;
        if (imagen != null && imagen.length > 0) {
            try {
                Cloudinary cloudinary = instanciarCloudinary();
                Map uploadResult = cloudinary.uploader().upload(imagen, ObjectUtils.emptyMap());
                imagenURL = (String) uploadResult.get("secure_url");
                
            } catch (Exception e) {
                System.out.println("Error subiendo a Cloudinary: " + e.getMessage());
            }
        }
        return imagenURL;
    }
   
    public void eliminarImagenEnNube(String imagenURL){
    
        if (imagenURL == null || imagenURL.isEmpty()) {
            return;
        }

        try {
            // 3. Conectar a Cloudinary
            Cloudinary cloudinary = instanciarCloudinary();
            String nombreConExtension = imagenURL.substring(imagenURL.lastIndexOf("/") + 1); 
            String publicId = nombreConExtension.substring(0, nombreConExtension.lastIndexOf("."));
            Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            System.out.println("Resultado eliminación: " + result.toString());
        } catch (Exception e) {
            System.out.println("Error eliminando de Cloudinary: " + e.getMessage());
        }
    }
    
    
    
     public ArrayList<PublicacionDto> listarPorEstado(Integer estadoId) {
        return this.publicacionDao.listarPorEstado(estadoId); //necesita implementación
    }

    public ListadoPublicacionGestionDto listarPorFiltrosPublicacion(String terminoBusqueda, Integer tipoTransaccion,
            Integer idCategoria, Integer idSubcategoria, Integer idColores, Integer idTamanos, Integer idFormatos,
            Integer idCondicion, Integer paginaActual, Integer publicacionesPorPagina) {
        Boolean esVenta = null;
        switch(tipoTransaccion){
            case 0:
                esVenta = false;
                break;
            case 1:
                esVenta = true;
                break;
            case 2:
                esVenta = null;
                break;
        }
        ListadoPublicacionGestionDto listado = new ListadoPublicacionGestionDto();
        listado.setLista(this.publicacionShortDao.listarPorFiltrosPublicacion(terminoBusqueda, esVenta, idCategoria, idSubcategoria, idColores,
                idTamanos, idFormatos, idCondicion,paginaActual,publicacionesPorPagina));
        
        listado.setTotalPaginas(this.publicacionShortDao.cantidadListarPorFiltrosPublicacion(terminoBusqueda, esVenta, idCategoria, idSubcategoria, idColores,
                idTamanos, idFormatos, idCondicion));
        return listado;
    }
    
    public ListadoPublicacionGestionDto listarPorFiltrosPublicacion(Integer usuarioId, Integer cantidadPorPagina, Integer pagina,Integer estado){
        ListadoPublicacionGestionDto listado = new ListadoPublicacionGestionDto();
        listado.setLista(this.publicacionShortDao.listarPorFiltrosPublicacion( usuarioId,  cantidadPorPagina,  pagina, estado));
        
        listado.setTotalPaginas(this.publicacionShortDao.cantidadListarPorFiltrosPublicacion(usuarioId, estado));
        return listado;
    }

    public ArrayList<PublicacionDto> listarPorDueno(Integer personaId) {
        return this.publicacionDao.listarPorDueno(personaId); 
    }

    public PublicacionDto obtenerPorId(Integer id) {
        return this.publicacionDao.obtenerPorId(id);
    }
    
    public Integer cambiarEstadoPublicacion(Integer publicacionId, String usuario, String estado){
        PublicacionDto publicacionDto = this.obtenerPorId(publicacionId);
        publicacionDto.setusuarioModificacion(usuario);
        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();   
        estadoPublicacion.setEstadoPublicacionId(this.estadoPublicacionBo.obtenerId((estado).toUpperCase()));
        publicacionDto.setEstadoPublicacion(estadoPublicacion);
        return this.publicacionDao.modificar(publicacionDto);
    }
    
    public PublicacionDto obtenerPorIdCompleto(Integer id){
        PublicacionDto publicacionDto =  this.publicacionDao.obtenerPorId(id);
        publicacionDto.setItem(this.itemBo.obtenerPorIdCompleto(publicacionDto.getItem().getItemId()));
        return publicacionDto;
    }
}