package pe.edu.pucp.squirlearn.model.comprobante;

import java.sql.Date;

public class FormaPagoDto {
   
    private Integer formaPagoId;
    private String nombre;
    
    // Constructor vacío
    public FormaPagoDto() {
        this.formaPagoId = null;
        this.nombre = null;
    }

    // Constructor con parámetros
    public FormaPagoDto(Integer formaPagoId, String nombre) {
        this.formaPagoId = formaPagoId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getFormaPagoId() {
        return formaPagoId;
    }

    public void setFormaPagoId(Integer formaPagoId) {
        this.formaPagoId = formaPagoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
