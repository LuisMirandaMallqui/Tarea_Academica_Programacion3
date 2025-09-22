package pe.pucp.edu.prog3.softmkp.modelComprobante;

import java.util.Date;
import pe.pucp.edu.prog3.softmkp.modelAlquiler.AlquilerDTO;
import pe.pucp.edu.prog3.softmkp.modelItem.ItemDTO;

public class DetalleComprobante {
    
    private Integer idDetalleCom;
    private String descripcion;
    private Double precio;
    private ItemDTO item;
    private AlquilerDTO alquiler;
    private ComprobanteDTO comprobante;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío (inicializando con null)
    public DetalleComprobante() {
        this.idDetalleCom = null;
        this.descripcion = null;
        this.precio = null;
        this.item = null;
        this.alquiler = null;
        this.comprobante = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public DetalleComprobante(Integer idDetalleCom, String descripcion, Double precio,
                              ItemDTO item, AlquilerDTO alquiler, ComprobanteDTO comprobante,
                              Date fechaModificacion, Integer usuarioModificacion) {
        this.idDetalleCom = idDetalleCom;
        this.descripcion = descripcion;
        this.precio = precio;
        this.item = item;
        this.alquiler = alquiler;
        this.comprobante = comprobante;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getIdDetalleCom() {
        return idDetalleCom;
    }

    public void setIdDetalleCom(Integer idDetalleCom) {
        this.idDetalleCom = idDetalleCom;
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

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public AlquilerDTO getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(AlquilerDTO alquiler) {
        this.alquiler = alquiler;
    }

    public ComprobanteDTO getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteDTO comprobante) {
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
