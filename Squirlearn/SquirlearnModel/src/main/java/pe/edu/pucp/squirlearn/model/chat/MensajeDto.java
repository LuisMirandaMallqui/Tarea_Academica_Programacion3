package pe.edu.pucp.squirlearn.model.chat;

import java.util.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class MensajeDto {
    
    private Integer mensajeId;
    private ChatDto chat;
    private EstadoMensajeDto estadoMensaje;
    private PersonaDto persona;
    private String fechaEnvio;
    private String fechaLeido;
    private String mensaje;
    
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
    public MensajeDto(Integer mensajeId, ChatDto chat, String fechaEnvio, String fechaLeido,
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

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getFechaLeido() {
        return fechaLeido;
    }

    public void setFechaLeido(String fechaLeido) {
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
