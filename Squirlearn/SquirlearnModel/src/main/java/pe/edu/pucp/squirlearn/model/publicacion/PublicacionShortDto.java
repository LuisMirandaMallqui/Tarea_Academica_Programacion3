
package pe.edu.pucp.squirlearn.model.publicacion;

public class PublicacionShortDto {

    private Integer publicacionId;
    private String nombre;
    private Integer itemId;
    private Double precio;
    private Integer personaId;
    private Integer estadoPublicacionId;
    private Boolean esVenta;
    private String categoriaNombre;
    private String estadoNombre;
    private String fechaEnvio;
    
    public PublicacionShortDto(){
        this.publicacionId = null;
        this.nombre = null;
        this.itemId = null;
        this.precio = null;
        this.personaId = null;
        this.estadoPublicacionId = null;
        this.esVenta = null;
        this.categoriaNombre = null;
        this.estadoNombre = null;
        this.fechaEnvio = null;
    }
    
     public PublicacionShortDto(Integer publicacionId, String nombre, Integer itemId, Double precio, Integer personaId, Integer estadoPublicacionId, Boolean esVenta, String CategoriaNombre, String EstadoNombre, String FechaEnvio) {
        this.publicacionId = publicacionId;
        this.nombre = nombre;
        this.itemId = itemId;
        this.precio = precio;
        this.personaId = personaId;
        this.estadoPublicacionId = estadoPublicacionId;
        this.esVenta = esVenta;
        this.categoriaNombre = CategoriaNombre;
        this.estadoNombre = EstadoNombre;
        this.fechaEnvio = FechaEnvio;
    }
    
     public Integer getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Integer publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getEstadoPublicacionId() {
        return estadoPublicacionId;
    }

    public void setEstadoPublicacionId(Integer estadoPublicacionId) {
        this.estadoPublicacionId = estadoPublicacionId;
    }

    public Boolean getEsVenta() {
        return esVenta;
    }

    public void setEsVenta(Boolean esVenta) {
        this.esVenta = esVenta;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String CategoriaNombre) {
        this.categoriaNombre = CategoriaNombre;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String EstadoNombre) {
        this.estadoNombre = EstadoNombre;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String FechaEnvio) {
        this.fechaEnvio = FechaEnvio;
    }
     
}
