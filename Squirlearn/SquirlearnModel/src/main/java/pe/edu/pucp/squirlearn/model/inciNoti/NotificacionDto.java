package pe.edu.pucp.squirlearn.model.inciNoti;

import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import java.util.Date;

public class NotificacionDto {
    
    private Integer notificacionId;
    private PersonaDto persona;
    private MotivoDto motivo;
    private String fecha;
    private String mensaje;
    
    // Constructor vacío
    public NotificacionDto() {
        this.notificacionId = null;
        this.fecha = null;
        this.mensaje = null;
        this.persona = null;
        this.motivo = null;
    }

    // Constructor con parámetros
    public NotificacionDto(Integer notificacionId, String fecha, String mensaje,
                           PersonaDto persona, MotivoDto motivo) {
        this.notificacionId = notificacionId;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.persona = persona;
        this.motivo = motivo;
    }

    // Getters y Setters
    public Integer getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public MotivoDto getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoDto motivo) {
        this.motivo = motivo;
    }
}
