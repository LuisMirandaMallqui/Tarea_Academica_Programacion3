package pe.edu.pucp.squirlearn.model.item;

import java.sql.Date;

public class TamanoDto {
    
    private Integer tamanoId;
    private String nombre;
    
    // Constructor vacío (todo en null)
    public TamanoDto() {
        this.tamanoId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public TamanoDto(Integer tamanoId, String nombre) {
        this.tamanoId = tamanoId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getTamanoId() {
        return tamanoId;
    }

    public void setTamanoId(Integer idTamano) {
        this.tamanoId = idTamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
