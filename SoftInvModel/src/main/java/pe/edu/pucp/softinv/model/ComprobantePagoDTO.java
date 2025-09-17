
package pe.edu.pucp.softinv.model;

import java.time.LocalDateTime;


public class ComprobantePagoDTO {
  private Integer comprobanteDePagoId;
   private PersonasDTO personaId;
   private LocalDateTime fecha;
   private Double montoPago;
   private Integer numeroTransaccion;
   private  String descripcion;
   
   public ComprobantePagoDTO(){
       
       comprobanteDePagoId=null;
       personaId=null;
       fecha=LocalDateTime.now();
       montoPago=null;
       numeroTransaccion=null;
       descripcion=null;
               
       
   }
   
   public ComprobantePagoDTO(Integer comprobanteDePago,PersonasDTO personaId,LocalDateTime fecha,Double montoPago,
           Integer numeroDeTransaccion,String descripcion){
       
       this.comprobanteDePagoId=comprobanteDePago;
       this.personaId=personaId;
       this.fecha=fecha;
       this.montoPago=montoPago;
       this.numeroTransaccion=numeroDeTransaccion;
       
       this.descripcion=descripcion;
   }
    public Integer getComprobanteDePagoId() {
        return comprobanteDePagoId;
    }

    /**
     * @param comprobanteDePagoId the comprobanteDePagoId to set
     */
    public void setComprobanteDePagoId(Integer comprobanteDePagoId) {
        this.comprobanteDePagoId = comprobanteDePagoId;
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

    /**
     * @return the montoPago
     */
    public Double getMontoPago() {
        return montoPago;
    }

    /**
     * @param montoPago the montoPago to set
     */
    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    /**
     * @return the numeroTransaccion
     */
    public Integer getNumeroTransaccion() {
        return numeroTransaccion;
    }

    /**
     * @param numeroTransaccion the numeroTransaccion to set
     */
    public void setNumeroTransaccion(Integer numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
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
 
    
    
    
    
    
}
