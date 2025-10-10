package pe.edu.pucp.squirlearn.model.chat;

import java.util.Date;

public class ChatDto {
    
    private Integer chatId;
    private EstadoChatDto estadoChat;
    private Date fechaCreacion;
    private Integer usuarioCreacion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío
    public ChatDto() {
        this.chatId = null;
        this.estadoChat = null;
        this.fechaCreacion = null;
        this.usuarioCreacion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public ChatDto(Integer chatId, EstadoChatDto estadoChat, Date fechaCreacion,
                   Integer usuarioCreacion, Date fechaModificacion, Integer usuarioModificacion) {
        this.chatId = chatId;
        this.estadoChat = estadoChat;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
