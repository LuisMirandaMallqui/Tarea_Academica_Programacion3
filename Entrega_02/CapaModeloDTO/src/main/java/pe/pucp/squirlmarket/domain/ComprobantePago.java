/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import pe.pucp.squirlmarket.domain.state.EstadoPago;
/**
 *
 * @author luque
 */
public class ComprobantePago {
  private Long comprobantePagoId;
  private Long personaCodigo;
  private Long metodoPagoId;
  private EstadoPago estado = EstadoPago.PENDIENTE;
  private LocalDateTime fechaPago;
  private BigDecimal montoPago;
  private String numeroTransaccion;
  private String descripcion;

  // Getters / setters
  public Long getComprobantePagoId() { return comprobantePagoId; }
  public void setComprobantePagoId(Long comprobantePagoId) { this.comprobantePagoId = comprobantePagoId; }
  public Long getPersonaCodigo() { return personaCodigo; }
  public void setPersonaCodigo(Long personaCodigo) { this.personaCodigo = personaCodigo; }
  public Long getMetodoPagoId() { return metodoPagoId; }
  public void setMetodoPagoId(Long metodoPagoId) { this.metodoPagoId = metodoPagoId; }
  public EstadoPago getEstado() { return estado; }
  public LocalDateTime getFechaPago() { return fechaPago; }
  public BigDecimal getMontoPago() { return montoPago; }
  public void setMontoPago(BigDecimal montoPago) { this.montoPago = montoPago; }
  public String getNumeroTransaccion() { return numeroTransaccion; }
  public void setNumeroTransaccion(String numeroTransaccion) { this.numeroTransaccion = numeroTransaccion; }
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  // Cambios de estado
  public void confirmar()  { this.estado = EstadoPago.CONFIRMADO; this.fechaPago = LocalDateTime.now(); }
  public void fallar()     { this.estado = EstadoPago.FALLIDO; }
  public void reembolsar() { this.estado = EstadoPago.REEMBOLSADO; }
}
