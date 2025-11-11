package pe.edu.pucp.squirlearn.model.chat;

import java.util.List;

public class ChatDto {
    
    private Integer chatId;
    private EstadoChatDto estadoChat;
    private String usuario;
    private String usuarioCreacion;
    private List<MensajeDto> mensajes;
    
    // Constructor vacío
    public ChatDto() {
        this.chatId = null;
        this.estadoChat = null;
        this.usuario = null;
        this.mensajes = null;
        this.usuarioCreacion = null;
    }

    // Constructor con parámetros
    public ChatDto(Integer chatId, EstadoChatDto estadoChat, String usuario,
            List<MensajeDto> mensajes, String usuarioCreacion) {
        this.chatId = chatId;
        this.estadoChat = estadoChat;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
}
