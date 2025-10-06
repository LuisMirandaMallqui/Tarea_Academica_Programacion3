package pe.edu.pucp.squirlearn.model.chat;

import java.util.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDTO;

public class MensajeDTO {
    
    private Integer mensajeId;
    private ChatDTO chat;
    private Date fechaEnvio;
    private Date fechaLeido;
    private String mensaje;
    private EstadoMensajeDTO estadoMensaje;
    private PersonaDTO persona;
    
    // Constructor vacío
    public MensajeDTO() {
        this.mensajeId = null;
        this.chat = null;
        this.fechaEnvio = null;
        this.fechaLeido = null;
        this.mensaje = null;
        this.estadoMensaje = null;
        this.persona = null;
    }

    // Constructor con parámetros
    public MensajeDTO(Integer mensajeId, ChatDTO chat, Date fechaEnvio, Date fechaLeido,
                      String mensaje, EstadoMensajeDTO estadoMensaje, PersonaDTO persona) {
        this.mensajeId = mensajeId;
        this.chat = chat;
        this.fechaEnvio = fechaEnvio;
        this.fechaLeido = fechaLeido;
        this.mensaje = mensaje;
        this.estadoMensaje = estadoMensaje;
        this.persona = persona;
    }

    // Getters y Setters
    public Integer getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(Integer mensajeId) {
        this.mensajeId = mensajeId;
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
