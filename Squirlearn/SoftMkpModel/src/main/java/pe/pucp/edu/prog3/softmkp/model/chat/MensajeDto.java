package pe.pucp.edu.prog3.softmkp.model.chat;

import pe.pucp.edu.prog3.softmkp.model.chat.ChatDto;
import java.util.Date;
import pe.pucp.edu.prog3.softmkp.model.persona.PersonaDto;

public class MensajeDto {
    
    private Integer mensajeId;
    private ChatDto chat;
    private Date fechaEnvio;
    private Date fechaLeido;
    private String mensaje;
    private EstadoMensajeDto estadoMensaje;
    private PersonaDto persona;
    
    // Constructor vacío
    public MensajeDto() {
        this.mensajeId = null;
        this.chat = null;
        this.fechaEnvio = null;
        this.fechaLeido = null;
        this.mensaje = null;
        this.estadoMensaje = null;
        this.persona = null;
    }

    // Constructor con parámetros
    public MensajeDto(Integer mensajeId, ChatDto chat, Date fechaEnvio, Date fechaLeido,
                      String mensaje, EstadoMensajeDto estadoMensaje, PersonaDto persona) {
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

    public ChatDto getChat() {
        return chat;
    }

    public void setChat(ChatDto chat) {
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

    public EstadoMensajeDto getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }
}
