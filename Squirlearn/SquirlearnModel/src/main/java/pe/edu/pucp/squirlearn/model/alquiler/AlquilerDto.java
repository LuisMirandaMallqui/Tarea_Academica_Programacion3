package pe.edu.pucp.squirlearn.model.alquiler;

import java.util.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class AlquilerDto {

    private Integer alquilerId;
    private PersonaDto persona;
    private ItemDto item;
    private Double monto;
    private Boolean devuelto;
    private String usuarioCreacion;
    
    private String fechaInicio;  // <--- POR ESTO
    private String fechaFin;
    private String fechaCreacion;
    
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
    }

    // Constructor con parámetros
    public AlquilerDto(Integer alquilerId, PersonaDto persona, ItemDto item,
                       String fechaInicio, String fechaFin, Boolean devuelto, Double monto,
                       String fechaCreacion, String usuarioCreacion) {
        this.alquilerId = alquilerId;
        this.persona = persona;
        this.item = item;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.devuelto = devuelto;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
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

    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    
        /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
