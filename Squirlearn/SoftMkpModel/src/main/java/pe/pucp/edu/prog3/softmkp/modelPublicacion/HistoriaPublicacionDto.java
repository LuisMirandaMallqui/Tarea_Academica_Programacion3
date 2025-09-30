package pe.pucp.edu.prog3.softmkp.modelPublicacion;

import java.util.Date;

public class HistoriaPublicacionDto {
    
    private Integer historiaPubliId;
    private Date fechaModificacion;
    private PublicacionDto publicacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío
    public HistoriaPublicacionDto() {
        this.historiaPubliId = null;
        this.fechaModificacion = null;
        this.publicacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public HistoriaPublicacionDto(Integer historiaPubliId, Date fechaModificacion,
                                  PublicacionDto publicacion, Integer usuarioModificacion) {
        this.historiaPubliId = historiaPubliId;
        this.fechaModificacion = fechaModificacion;
        this.publicacion = publicacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getHistoriaPubliId() {
        return historiaPubliId;
    }

    public void setHistoriaPubliId(Integer historiaPubliId) {
        this.historiaPubliId = historiaPubliId;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public PublicacionDto getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(PublicacionDto publicacion) {
        this.publicacion = publicacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
