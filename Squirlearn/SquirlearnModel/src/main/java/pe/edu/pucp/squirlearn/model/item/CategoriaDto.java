package pe.edu.pucp.squirlearn.model.item;

public class CategoriaDto {
    
    private Integer categoriaId;
    private String nombre;
    
    // Constructor vacío
    public CategoriaDto() {
        this.categoriaId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public CategoriaDto(Integer categoriaId, String nombre) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
