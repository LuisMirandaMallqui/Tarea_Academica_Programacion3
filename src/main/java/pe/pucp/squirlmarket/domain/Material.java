/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.domain;

import java.math.BigDecimal;
/**
 *
 * @author luque
 */
public class Material {
  private Long materialId;          // MATERIAL_ID
  private Long tipoMaterialId;      // TIPO_MATERIAL_ID (FK)
  private Long estadoMaterialId;    // ESTADO_MATERIAL_ID (FK)
  private Long categoriaTamanioId;  // CATEGORIA_TAMANIO_ID (nullable)
  private Long colorId;             // COLOR_iCOLOR_ID (nullable)

  private String nombre;            // VARCHAR(100)
  private String descripcion;       // VARCHAR(255)
  private String imagenUrl;         // VARCHAR(45) nullable
  private String dimensiones;       // VARCHAR(45) nullable
  private BigDecimal peso;          // DECIMAL(10,2) nullable

  // Getters / setters
  public Long getMaterialId() { return materialId; }
  public void setMaterialId(Long materialId) { this.materialId = materialId; }

  public Long getTipoMaterialId() { return tipoMaterialId; }
  public void setTipoMaterialId(Long tipoMaterialId) { this.tipoMaterialId = tipoMaterialId; }

  public Long getEstadoMaterialId() { return estadoMaterialId; }
  public void setEstadoMaterialId(Long estadoMaterialId) { this.estadoMaterialId = estadoMaterialId; }

  public Long getCategoriaTamanioId() { return categoriaTamanioId; }
  public void setCategoriaTamanioId(Long categoriaTamanioId) { this.categoriaTamanioId = categoriaTamanioId; }

  public Long getColorId() { return colorId; }
  public void setColorId(Long colorId) { this.colorId = colorId; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  public String getImagenUrl() { return imagenUrl; }
  public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

  public String getDimensiones() { return dimensiones; }
  public void setDimensiones(String dimensiones) { this.dimensiones = dimensiones; }

  public BigDecimal getPeso() { return peso; }
  public void setPeso(BigDecimal peso) { this.peso = peso; }

  @Override
  public String toString() {
    return "Material{id=%d, nombre='%s', tipoId=%d, estadoId=%d}"
      .formatted(materialId, nombre, tipoMaterialId, estadoMaterialId);
  }
}
