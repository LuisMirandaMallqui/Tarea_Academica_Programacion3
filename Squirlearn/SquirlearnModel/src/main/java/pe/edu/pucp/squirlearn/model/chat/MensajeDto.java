package pe.edu.pucp.squirlearn.model.chat;

import java.sql.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class MensajeDto {
    
    private Integer mensajeId;
    private ChatDto chat;
    private EstadoMensajeDto estadoMensaje;
    private PersonaDto persona;
    private Date fechaEnvio;
    private Date fechaLeido;
    private String mensaje;
    private String usuario;
    private String usuarioCreacion;
    
    // Constructor vacío
    public MensajeDto() {
        this.mensajeId = null;
        this.chat = null;
        this.fechaEnvio = null;
        this.fechaLeido = null;
        this.mensaje = null;
        this.estadoMensaje = null;
        this.persona = null;
        this.usuario = null;
        this.usuarioCreacion = null;
    }

    // Constructor con parámetros
    public MensajeDto(Integer mensajeId, ChatDto chat, Date fechaEnvio, Date fechaLeido,
                      String mensaje, EstadoMensajeDto estadoMensaje, PersonaDto persona,
                      String usuario,String usuarioCreacion) {
        this.mensajeId = mensajeId;
        this.chat = chat;
        this.fechaEnvio = fechaEnvio;
        this.fechaLeido = fechaLeido;
        this.mensaje = mensaje;
        this.estadoMensaje = estadoMensaje;
        this.persona = persona;
        this.usuario = usuario;
        this.usuario = usuarioCreacion;
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
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}
