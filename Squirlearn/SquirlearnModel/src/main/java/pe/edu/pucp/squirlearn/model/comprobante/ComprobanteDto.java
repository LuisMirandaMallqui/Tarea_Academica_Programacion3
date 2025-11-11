package pe.edu.pucp.squirlearn.model.comprobante;

import java.sql.Date;
import java.util.List;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class ComprobanteDto {
    
    private Integer comprobanteId;
    private PersonaDto persona;
    private FormaPagoDto formaPago;
    private MonedaPagoDto moneda;
    private Double monto;
    private String transaccion;
    private Date fechaEmision;
    private Double impuesto;
    private String usuarioCreacion;
    private List<DetalleComprobanteDto> detallesComprobante;
    
    // Constructor vacío
    public ComprobanteDto() {
        this.comprobanteId = null;
        this.monto = null;
        this.transaccion = null;
        this.fechaEmision = null;
        this.impuesto = null;
        this.persona = null;
        this.formaPago = null;
        this.moneda = null;
        this.usuarioCreacion = null;
        this.detallesComprobante = null;
    }

    // Constructor con parámetros
    public ComprobanteDto(Integer comprobanteId, Double monto, String transaccion, Date fechaEmision,
                          Double impuesto, PersonaDto persona, FormaPagoDto formaPago, 
                          MonedaPagoDto moneda,String usuarioCreacion,
                          List<DetalleComprobanteDto> detallesComprobante) {
        this.comprobanteId = comprobanteId;
        this.monto = monto;
        this.transaccion = transaccion;
        this.fechaEmision = fechaEmision;
        this.impuesto = impuesto;
        this.persona = persona;
        this.formaPago = formaPago;
        this.moneda = moneda;
        this.usuarioCreacion = usuarioCreacion;
        this.detallesComprobante = detallesComprobante;
    }

    // Getters y Setters
    public Integer getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(Integer comprobanteId) {
        this.comprobanteId = comprobanteId;
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

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public FormaPagoDto getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoDto formaPago) {
        this.formaPago = formaPago;
    }

    public MonedaPagoDto getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaPagoDto moneda) {
        this.moneda = moneda;
    }

    public String getusuarioCreacion() {
        return usuarioCreacion;
    }

    public void setusuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    
    public List<DetalleComprobanteDto> getDetallesComprobante() {
        return detallesComprobante;
    }

    public void setDetallesComprobante(List<DetalleComprobanteDto> detallesComprobante) {
        this.detallesComprobante = detallesComprobante;
    }
}
