package pe.edu.pucp.squirlearn.model.inciNoti;

import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import java.sql.Date;

public class IncidenciaDto {

    
    private Integer incidenciaId;
    private PersonaDto persona;
    private MotivoDto motivo;
    private String descripcion;
    private Integer resuelto;
    private Integer usuarioSolucion;
    private String usuarioCreacion;
    
    // Constructor vacío
    public IncidenciaDto() {
        this.incidenciaId = null;
        this.descripcion = null;
        this.usuarioSolucion = null;
        this.persona = null;
        this.motivo = null;
        this.resuelto = null;
    }

    // Constructor con parámetros
    public IncidenciaDto(Integer incidenciaId, String descripcion,
                         Integer usuarioSolucion, PersonaDto persona,
                         MotivoDto motivo,Integer resuelto) {
        this.incidenciaId = incidenciaId;
        this.descripcion = descripcion;
        this.usuarioSolucion = usuarioSolucion;
        this.persona = persona;
        this.motivo = motivo;
        this.resuelto = resuelto;
    }

    // Getters y Setters
    public Integer getIncidenciaId() {
        return incidenciaId;
    }

    public void setIncidenciaId(Integer incidenciaId) {
        this.incidenciaId = incidenciaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUsuarioSolucion() {
        return usuarioSolucion;
    }

    public void setUsuarioSolucion(Integer usuarioSolucion) {
        this.usuarioSolucion = usuarioSolucion;
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
    
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}   
