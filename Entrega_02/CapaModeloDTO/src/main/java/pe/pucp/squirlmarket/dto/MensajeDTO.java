/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.dto;

/**
 *
 * @author luque
 */
public class MensajeDTO {
  public Long id;
  public Long chatId;
  public String contenido;
  public String estado;     // ENVIADO / ENTREGADO / LEIDO
  public String enviadoEn;  // ISO-8601 (String para simplificar la vista)
}