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
public class ComprobantePagoCreateDTO {
  public Long personaCodigo;
  public Long metodoPagoId;
  public BigDecimal montoPago;
  public String numeroTransaccion; // opcional
  public String descripcion;       // opcional
}
