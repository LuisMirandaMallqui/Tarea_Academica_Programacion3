package pe.edu.pucp.squirlearn.model.item;

import java.sql.Date;

public class EstadoItemDto {
    
    private Integer estadoItemId;
    private String nombre;
    
    // Constructor vacío
    public EstadoItemDto() {
        this.estadoItemId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public EstadoItemDto(Integer estadoItemId, String nombre) {
        this.estadoItemId = estadoItemId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getEstadoItemId() {
        return estadoItemId;
    }

    public void setEstadoItemId(Integer estadoItemId) {
        this.estadoItemId = estadoItemId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
