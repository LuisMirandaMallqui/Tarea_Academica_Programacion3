package pe.edu.pucp.squirlearn.model.item;


public class SubcategoriaDto {
    
    private Integer subcategoriaId;
    private String nombre;
    private CategoriaDto categoria;
    
    // Constructor vacío (todo en null)
    public SubcategoriaDto() {
        this.subcategoriaId = null;
        this.nombre = null;
        this.categoria = null;
    }

    // Constructor con parámetros
    public SubcategoriaDto(Integer subcategoriaId, String nombre, CategoriaDto categoria) {
        this.subcategoriaId = subcategoriaId;
        this.nombre = nombre;
        this.categoria = categoria;
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
}
