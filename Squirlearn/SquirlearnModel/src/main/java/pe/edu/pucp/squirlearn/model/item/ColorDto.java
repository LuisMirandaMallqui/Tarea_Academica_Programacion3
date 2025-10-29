package pe.edu.pucp.squirlearn.model.item;

public class ColorDto {
    
    private Integer colorId;
    private String nombre;
    
    // Constructor vacío
    public ColorDto() {
        this.colorId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public ColorDto(Integer colorId, String nombre) {
        this.colorId = colorId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
