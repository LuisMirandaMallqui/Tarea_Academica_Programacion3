package pe.edu.pucp.squirlearn.model.chat;

import java.sql.Date;

public class EstadoMensajeDto {
    
    private Integer estadoMsjId;
    private String nombre;
    
    // Constructor vacío
    public EstadoMensajeDto() {
        this.estadoMsjId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public EstadoMensajeDto(Integer estadoMsjId, String nombre) {
        this.estadoMsjId = estadoMsjId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getEstadoMsjId() {
        return estadoMsjId;
    }

    public void setEstadoMsjId(Integer estadoMsjId) {
        this.estadoMsjId = estadoMsjId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
