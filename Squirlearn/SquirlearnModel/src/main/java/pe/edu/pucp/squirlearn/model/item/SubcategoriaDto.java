package pe.edu.pucp.squirlearn.model.item;

import java.util.Date;

public class SubcategoriaDto {
    
    private Integer subcategoriaId;
    private String nombre;
    private CategoriaDto categoria;
    private Date fechaCreacion;
    private Integer usuarioCreacion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío (todo en null)
    public SubcategoriaDto() {
        this.subcategoriaId = null;
        this.nombre = null;
        this.categoria = null;
        this.fechaCreacion = null;
        this.usuarioCreacion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public SubcategoriaDto(Integer subcategoriaId, String nombre, CategoriaDto categoria,
                           Date fechaCreacion, Integer usuarioCreacion, 
                           Date fechaModificacion, Integer usuarioModificacion) {
        this.subcategoriaId = subcategoriaId;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getSubcategoriaId() {
        return subcategoriaId;
    }

    public void setSubcategoriaId(Integer idSubcategoria) {
        this.subcategoriaId = idSubcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
