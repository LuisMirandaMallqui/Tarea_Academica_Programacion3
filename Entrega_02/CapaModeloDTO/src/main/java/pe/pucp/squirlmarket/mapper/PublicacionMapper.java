/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.mapper;

import pe.pucp.squirlmarket.domain.Publicacion;
import pe.pucp.squirlmarket.domain.state.Modalidad;
import pe.pucp.squirlmarket.dto.PublicacionCreateDTO;
import pe.pucp.squirlmarket.dto.PublicacionListDTO;
/**
 *
 * @author luque
 */
public final class PublicacionMapper {
  private PublicacionMapper(){}

  public static Publicacion fromCreate(PublicacionCreateDTO dto){
    Publicacion p = new Publicacion();
    p.setMaterialId(dto.materialId);
    p.setPersonaCodigo(dto.personaCodigo);
    p.setModalidad(Modalidad.valueOf(dto.modalidad));
    p.setPrecio(dto.precio);
    return p; // queda en BORRADOR por defecto
  }

  // Los strings (tituloMaterial, tipoMaterial, autorNombre) vendrán de otras consultas
  public static PublicacionListDTO toListDTO(
      Publicacion p, String tituloMaterial, String tipoMaterial, String autorNombre){
    PublicacionListDTO dto = new PublicacionListDTO();
    dto.id = p.getPublicacionId();
    dto.tituloMaterial = tituloMaterial;
    dto.tipoMaterial = tipoMaterial;
    dto.estado = p.getEstado().name();
    dto.modalidad = p.getModalidad() != null ? p.getModalidad().name() : null;
    dto.precio = p.getPrecio();
    dto.autorNombre = autorNombre;
    return dto;
  }
  
  public static pe.pucp.squirlmarket.dto.PublicacionDetailDTO toDetailDTO(
    pe.pucp.squirlmarket.domain.Publicacion p,
    String tituloMaterial,
    String tipoMaterial,
    String descripcionMaterial,
    String autorNombre
    ){
      var dto = new pe.pucp.squirlmarket.dto.PublicacionDetailDTO();
      dto.id = p.getPublicacionId();
      dto.tituloMaterial = tituloMaterial;
      dto.tipoMaterial = tipoMaterial;
      dto.descripcionMaterial = descripcionMaterial;
      dto.modalidad = p.getModalidad() != null ? p.getModalidad().name() : null;
      dto.estado = p.getEstado().name();
      dto.precio = p.getPrecio();
      dto.autorNombre = autorNombre;
      dto.valoracion = p.getValoracion();
      dto.fechaPublicacion = p.getFechaPublicacion().toString();
      return dto;
    }
}


