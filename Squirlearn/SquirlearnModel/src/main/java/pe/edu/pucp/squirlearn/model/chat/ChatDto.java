package pe.edu.pucp.squirlearn.model.chat;

import java.util.List;

public class ChatDto {
    
    private Integer chatId;
    private EstadoChatDto estadoChat;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private List<MensajeDto> mensajes;
    
    // Constructor vacío
    public ChatDto() {
        this.chatId = null;
        this.estadoChat = null;
        this.usuarioModificacion = null;
        this.mensajes = null;
        this.usuarioCreacion = null;
    }

    // Constructor con parámetros
    public ChatDto(Integer chatId, EstadoChatDto estadoChat, String usuarioModificacion,
            List<MensajeDto> mensajes, String usuarioCreacion) {
        this.chatId = chatId;
        this.estadoChat = estadoChat;
        this.usuarioModificacion = usuarioModificacion;
        this.mensajes = mensajes;
        this.usuarioCreacion = usuarioCreacion;
    }

    // Getters y Setters
    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public EstadoChatDto getEstadoChat() {
        return estadoChat;
    }

    public void setEstadoChat(EstadoChatDto estadoChat) {
        this.estadoChat = estadoChat;
    }

    
    public List<MensajeDto> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<MensajeDto> mensajes) {
        this.mensajes = mensajes;
    }
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    /**
     * @return the usuarioModificacion
     */
    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    /**
     * @param usuarioModificacion the usuarioModificacion to set
     */
    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
