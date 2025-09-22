package pe.pucp.edu.prog3.softmkp.modelChat;

import java.util.Date;

public class ChatDTO {
    
    private Integer idChat;
    private EstadoChatDTO estadoChat;
    private Date fechaCreacion;
    private Integer usuarioCreacion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío
    public ChatDTO() {
        this.idChat = null;
        this.estadoChat = null;
        this.fechaCreacion = null;
        this.usuarioCreacion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public ChatDTO(Integer idChat, EstadoChatDTO estadoChat, Date fechaCreacion, Integer usuarioCreacion,
                   Date fechaModificacion, Integer usuarioModificacion) {
        this.idChat = idChat;
        this.estadoChat = estadoChat;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public EstadoChatDTO getEstadoChat() {
        return estadoChat;
    }

    public void setEstadoChat(EstadoChatDTO estadoChat) {
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
