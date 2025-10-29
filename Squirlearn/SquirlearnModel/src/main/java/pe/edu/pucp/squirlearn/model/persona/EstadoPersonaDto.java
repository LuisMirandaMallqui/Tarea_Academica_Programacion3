package pe.edu.pucp.squirlearn.model.persona;

import java.sql.Date;

public class EstadoPersonaDto {
    
    private Integer estadoPersonaId;
    private String nombre;
    
    // Constructor vacío (inicializa en null)
    public EstadoPersonaDto() {
        this.estadoPersonaId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public EstadoPersonaDto(Integer estadoPersonaId, String nombre) {
        this.estadoPersonaId = estadoPersonaId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getEstadoPersonaId() {
        return estadoPersonaId;
    }

    public void setEstadoPersonaId(Integer idEstadoPersona) {
        this.estadoPersonaId = idEstadoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
