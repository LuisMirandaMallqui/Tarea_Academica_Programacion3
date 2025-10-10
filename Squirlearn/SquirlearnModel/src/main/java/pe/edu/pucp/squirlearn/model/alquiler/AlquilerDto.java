package pe.edu.pucp.squirlearn.model.alquiler;

import java.util.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class AlquilerDto {
    
    private Integer alquilerId;
    private PersonaDto persona;
    private ItemDto item;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean devuelto;
    private Double monto;
    private Date fechaCreacion;
    private Integer usuarioCreacion;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío (inicializa en null)
    public AlquilerDto() {
        this.alquilerId = null;
        this.persona = null;
        this.item = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.devuelto = null;
        this.monto = null;
        this.fechaCreacion = null;
        this.usuarioCreacion = null;
        this.fechaModificacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public AlquilerDto(Integer alquilerId, PersonaDto persona, ItemDto item,
                       Date fechaInicio, Date fechaFin, Boolean devuelto, Double monto,
                       Date fechaCreacion, Integer usuarioCreacion,
                       Date fechaModificacion, Integer usuarioModificacion) {
        this.alquilerId = alquilerId;
        this.persona = persona;
        this.item = item;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.devuelto = devuelto;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(Integer alquilerId) {
        this.alquilerId = alquilerId;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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
