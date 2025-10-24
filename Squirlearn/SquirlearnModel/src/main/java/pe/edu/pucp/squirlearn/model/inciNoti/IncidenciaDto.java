package pe.edu.pucp.squirlearn.model.inciNoti;

import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import java.sql.Date;

public class IncidenciaDto {

    
    private Integer incidenciaDto;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaSolucion;
    private Integer usuarioCreacion;
    private Integer usuarioSolucion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private NotificacionDto notificacion;
    private PersonaDto persona;
    private MotivoDto motivo;
    private Integer resuelto;
    
    // Constructor vacío
    public IncidenciaDto() {
        this.incidenciaDto = null;
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
        this.resuelto = null;
    }

    // Constructor con parámetros
    public IncidenciaDto(Integer incidenciaDto, String descripcion, Date fechaCreacion, Date fechaSolucion,
                         Integer usuarioCreacion, Integer usuarioSolucion, Date fechaModificacion,
                         Integer usuarioModificacion, NotificacionDto notificacion, PersonaDto persona,
                         MotivoDto motivo,Integer resuelto) {
        this.incidenciaDto = incidenciaDto;
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
        this.resuelto = resuelto;
    }

    // Getters y Setters
    public Integer getIncidenciaDto() {
        return incidenciaDto;
    }

    public void setIncidenciaDto(Integer incidenciaDto) {
        this.incidenciaDto = incidenciaDto;
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

    public NotificacionDto getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(NotificacionDto notificacion) {
        this.notificacion = notificacion;
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
    
    /**
     * @return the resuelto
     */
    public Integer getResuelto() {
        return resuelto;
    }

    /**
     * @param resuelto the resuelto to set
     */
    public void setResuelto(Integer resuelto) {
        this.resuelto = resuelto;
    }
}   
