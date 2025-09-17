
package pe.edu.pucp.softinv.model;

import java.time.LocalDateTime;


public class PublicacionDTO {
   private Integer publicacionId;
    private MaterialDTO materialId;
    private EstadoPublicacionDTO estadoPublicacion;
    private PersonasDTO personaId;
    private Integer valoracion;
    private LocalDateTime fecha;
    private Double precio;
    
    public PublicacionDTO(){
        publicacionId=null;
        materialId=null;
        estadoPublicacion=null;
        personaId=null;
        valoracion=null;
        fecha=LocalDateTime.now();
        precio=null;
        
    }
    
    public PublicacionDTO(Integer publucacionId,MaterialDTO materiaId,EstadoPublicacionDTO estadoPublicacion,
            PersonasDTO personaId,Integer valoracion,LocalDateTime fecha,Double precio){
        
        this.publicacionId=publucacionId;
        this.materialId=materiaId;
        this.estadoPublicacion=estadoPublicacion;
        this.personaId=personaId;
        this.valoracion=valoracion;
        this.fecha=fecha;
        this.precio=precio;
       
    }
    
    public void setMaterialId(MaterialDTO material){
        this.materialId=material;
    }
    public MaterialDTO getMaterialId(){
        return materialId;
        
    }
    
    public void setEstadoPublicacionId(EstadoPublicacionDTO estado){
        this.estadoPublicacion=estado;
    }
    
    public EstadoPublicacionDTO getEstadoPublicacionId(){
        return this.estadoPublicacion;
    }
            
            
    public Integer getPublicacionId() {
        return publicacionId;
    }

    /**
     * @param publicacionId the publicacionId to set
     */
    public void setPublicacionId(Integer publicacionId) {
        this.publicacionId = publicacionId;
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
     * @return the valoracion
     */
    public Integer getValoracion() {
        return valoracion;
    }

    /**
     * @param valoracion the valoracion to set
     */
    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
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
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
   
 
    
    
    
}
