
package pe.edu.pucp.softinv.model;


public class IncidenciaDTO{
    
    private Integer incidenciaId;
    private PersonasDTO personaId; 
    private String descripcion;

     public IncidenciaDTO(){

    incidenciaId=null;
    personaId=null;
    descripcion=null;
    }

    
    public IncidenciaDTO(Integer incidenciaId,PersonasDTO personaId,String descripcion){
        
        this.incidenciaId=incidenciaId;
        this.descripcion=descripcion;
        this.personaId=personaId;
        
    }
    public Integer getIncidenciaId() {
        return incidenciaId;
    }

    /**
     * @param incidenciaId the incidenciaId to set
     */
    public void setIncidenciaId(Integer incidenciaId) {
        this.incidenciaId = incidenciaId;
    }

    /**
     * @return the personaId
     */
    public PersonasDTO getPersonaId() {
        return personaId;
    }

    public void setPersonaId(PersonasDTO personaId) {
        this.personaId = personaId;
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

 