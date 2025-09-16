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
public class PublicacionCreateDTO {
  public Long materialId;
  public Long personaCodigo;
  public String modalidad; // "VENTA" | "ALQUILER"
  public BigDecimal precio;
}
