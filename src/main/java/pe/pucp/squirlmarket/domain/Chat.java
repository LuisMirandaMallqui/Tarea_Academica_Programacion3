/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.time.LocalDateTime;
import pe.pucp.squirlmarket.domain.state.EstadoChat;

/**
 *
 * @author luque
 */
public class Chat {
  private Long chatId;
  private Long publicacionId;
  private EstadoChat estado = EstadoChat.ABIERTO;
  private LocalDateTime fechaCreacion = LocalDateTime.now();

  // Getters / setters
  public Long getChatId() { return chatId; }
  public void setChatId(Long chatId) { this.chatId = chatId; }
  public Long getPublicacionId() { return publicacionId; }
  public void setPublicacionId(Long publicacionId) { this.publicacionId = publicacionId; }
  public EstadoChat getEstado() { return estado; }
  public LocalDateTime getFechaCreacion() { return fechaCreacion; }

  // Cambios de estado
  public void cerrar()  { this.estado = EstadoChat.CERRADO; }
  public void reabrir() { this.estado = EstadoChat.ABIERTO; }
}
