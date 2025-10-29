package pe.edu.pucp.squirlearn.model.item;

public class CondicionDto {
    
    private Integer condicionId;
    private String nombre;
    
    // Constructor vacío
    public CondicionDto() {
        this.condicionId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public CondicionDto(Integer condicionId, String nombre) {
        this.condicionId = condicionId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getCondicionId() {
        return condicionId;
    }

    public void setCondicionId(Integer condicionId) {
        this.condicionId = condicionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
