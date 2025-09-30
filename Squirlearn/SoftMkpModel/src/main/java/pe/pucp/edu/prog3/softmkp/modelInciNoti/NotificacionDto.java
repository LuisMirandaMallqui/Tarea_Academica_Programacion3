package pe.pucp.edu.prog3.softmkp.modelInciNoti;

import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDto;
import java.util.Date;

public class NotificacionDto {
    
    private Integer notificacionId;
    private Date fecha;
    private String mensaje;
    private PersonaDto persona;
    private MotivoDto motivo;
    
    // Constructor vacío
    public NotificacionDto() {
        this.notificacionId = null;
        this.fecha = null;
        this.mensaje = null;
        this.persona = null;
        this.motivo = null;
    }

    // Constructor con parámetros
    public NotificacionDto(Integer notificacionId, Date fecha, String mensaje,
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
