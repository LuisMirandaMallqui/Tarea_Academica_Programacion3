package pe.edu.pucp.squirlearn.model.item;


public class FormatoDto {
    
    private Integer formatoId;
    private String nombre;
    
    // Constructor vacío
    public FormatoDto() {
        this.formatoId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public FormatoDto(Integer formatoId, String nombre) {
        this.formatoId = formatoId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getFormatoId() {
        return formatoId;
    }

    public void setFormatoId(Integer formatoId) {
        this.formatoId = formatoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
