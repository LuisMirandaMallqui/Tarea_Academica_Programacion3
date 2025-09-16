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
public class Persona {
  private Long personaCodigo;     // PK lógico
  private String nombre;
  private String apellido;
  private String emailPucp;
  private String fotoUrl;         // opcional
  private Double reputacion;      // 0..5 (promedio)
  private LocalDateTime creadoEn = LocalDateTime.now();

  // Getters / setters
  public Long getPersonaCodigo() { return personaCodigo; }
  public void setPersonaCodigo(Long personaCodigo) { this.personaCodigo = personaCodigo; }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getApellido() { return apellido; }
  public void setApellido(String apellido) { this.apellido = apellido; }
  public String getEmailPucp() { return emailPucp; }
  public void setEmailPucp(String emailPucp) { this.emailPucp = emailPucp; }
  public String getFotoUrl() { return fotoUrl; }
  public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
  public Double getReputacion() { return reputacion; }
  public void setReputacion(Double reputacion) { this.reputacion = reputacion; }
  public LocalDateTime getCreadoEn() { return creadoEn; }

  @Override
  public String toString() {
    return "Persona{codigo=%d, nombre=%s %s, email=%s, rep=%.2f}"
        .formatted(personaCodigo, nombre, apellido, emailPucp, reputacion != null ? reputacion : 0.0);
  }
}
