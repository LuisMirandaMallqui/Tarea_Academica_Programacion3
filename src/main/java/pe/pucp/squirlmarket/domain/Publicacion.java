/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import pe.pucp.squirlmarket.domain.state.EstadoPublicacion;
import pe.pucp.squirlmarket.domain.state.Modalidad;

/**
 *
 * @author luque
 */
public class Publicacion {
  private Long publicacionId;
  private Long materialId;
  private Long personaCodigo;
  private Integer valoracion; // opcional 0..5
  private LocalDateTime fechaPublicacion = LocalDateTime.now();
  private BigDecimal precio;

  private EstadoPublicacion estado = EstadoPublicacion.BORRADOR;
  private Modalidad modalidad; // VENTA / ALQUILER

  // Getters / setters
  public Long getPublicacionId() { return publicacionId; }
  public void setPublicacionId(Long id) { this.publicacionId = id; }
  public Long getMaterialId() { return materialId; }
  public void setMaterialId(Long materialId) { this.materialId = materialId; }
  public Long getPersonaCodigo() { return personaCodigo; }
  public void setPersonaCodigo(Long personaCodigo) { this.personaCodigo = personaCodigo; }
  public Integer getValoracion() { return valoracion; }
  public void setValoracion(Integer v) { this.valoracion = v; }
  public LocalDateTime getFechaPublicacion() { return fechaPublicacion; }
  public BigDecimal getPrecio() { return precio; }
  public void setPrecio(BigDecimal precio) {
    if (precio != null && precio.signum() < 0) throw new IllegalArgumentException("Precio inválido");
    this.precio = precio;
  }
  public EstadoPublicacion getEstado() { return estado; }
  public Modalidad getModalidad() { return modalidad; }
  public void setModalidad(Modalidad modalidad) { this.modalidad = modalidad; }

  // Reglas de estado
  public void activar(){ transitionTo(EstadoPublicacion.ACTIVA); }
  public void pausar(){ transitionTo(EstadoPublicacion.PAUSADA); }
  public void retirar(){ transitionTo(EstadoPublicacion.RETIRADA); }

  private void transitionTo(EstadoPublicacion target){
    if (!estado.canTransitionTo(target))
      throw new IllegalStateException("Transición no permitida: " + estado + " -> " + target);
    this.estado = target;
  }
}
