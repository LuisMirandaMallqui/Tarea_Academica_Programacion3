package pe.edu.pucp.squirlearn.model.publicacion;

import java.sql.Date;

public class EstadoPublicacionDto {
    
    private Integer estadoPublicacionId;
    private String nombre;
    
    // Constructor vacío (inicializa en null)
    public EstadoPublicacionDto() {
        this.estadoPublicacionId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public EstadoPublicacionDto(Integer estadoPublicacionId, String nombre) {
        this.estadoPublicacionId = estadoPublicacionId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getEstadoPublicacionId() {
        return estadoPublicacionId;
    }

    public void setEstadoPublicacionId(Integer idEstadoPublicacion) {
        this.estadoPublicacionId = idEstadoPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
