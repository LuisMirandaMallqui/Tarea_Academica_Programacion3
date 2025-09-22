package pe.pucp.edu.prog3.softmkp.modelComprobante;

import java.util.Date;
import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDTO;

public class ComprobanteDTO {
    
    private Integer idComprobante;
    private Double monto;
    private String transaccion;
    private Date fechaEmision;
    private Double impuesto;
    private PersonaDTO persona;
    private FormaPagoDTO formaPago;
    private MonedaPago moneda;
    private Date fechaModificacion;
    private Integer usuarioModificacion; 
    
    // Constructor vacío (inicializando en null)
    public ComprobanteDTO() {
        this.idComprobante = null;
        this.monto = null;
        this.transaccion = null;
        this.fechaEmision = null;
        this.impuesto = null;
        this.persona = null;
        this.formaPago = null;
        this.moneda = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public ComprobanteDTO(Integer idComprobante, Double monto, String transaccion, Date fechaEmision, 
                          Double impuesto, PersonaDTO persona, FormaPagoDTO formaPago, 
                          MonedaPago moneda, Date fechaModificacion, Integer usuarioModificacion) {
        this.idComprobante = idComprobante;
        this.monto = monto;
        this.transaccion = transaccion;
        this.fechaEmision = fechaEmision;
        this.impuesto = impuesto;
        this.persona = persona;
        this.formaPago = formaPago;
        this.moneda = moneda;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public FormaPagoDTO getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoDTO formaPago) {
        this.formaPago = formaPago;
    }

    public MonedaPago getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaPago moneda) {
        this.moneda = moneda;
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
