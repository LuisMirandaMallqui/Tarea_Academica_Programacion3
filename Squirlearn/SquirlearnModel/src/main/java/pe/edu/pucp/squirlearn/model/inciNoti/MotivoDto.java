package pe.edu.pucp.squirlearn.model.inciNoti;


public class MotivoDto {
    
    private Integer motivoId;
    private String nombre;
    
    // Constructor vacío
    public MotivoDto() {
        this.motivoId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public MotivoDto(Integer motivoId, String nombre) {
        this.motivoId = motivoId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Integer motivoId) {
        this.motivoId = motivoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
