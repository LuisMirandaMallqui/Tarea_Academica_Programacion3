/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.mapper;

import pe.pucp.squirlmarket.domain.ComprobantePago;
import pe.pucp.squirlmarket.dto.ComprobantePagoCreateDTO;
import pe.pucp.squirlmarket.dto.ComprobantePagoDTO;
/**
 *
 * @author luque
 */
public final class ComprobantePagoMapper {
  private ComprobantePagoMapper(){}

  public static ComprobantePago fromCreate(ComprobantePagoCreateDTO dto){
    ComprobantePago c = new ComprobantePago();
    c.setPersonaCodigo(dto.personaCodigo);
    c.setMetodoPagoId(dto.metodoPagoId);
    c.setMontoPago(dto.montoPago);
    c.setNumeroTransaccion(dto.numeroTransaccion);
    c.setDescripcion(dto.descripcion);
    return c; // queda en PENDIENTE por defecto
  }

  public static ComprobantePagoDTO toDTO(ComprobantePago c){
    ComprobantePagoDTO dto = new ComprobantePagoDTO();
    dto.id = c.getComprobantePagoId();
    dto.personaCodigo = c.getPersonaCodigo();
    dto.metodoPagoId = c.getMetodoPagoId();
    dto.estado = c.getEstado().name();
    dto.fechaPago = c.getFechaPago() != null ? c.getFechaPago().toString() : null;
    dto.montoPago = c.getMontoPago();
    dto.numeroTransaccion = c.getNumeroTransaccion();
    dto.descripcion = c.getDescripcion();
    return dto;
  }
}
