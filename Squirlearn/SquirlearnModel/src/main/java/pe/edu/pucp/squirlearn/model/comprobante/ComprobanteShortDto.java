/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.squirlearn.model.comprobante;

/**
 *
 * @author luism
 */
public class ComprobanteShortDto {

    // De comprobantes
    private String transaccion;
    private String fechaEmision;
    private Double monto;

    // De detalles_comprobantes
    private String descripcion;
    // De item
    private Boolean esVenta;

    private public ComprobanteShortDto() {
        this.transaccion = null;
        this.fechaEmision = null;
        this.monto = null;
        this.descripcion = null;
        this.esVenta = null
    }

    public ComprobanteShortDto(
            String transaccion,
            String fechaEmision,
            Double monto,
            String descripcion,
            Boolean esVenta) {
        this.transaccion = transaccion;
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.descripcion = descripcion;
        this.esVenta = esVenta;
    }

    /**
     * @return the transaccion
     */
    public String getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * @return the fechaEmision
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
