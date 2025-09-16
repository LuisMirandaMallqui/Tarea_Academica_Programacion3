/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.mapper;

import pe.pucp.squirlmarket.domain.Chat;
import pe.pucp.squirlmarket.dto.ChatDTO;
import pe.pucp.squirlmarket.dto.ChatCreateDTO;
/**
 *
 * @author luque
 */
public final class ChatMapper {
  private ChatMapper(){}

  public static Chat fromCreate(ChatCreateDTO dto){
    Chat c = new Chat();
    c.setPublicacionId(dto.publicacionId);
    return c; // estado ABIERTO por defecto
  }

  public static ChatDTO toDTO(Chat c){
    ChatDTO dto = new ChatDTO();
    dto.chatId = c.getChatId();
    dto.publicacionId = c.getPublicacionId();
    dto.estado = c.getEstado().name();
    dto.fechaCreacion = c.getFechaCreacion().toString();
    return dto;
  }
}
