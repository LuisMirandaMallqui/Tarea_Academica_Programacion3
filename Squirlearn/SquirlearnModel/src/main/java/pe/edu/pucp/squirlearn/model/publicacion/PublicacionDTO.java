package pe.edu.pucp.squirlearn.model.publicacion;

import java.util.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDTO;
import pe.edu.pucp.squirlearn.model.item.ItemDTO;

public class PublicacionDTO {
    
    private Integer publicacionId;
    private Date fechaAlta;
    private Date fechaBaja;
    private EstadoPublicacionDTO estadoPublicacion;
    private ItemDTO item;
    private PersonaDTO persona;
    private CalificacionDTO calificacion;
    
    // Constructor vacío (todo en null)
    public PublicacionDTO() {
        this.publicacionId = null;
        this.fechaAlta = null;
        this.fechaBaja = null;
        this.estadoPublicacion = null;
        this.item = null;
        this.persona = null;
        this.calificacion = null;
    }

    // Constructor con parámetros
    public PublicacionDTO(Integer publicacionId, Date fechaAlta, Date fechaBaja,
                          EstadoPublicacionDTO estadoPublicacion, ItemDTO item,
                          PersonaDTO persona, CalificacionDTO calificacion) {
        this.publicacionId = publicacionId;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estadoPublicacion = estadoPublicacion;
        this.item = item;
        this.persona = persona;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public Integer getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Integer idPublicacion) {
        this.publicacionId = idPublicacion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public EstadoPublicacionDTO getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacionDTO estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionDTO calificacion) {
        this.calificacion = calificacion;
    }
}
