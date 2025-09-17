
package pe.edu.pucp.softinv.model;

import java.time.LocalDateTime;


public class NotificacionDTO {

      private Integer notificacionId;
    private PersonasDTO personaId;
    private String mensaje;
    private LocalDateTime fecha;
    
    public NotificacionDTO(){
        
        
        notificacionId=null;
        personaId=null;
        mensaje=null;
        fecha=LocalDateTime.now();
    }
    
    public NotificacionDTO(Integer notificacionId,PersonasDTO personaId,String mensaje, LocalDateTime fecha ){
        
        this.notificacionId=notificacionId;
        this.personaId=personaId;
        this.mensaje=mensaje;
        this.fecha=fecha;
        
    }
    
    public Integer getNotificacionId() {
        return notificacionId;
    }

    /**
     * @param notificacionId the notificacionId to set
     */
    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    /**
     * @return the personaId
     */
    public PersonasDTO getPersonaId() {
        return personaId;
    }

    /**
     * @param personaId the personaId to set
     */
    public void setPersonaId(PersonasDTO personaId) {
        this.personaId = personaId;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
