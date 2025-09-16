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
public class NotificacionDestinatario {
  private Long notificacionId; // FK
  private Long personaCodigo;  // FK
  private boolean leido = false;
  private LocalDateTime leidoEn;

  // Getters / setters
  public Long getNotificacionId() { return notificacionId; }
  public void setNotificacionId(Long notificacionId) { this.notificacionId = notificacionId; }
  public Long getPersonaCodigo() { return personaCodigo; }
  public void setPersonaCodigo(Long personaCodigo) { this.personaCodigo = personaCodigo; }
  public boolean isLeido() { return leido; }
  public LocalDateTime getLeidoEn() { return leidoEn; }

  // Acción
  public void marcarLeido() {
    if (!this.leido) {
      this.leido = true;
      this.leidoEn = LocalDateTime.now();
    }
  }
}
