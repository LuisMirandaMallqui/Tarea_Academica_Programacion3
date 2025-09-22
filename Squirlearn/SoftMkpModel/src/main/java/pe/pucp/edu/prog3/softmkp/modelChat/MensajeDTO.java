package pe.pucp.edu.prog3.softmkp.modelChat;

import pe.pucp.edu.prog3.softmkp.modelChat.ChatDTO;
import java.util.Date;
import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDTO;

public class MensajeDTO {
    
    private Integer idMensaje;
    private ChatDTO chat;
    private Date fechaEnvio;
    private Date fechaLeido;
    private String mensaje;
    private EstadoMensajeDTO estadoMensaje;
    private PersonaDTO persona;
    
    // Constructor vacío (todo en null)
    public MensajeDTO() {
        this.idMensaje = null;
        this.chat = null;
        this.fechaEnvio = null;
        this.fechaLeido = null;
        this.mensaje = null;
        this.estadoMensaje = null;
        this.persona = null;
    }

    // Constructor con parámetros
    public MensajeDTO(Integer idMensaje, ChatDTO chat, Date fechaEnvio, Date fechaLeido, 
                      String mensaje, EstadoMensajeDTO estadoMensaje, PersonaDTO persona) {
        this.idMensaje = idMensaje;
        this.chat = chat;
        this.fechaEnvio = fechaEnvio;
        this.fechaLeido = fechaLeido;
        this.mensaje = mensaje;
        this.estadoMensaje = estadoMensaje;
        this.persona = persona;
    }

    // Getters y Setters
    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public ChatDTO getChat() {
        return chat;
    }

    public void setChat(ChatDTO chat) {
        this.chat = chat;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaLeido() {
        return fechaLeido;
    }

    public void setFechaLeido(Date fechaLeido) {
        this.fechaLeido = fechaLeido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public EstadoMensajeDTO getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(EstadoMensajeDTO estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
}
