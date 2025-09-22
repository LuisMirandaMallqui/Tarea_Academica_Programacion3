package pe.pucp.edu.prog3.softmkpI.modelInciNoti;

import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDTO;
import java.util.Date;

public class IncidenciaDTO {
    
    private Integer idIncidencia;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaSolucion;
    private Integer usuarioCreacion;
    private Integer usuarioSolucion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private NotificacionDTO notificacion;
    private PersonaDTO persona;
    private MotivoDTO motivo;
    
    // Constructor vacío (inicializa todo en null)
    public IncidenciaDTO() {
        this.idIncidencia = null;
        this.descripcion = null;
        this.fechaCreacion = null;
        this.fechaSolucion = null;
        this.usuarioCreacion = null;
        this.usuarioSolucion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
        this.notificacion = null;
        this.persona = null;
        this.motivo = null;
    }

    // Constructor con parámetros
    public IncidenciaDTO(Integer idIncidencia, String descripcion, Date fechaCreacion, Date fechaSolucion,
                         Integer usuarioCreacion, Integer usuarioSolucion, Date fechaModificacion,
                         Integer usuarioModificacion, NotificacionDTO notificacion,
                         PersonaDTO persona, MotivoDTO motivo) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaSolucion = fechaSolucion;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioSolucion = usuarioSolucion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
        this.notificacion = notificacion;
        this.persona = persona;
        this.motivo = motivo;
    }

    // Getters y Setters
    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Integer getUsuarioSolucion() {
        return usuarioSolucion;
    }

    public void setUsuarioSolucion(Integer usuarioSolucion) {
        this.usuarioSolucion = usuarioSolucion;
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

    public NotificacionDTO getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(NotificacionDTO notificacion) {
        this.notificacion = notificacion;
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
