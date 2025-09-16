/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.dto;

/**
 *
 * @author luque
 */
public class IncidenciaCreateDTO {
  public Long reportadoPorId;
  public Long operacionId;   // opcional
  public Long publicacionId; // opcional
  public String descripcion;
  public String severidad;   // "BAJA" | "MEDIA" | "ALTA"
}
