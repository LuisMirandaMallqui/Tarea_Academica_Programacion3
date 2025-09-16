/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.time.LocalDateTime;
import pe.pucp.squirlmarket.domain.state.EstadoMensaje;

/**
 *
 * @author luque
 */
public class Mensaje {
  private Long mensajeId;
  private Long chatId;
  private String contenido;
  private LocalDateTime fechaEnvio = LocalDateTime.now();
  private EstadoMensaje estado = EstadoMensaje.ENVIADO;

  // Getters / setters
  public Long getMensajeId() { return mensajeId; }
  public void setMensajeId(Long mensajeId) { this.mensajeId = mensajeId; }
  public Long getChatId() { return chatId; }
  public void setChatId(Long chatId) { this.chatId = chatId; }
  public String getContenido() { return contenido; }
  public void setContenido(String contenido) { this.contenido = contenido; }
  public LocalDateTime getFechaEnvio() { return fechaEnvio; }
  public EstadoMensaje getEstado() { return estado; }

  // Reglas de estado
  public void marcarEntregado() { this.estado = EstadoMensaje.ENTREGADO; }
  public void marcarLeido()     { this.estado = EstadoMensaje.LEIDO; }
}
