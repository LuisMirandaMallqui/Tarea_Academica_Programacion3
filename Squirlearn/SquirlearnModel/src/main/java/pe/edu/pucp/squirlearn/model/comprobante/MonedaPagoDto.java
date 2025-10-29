package pe.edu.pucp.squirlearn.model.comprobante;

import java.sql.Date;

public class MonedaPagoDto {
    
    private Integer monedaId;
    private String nombre;
    
    // Constructor vacío
    public MonedaPagoDto() {
        this.monedaId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public MonedaPagoDto(Integer monedaId, String nombre) {
        this.monedaId = monedaId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(Integer monedaId) {
        this.monedaId = monedaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
