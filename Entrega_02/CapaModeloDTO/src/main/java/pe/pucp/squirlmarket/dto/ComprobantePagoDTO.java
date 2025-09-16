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
public class ComprobantePagoDTO {
  public Long id;
  public Long personaCodigo;
  public Long metodoPagoId;
  public String estado;       // PENDIENTE / CONFIRMADO / FALLIDO / REEMBOLSADO
  public String fechaPago;    // ISO-8601 como String para la vista
  public BigDecimal montoPago;
  public String numeroTransaccion;
  public String descripcion;
}
