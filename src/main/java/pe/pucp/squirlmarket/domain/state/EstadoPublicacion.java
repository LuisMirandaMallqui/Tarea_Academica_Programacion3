/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pe.pucp.squirlmarket.domain.state;

/**
 *
 * @author luque
 */
public enum EstadoPublicacion {
  BORRADOR, ACTIVA, PAUSADA, RETIRADA;

  public boolean canTransitionTo(EstadoPublicacion t){
    return switch (this) {
      case BORRADOR -> t == ACTIVA;
      case ACTIVA   -> t == PAUSADA || t == RETIRADA;
      case PAUSADA  -> t == ACTIVA  || t == RETIRADA;
      case RETIRADA -> false;
    };
  }
}

