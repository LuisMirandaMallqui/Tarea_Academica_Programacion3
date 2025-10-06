package pe.edu.pucp.squirlearn.model.publicacion;

import java.util.Date;

public class HistoriaPublicacionDTO {
    
    private Integer historiaPubliId;
    private Date fechaModificacion;
    private PublicacionDTO publicacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío
    public HistoriaPublicacionDTO() {
        this.historiaPubliId = null;
        this.fechaModificacion = null;
        this.publicacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public HistoriaPublicacionDTO(Integer historiaPubliId, Date fechaModificacion,
                                  PublicacionDTO publicacion, Integer usuarioModificacion) {
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

    public PublicacionDTO getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(PublicacionDTO publicacion) {
        this.publicacion = publicacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
