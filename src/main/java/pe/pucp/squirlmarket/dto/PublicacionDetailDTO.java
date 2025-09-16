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
public class PublicacionDetailDTO {
  public Long id;
  public String tituloMaterial;
  public String tipoMaterial;
  public String descripcionMaterial; // texto más largo para la ficha
  public String modalidad;           // VENTA / ALQUILER
  public String estado;              // ACTIVA / PAUSADA / RETIRADA ...
  public BigDecimal precio;
  public String autorNombre;
  public Integer valoracion;         // 0..5
  public String fechaPublicacion;    // ISO-8601 como String
}
