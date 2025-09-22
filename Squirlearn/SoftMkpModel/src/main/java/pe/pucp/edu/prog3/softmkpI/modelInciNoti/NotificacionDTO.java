package pe.pucp.edu.prog3.softmkpI.modelInciNoti;

import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDTO;
import java.util.Date;

public class NotificacionDTO {
    
    private Integer idNotificacion;
    private Date fecha;
    private String mensaje;
    private PersonaDTO perona;
    private MotivoDTO motivo;
    private PersonaDTO persona;
    
    // Constructor vacío
    public NotificacionDTO() {
        this.idNotificacion = null;
        this.fecha = null;
        this.mensaje = null;
        this.persona = null;
        this.motivo = null;
    }

    // Constructor con parámetros
    public NotificacionDTO(Integer idNotificacion, Date fecha, String mensaje, PersonaDTO persona, MotivoDTO motivo) {
        this.idNotificacion = idNotificacion;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.persona = persona;
        this.motivo = motivo;
    }

    // Getters y Setters
    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
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

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public MotivoDTO getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoDTO motivo) {
        this.motivo = motivo;
    }
}
