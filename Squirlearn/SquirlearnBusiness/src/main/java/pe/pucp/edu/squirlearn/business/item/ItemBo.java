package pe.pucp.edu.squirlearn.business.item;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private EstadoItemBo estadoItemBo;
    private CategoriaBo categoriaBo;
    private ColorBo colorBo;
    private CondicionBo condicionBo;
    private FormatoBo formatoBo;
    private SubcategoriaBo subcategoriaBo;
    private TamanoBo tamanoBo;
    
     private static final String ARCHIVO_CONFIGURACION = "cloud.properties";
    
            
    public ItemBo(){
        this.itemDao = new ItemDaoImpl();
        this.estadoItemBo = new EstadoItemBo();
        this.categoriaBo = new CategoriaBo();
        this.colorBo  = new ColorBo();
        this.condicionBo = new CondicionBo();
        this.formatoBo = new FormatoBo();
        this.subcategoriaBo = new SubcategoriaBo();
        this.tamanoBo = new TamanoBo();
    }
    
    public Integer insertar(Double precio, String nombre,String descripcion ,Boolean esVenta ,
            Integer colorId, Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId,String usuarioCreacion,byte[] imagen){
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
        estado.setEstadoItemId(this.estadoItemBo.obtenerId(("Disponible").toUpperCase()));
        
        String imagenURL = insertarImagenEnRepositorio(imagen);
        
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
        itemdto.setImagenURL(imagenURL);
        return this.itemDao.insertar(itemdto);
    }
    
    public String insertarImagenEnRepositorio(byte[] imagen){
        String urlImagen = null;
        Properties properties = new Properties();
        String nmArchivoConf = "/" + ARCHIVO_CONFIGURACION;
        try {
            properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
        } catch (IOException ex) {
            Logger.getLogger(ItemBo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (imagen != null && imagen.length > 0) {
            try {
                Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", properties.getProperty("cloud_name"),
                    "api_key", properties.getProperty("api_key"),
                    "api_secret", properties.getProperty("api_secret")));
                Map uploadResult = cloudinary.uploader().upload(imagen, ObjectUtils.emptyMap());

                // 4. Obtener la URL segura (HTTPS)
                urlImagen = (String) uploadResult.get("secure_url");
                
            } catch (Exception e) {
                System.out.println("Error subiendo a Cloudinary: " + e.getMessage());
            }
        }
        return urlImagen;
    }
    
    public Integer modificar(Integer id,Double precio,String nombre, String descripcion, Boolean esVenta ,
            Integer colorId ,Integer condicionId, Integer tamanoId, Integer formatoId,
            Integer categoriaId, Integer subcategoriaId,String usuario){
        ItemDto itemdto = this.obtenerPorId(id);
        
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
        itemdto.setusuarioModificacion(usuario);
        return this.itemDao.modificar(itemdto);
    }
    
    
    public ItemDto obtenerPorId(Integer id){
        return this.itemDao.obtenerPorId(id);
    }
    
    public ItemDto obtenerPorIdCompleto(Integer id){
        
        ItemDto itemDto = this.itemDao.obtenerPorId(id);
        itemDto.setCategoria(categoriaBo.obtenerPorId(itemDto.getCategoria().getCategoriaId()));
        itemDto.setColor(colorBo.obtenerPorId(itemDto.getColor().getColorId()));
        itemDto.setCondicion(condicionBo.obtenerPorId(itemDto.getCondicion().getCondicionId()));
        itemDto.setEstadoItem(estadoItemBo.obtenerPorId(itemDto.getEstadoItem().getEstadoItemId()));
        itemDto.setFormato(formatoBo.obtenerPorId(itemDto.getFormato().getFormatoId()));
        itemDto.setSubcategoria(subcategoriaBo.obtenerPorId(itemDto.getSubcategoria().getSubcategoriaId()));
        itemDto.setTamano(tamanoBo.obtenerPorId(itemDto.getTamano().getTamanoId()));
        return itemDto;
    }
    
    public Integer cambiarEstadoItem(Integer itemId, String usuario, String estado){
        ItemDto itemDto = this.obtenerPorId(itemId);
        itemDto.setusuarioModificacion(usuario);
        EstadoItemDto estadoItem = new EstadoItemDto();   
        estadoItem.setEstadoItemId(this.estadoItemBo.obtenerId((estado).toUpperCase()));
        itemDto.setEstadoItem(estadoItem);
        return this.itemDao.modificar(itemDto);
    }
}
