/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.dto;

import java.math.BigDecimal;
/**
 *
 * @author luque
 */
public class PublicacionListDTO {
  public Long id;
  public String tituloMaterial;  // vendrá de Material (para listar)
  public String tipoMaterial;    // catálogo (para filtros)
  public String estado;          // ACTIVA/PAUSADA/RETIRADA/...
  public String modalidad;       // VENTA/ALQUILER
  public BigDecimal precio;
  public String autorNombre;     // para la lista
}
