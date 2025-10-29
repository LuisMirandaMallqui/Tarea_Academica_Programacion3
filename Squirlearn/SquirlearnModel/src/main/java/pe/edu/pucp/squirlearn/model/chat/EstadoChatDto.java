package pe.edu.pucp.squirlearn.model.chat;

import java.sql.Date;

public class EstadoChatDto {
    
    private Integer estadoChatId;
    private String nombre;
    
    // Constructor vacío
    public EstadoChatDto() {
        this.estadoChatId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public EstadoChatDto(Integer estadoChatId, String nombre) {
        this.estadoChatId = estadoChatId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getEstadoChatId() {
        return estadoChatId;
    }

    public void setEstadoChatId(Integer estadoChatId) {
        this.estadoChatId = estadoChatId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
