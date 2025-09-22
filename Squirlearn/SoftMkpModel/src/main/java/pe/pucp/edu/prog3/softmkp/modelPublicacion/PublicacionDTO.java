package pe.pucp.edu.prog3.softmkp.modelPublicacion;

import java.util.Date;
import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDTO;
import pe.pucp.edu.prog3.softmkp.modelItem.ItemDTO;

public class PublicacionDTO {
    
    private Integer idPublicacion;
    private Date fechaAlta;
    private Date fechaBaja;
    private EstadoPublicacionDTO estadoPublicacion;
    private ItemDTO item;
    private PersonaDTO persona;
    private CalificacionDTO calificacion;
    
    // Constructor vacío (todo en null)
    public PublicacionDTO() {
        this.idPublicacion = null;
        this.fechaAlta = null;
        this.fechaBaja = null;
        this.estadoPublicacion = null;
        this.item = null;
        this.persona = null;
        this.calificacion = null;
    }

    // Constructor con parámetros
    public PublicacionDTO(Integer idPublicacion, Date fechaAlta, Date fechaBaja,
                          EstadoPublicacionDTO estadoPublicacion, ItemDTO item,
                          PersonaDTO persona, CalificacionDTO calificacion) {
        this.idPublicacion = idPublicacion;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estadoPublicacion = estadoPublicacion;
        this.item = item;
        this.persona = persona;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
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
