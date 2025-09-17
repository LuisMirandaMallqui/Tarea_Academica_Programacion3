
package pe.edu.pucp.softinv.model;


public class PersonasDTO {

      private Integer personaId;
    private Boolean esAdministador;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;
    private String codigoUniversitario;
    private String tipoDocumento;
    private String numeroDocumento;
    private String contraseña;
    
    public PersonasDTO(){
        personaId=null;
        esAdministador=false;
     nombres=null;
     primerApellido=null;
     segundoApellido=null;
     correoElectronico=null;
     codigoUniversitario=null;
     tipoDocumento=null;
     numeroDocumento=null;
     contraseña=null;
    }
    
    public PersonasDTO(Integer personaId,Boolean esAdministador,String nombres,
            String primerApellido, String segundoApellido,String correoElectronico,
            String codigoUniversitario,String tipoDocumento,String numeroDocumento,String contraseña  ){
       this.personaId=personaId;
      this.esAdministador=esAdministador;
     this.nombres=nombres;
     this.primerApellido=primerApellido;
     this.segundoApellido=segundoApellido;
     this.correoElectronico=correoElectronico;
     this.codigoUniversitario=codigoUniversitario;
     this.tipoDocumento=tipoDocumento;
     this.numeroDocumento=numeroDocumento;
     this.contraseña=contraseña;
        
        
    }
    public Integer getPersonaId() {
        return personaId;
    }

    /**
     * @param personaId the personaId to set
     */
    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    /**
     * @return the esAdministador
     */
    public Boolean getEsAdministador() {
        return esAdministador;
    }

    /**
     * @param esAdministador the esAdministador to set
     */
    public void setEsAdministador(Boolean esAdministador) {
        this.esAdministador = esAdministador;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the codigoUniversitario
     */
    public String getCodigoUniversitario() {
        return codigoUniversitario;
    }

    /**
     * @param codigoUniversitario the codigoUniversitario to set
     */
    public void setCodigoUniversitario(String codigoUniversitario) {
        this.codigoUniversitario = codigoUniversitario;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }   
    
}
