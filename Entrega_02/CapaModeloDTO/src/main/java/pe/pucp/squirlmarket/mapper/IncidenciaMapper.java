/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.mapper;

import pe.pucp.squirlmarket.domain.Incidencia;
import pe.pucp.squirlmarket.dto.IncidenciaCreateDTO;
import pe.pucp.squirlmarket.dto.IncidenciaDTO;
/**
 *
 * @author luque
 */
public final class IncidenciaMapper {
  private IncidenciaMapper(){}

  public static Incidencia fromCreate(IncidenciaCreateDTO dto){
    Incidencia i = new Incidencia();
    i.setReportadoPorId(dto.reportadoPorId);
    i.setOperacionId(dto.operacionId);
    i.setPublicacionId(dto.publicacionId);
    i.setDescripcion(dto.descripcion);
    i.setSeveridad(dto.severidad);
    return i; // queda en ABIERTA
  }

  public static IncidenciaDTO toDTO(Incidencia i){
    IncidenciaDTO dto = new IncidenciaDTO();
    dto.id = i.getIncidenciaId();
    dto.reportadoPorId = i.getReportadoPorId();
    dto.atendidoPorId = i.getAtendidoPorId();
    dto.operacionId = i.getOperacionId();
    dto.publicacionId = i.getPublicacionId();
    dto.descripcion = i.getDescripcion();
    dto.severidad = i.getSeveridad();
    dto.estado = i.getEstado().name();
    dto.updatedAt = i.getUpdatedAt().toString();
    return dto;
  }
}
