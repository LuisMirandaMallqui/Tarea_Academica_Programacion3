package pe.edu.pucp.squirlearn.model.publicacion;

import java.util.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class PublicacionDto {
    
    private Integer publicacionId;
    private Date fechaAlta;
    private Date fechaBaja;
    private EstadoPublicacionDto estadoPublicacion;
    private ItemDto item;
    private PersonaDto persona;
    private Integer calificacion;
    
    // Constructor vacío (todo en null)
    public PublicacionDto() {
        this.publicacionId = null;
        this.fechaAlta = null;
        this.fechaBaja = null;
        this.estadoPublicacion = null;
        this.item = null;
        this.persona = null;
        this.calificacion = null;
    }

    // Constructor con parámetros
    public PublicacionDto(Integer publicacionId, Date fechaAlta, Date fechaBaja,
                          EstadoPublicacionDto estadoPublicacion, ItemDto item,
                          PersonaDto persona, Integer calificacion) {
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

    public EstadoPublicacionDto getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
