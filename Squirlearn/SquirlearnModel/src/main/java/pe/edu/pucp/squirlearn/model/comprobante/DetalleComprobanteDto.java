package pe.edu.pucp.squirlearn.model.comprobante;

import java.sql.Date;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class DetalleComprobanteDto {
    
    private Integer detalleComId;
    private String descripcion;
    private Double precio;
    private ItemDto item;
    private AlquilerDto alquiler;
    private ComprobanteDto comprobante;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío
    public DetalleComprobanteDto() {
        this.detalleComId = null;
        this.descripcion = null;
        this.precio = null;
        this.item = null;
        this.alquiler = null;
        this.comprobante = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public DetalleComprobanteDto(Integer detalleComId, String descripcion, Double precio,
                                 ItemDto item, AlquilerDto alquiler, ComprobanteDto comprobante,
                                 Date fechaModificacion, Integer usuarioModificacion) {
        this.detalleComId = detalleComId;
        this.descripcion = descripcion;
        this.precio = precio;
        this.item = item;
        this.alquiler = alquiler;
        this.comprobante = comprobante;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getDetalleComId() {
        return detalleComId;
    }

    public void setDetalleComId(Integer detalleComId) {
        this.detalleComId = detalleComId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public AlquilerDto getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(AlquilerDto alquiler) {
        this.alquiler = alquiler;
    }

    public ComprobanteDto getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
