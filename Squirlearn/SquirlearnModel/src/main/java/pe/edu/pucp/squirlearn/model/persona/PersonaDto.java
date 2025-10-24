package pe.edu.pucp.squirlearn.model.persona;

import java.sql.Date;

public class PersonaDto {
    
    private Integer personaId;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String codigo;
    private String correo;
    private String contrasena;
    private Date fechaCreacion;
    private Integer usuarioCreacion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private RolPersonaDto rolPersona;
    private EstadoPersonaDto estadoPersona;
    
    // Constructor vacío
    public PersonaDto() {
        this.personaId = null;
        this.nombres = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.codigo = null;
        this.correo = null;
        this.contrasena = null;
        this.fechaCreacion = null;
        this.usuarioCreacion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
        this.rolPersona = null;
        this.estadoPersona = null;
    }

    // Constructor con parámetros
    public PersonaDto(Integer personaId, String nombres, String primerApellido, String segundoApellido,
                      String codigo, String correo, String contrasena, Date fechaCreacion,
                      Integer usuarioCreacion, Date fechaModificacion, Integer usuarioModificacion,
                      RolPersonaDto rolPersona, EstadoPersonaDto estadoPersona) {
        this.personaId = personaId;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.codigo = codigo;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
        this.rolPersona = rolPersona;
        this.estadoPersona = estadoPersona;
    }
    
    // Getters y Setters
    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public RolPersonaDto getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(RolPersonaDto rolPersona) {
        this.rolPersona = rolPersona;
    }

    public EstadoPersonaDto getEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
    }
}
