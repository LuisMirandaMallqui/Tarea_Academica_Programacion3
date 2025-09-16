/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pe.pucp.squirlmarket.domain.state;

/**
 *
 * @author luque
 */
public enum EstadoIncidencia {
  ABIERTA, EN_PROCESO, RESUELTA, CERRADA;

  public boolean canTransitionTo(EstadoIncidencia t){
    return switch (this) {
      case ABIERTA -> t == EN_PROCESO || t == CERRADA; // se puede cerrar si es improcedente
      case EN_PROCESO -> t == RESUELTA || t == CERRADA;
      case RESUELTA -> t == CERRADA;                   // cierre administrativo
      case CERRADA -> false;
    };
  }
}
