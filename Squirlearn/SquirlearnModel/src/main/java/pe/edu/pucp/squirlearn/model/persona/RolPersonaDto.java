package pe.edu.pucp.squirlearn.model.persona;

import java.sql.Date;


public class RolPersonaDto {
    
    private Integer rolPersonaId;
    private String nombre;
    
    // Constructor vacío (inicializa todo en null)
    public RolPersonaDto() {
        this.rolPersonaId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public RolPersonaDto(Integer rolPersonaId, String nombre) {
        this.rolPersonaId = rolPersonaId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getRolPersonaId() {
        return rolPersonaId;
    }

    public void setRolPersonaId(Integer idRolPersona) {
        this.rolPersonaId = idRolPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
