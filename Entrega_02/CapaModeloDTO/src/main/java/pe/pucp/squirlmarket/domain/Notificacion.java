/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.time.LocalDateTime;
/**
 *
 * @author luque
 */
public class Notificacion {
  private Long notificacionId;
  private String tipo;       // p. ej., "RESERVA", "ENTREGA", "DEVOLUCION"
  private String titulo;
  private String contenido;
  private LocalDateTime creadoEn = LocalDateTime.now();

  // Getters / setters
  public Long getNotificacionId() { return notificacionId; }
  public void setNotificacionId(Long notificacionId) { this.notificacionId = notificacionId; }
  public String getTipo() { return tipo; }
  public void setTipo(String tipo) { this.tipo = tipo; }
  public String getTitulo() { return titulo; }
  public void setTitulo(String titulo) { this.titulo = titulo; }
  public String getContenido() { return contenido; }
  public void setContenido(String contenido) { this.contenido = contenido; }
  public LocalDateTime getCreadoEn() { return creadoEn; }
}
