package pe.pucp.edu.prog3.softmkp.modelPublicacion;

import java.util.Date;

public class HistoriaPublicacionDTO {
    
    private Integer idHistoriaPubli;
    private Date fechaModificacion;
    private PublicacionDTO publicacion;
    private Integer usuarioModificacion;
    
    // Constructor vacío (inicializa en null)
    public HistoriaPublicacionDTO() {
        this.idHistoriaPubli = null;
        this.fechaModificacion = null;
        this.publicacion = null;
        this.usuarioModificacion = null;
    }

    // Constructor con parámetros
    public HistoriaPublicacionDTO(Integer idHistoriaPubli, Date fechaModificacion,
                                  PublicacionDTO publicacion, Integer usuarioModificacion) {
        this.idHistoriaPubli = idHistoriaPubli;
        this.fechaModificacion = fechaModificacion;
        this.publicacion = publicacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    // Getters y Setters
    public Integer getIdHistoriaPubli() {
        return idHistoriaPubli;
    }

    public void setIdHistoriaPubli(Integer idHistoriaPubli) {
        this.idHistoriaPubli = idHistoriaPubli;
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
