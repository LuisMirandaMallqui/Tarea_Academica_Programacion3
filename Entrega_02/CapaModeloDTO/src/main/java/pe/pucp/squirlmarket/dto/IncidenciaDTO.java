/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.dto;

/**
 *
 * @author luque
 */
public class IncidenciaDTO {
  public Long id;
  public Long reportadoPorId;
  public Long atendidoPorId; // puede ser null
  public Long operacionId;   // puede ser null
  public Long publicacionId; // puede ser null
  public String descripcion;
  public String severidad;
  public String estado;      // ABIERTA / EN_PROCESO / RESUELTA / CERRADA
  public String updatedAt;   // ISO-8601 (String para la vista)
}
