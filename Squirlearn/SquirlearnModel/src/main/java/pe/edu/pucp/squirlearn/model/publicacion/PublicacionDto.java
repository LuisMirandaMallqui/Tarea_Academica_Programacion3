package pe.edu.pucp.squirlearn.model.publicacion;

import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class PublicacionDto {
    
    private Integer publicacionId;
    private String fechaAlta;
    private String fechaBaja;
    private EstadoPublicacionDto estadoPublicacion;
    private ItemDto item;
    private PersonaDto persona;
    private Integer calificacion;
    private String usuarioCreacion;
    private String usuarioModificacion;
    
    // Constructor vacío (todo en null)
    public PublicacionDto() {
        this.publicacionId = null;
        this.fechaAlta = null;
        this.fechaBaja = null;
        this.estadoPublicacion = null;
        this.item = null;
        this.persona = null;
        this.calificacion = null;
        this.usuarioCreacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public PublicacionDto(Integer publicacionId, String fechaAlta, String fechaBaja,
                          EstadoPublicacionDto estadoPublicacion, ItemDto item,
                          PersonaDto persona, Integer calificacion, String usuarioCreacion,
                          String usuarioModificacion) {
        this.publicacionId = publicacionId;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estadoPublicacion = estadoPublicacion;
        this.item = item;
        this.persona = persona;
        this.calificacion = calificacion;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Integer idPublicacion) {
        this.publicacionId = idPublicacion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
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
    
    
    public String getusuarioCreacion() {
        return usuarioCreacion;
    }

    public void setusuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    
    
    public String getusuarioModificacion() {
        return usuarioModificacion;
    }

    public void setusuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
