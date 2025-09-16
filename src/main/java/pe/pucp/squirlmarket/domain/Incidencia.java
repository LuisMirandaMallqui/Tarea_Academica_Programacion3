/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.time.LocalDateTime;
import pe.pucp.squirlmarket.domain.state.EstadoIncidencia;
/**
 *
 * @author luque
 */
public class Incidencia {
  private Long incidenciaId;
  private Long reportadoPorId;  // persona que reporta
  private Long atendidoPorId;   // admin que la toma (opcional)
  private Long operacionId;     // opcional: incidencia ligada a una operación
  private Long publicacionId;   // opcional: o ligada a una publicación
  private String descripcion;
  private String severidad;     // "BAJA" | "MEDIA" | "ALTA"
  private String resolucion;    // texto al resolver/cerrar

  private EstadoIncidencia estado = EstadoIncidencia.ABIERTA;
  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime updatedAt = LocalDateTime.now();

  // Getters / setters
  public Long getIncidenciaId() { return incidenciaId; }
  public void setIncidenciaId(Long incidenciaId) { this.incidenciaId = incidenciaId; }
  public Long getReportadoPorId() { return reportadoPorId; }
  public void setReportadoPorId(Long reportadoPorId) { this.reportadoPorId = reportadoPorId; }
  public Long getAtendidoPorId() { return atendidoPorId; }
  public void setAtendidoPorId(Long atendidoPorId) { this.atendidoPorId = atendidoPorId; }
  public Long getOperacionId() { return operacionId; }
  public void setOperacionId(Long operacionId) { this.operacionId = operacionId; }
  public Long getPublicacionId() { return publicacionId; }
  public void setPublicacionId(Long publicacionId) { this.publicacionId = publicacionId; }
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
  public String getSeveridad() { return severidad; }
  public void setSeveridad(String severidad) { this.severidad = severidad; }
  public String getResolucion() { return resolucion; }
  public EstadoIncidencia getEstado() { return estado; }
  public LocalDateTime getCreatedAt() { return createdAt; }
  public LocalDateTime getUpdatedAt() { return updatedAt; }

  // --- Reglas de cambio de estado ---
  public void tomar(Long adminId) {
    this.atendidoPorId = adminId;
    transitionTo(EstadoIncidencia.EN_PROCESO);
  }

  public void resolver(String resolucion) {
    this.resolucion = resolucion;
    transitionTo(EstadoIncidencia.RESUELTA);
  }

  public void cerrar() {
    transitionTo(EstadoIncidencia.CERRADA);
  }

  private void transitionTo(EstadoIncidencia target) {
    if (!estado.canTransitionTo(target)) {
      throw new IllegalStateException("Transición no permitida: " + estado + " -> " + target);
    }
    this.estado = target;
    this.updatedAt = LocalDateTime.now();
  }
}
