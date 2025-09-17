
package pe.edu.pucp.softinv.model;

import java.time.LocalDateTime;


public class EstadoPublicacionDTO {
    
   private Integer estadoPublicacionId;
   private String descripcion;
   private LocalDateTime fechaIngreso;
   
   public EstadoPublicacionDTO(){
       estadoPublicacionId=null;
       descripcion=null;
       fechaIngreso=LocalDateTime.now();
               
   }
   
   public EstadoPublicacionDTO(Integer estado,String descripcion,LocalDateTime fecha){
       this.descripcion=descripcion;
       this.estadoPublicacionId=estado;
       this.fechaIngreso=fecha;
               
   }
    public Integer getEstadoPublicacionId() {
        return estadoPublicacionId;
    }

    /**
     * @param estadoPublicacionId the estadoPublicacionId to set
     */
    public void setEstadoPublicacionId(Integer estadoPublicacionId) {
        this.estadoPublicacionId = estadoPublicacionId;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaIngreso
     */
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
  
   
}
