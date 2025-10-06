package pe.pucp.edu.prog3.softmkp.model.persona;

import java.util.Date;


public class RolPersonaDto {
    
    private Integer rolPersonaId;
    private String nombre;
    private Date fechaCreacion;
    private Integer usuarioCreacion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío (inicializa todo en null)
    public RolPersonaDto() {
        this.rolPersonaId = null;
        this.nombre = null;
        this.fechaCreacion = null;
        this.usuarioCreacion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public RolPersonaDto(Integer rolPersonaId, String nombre, Date fechaCreacion,
                         Integer usuarioCreacion, Date fechaModificacion, Integer usuarioModificacion) {
        this.rolPersonaId = rolPersonaId;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getRolPersonaId() {
        return rolPersonaId;
    }

    public void setRolPersonaId(Integer idRolPersona) {
        this.rolPersonaId = idRolPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
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
    
}
