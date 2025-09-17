package pe.edu.pucp.softinv.model;

public class MaterialDTO {
   private Integer materialId;
   private Integer tipo_MaterialId;
   private Integer estadoDeMaterial;
   private Integer categoriaTmanio_id;
   private Integer colorIColor_id;
   private String nombre;
   private String descripcion;
   private String imagenUrl;
   private String dimensiones;
   private Integer peso;

    /**
     * @return the materialId
     */
    public Integer getMaterialId() {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    /**
     * @return the tipo_MaterialId
     */
    public Integer getTipo_MaterialId() {
        return tipo_MaterialId;
    }

    /**
     * @param tipo_MaterialId the tipo_MaterialId to set
     */
    public void setTipo_MaterialId(Integer tipo_MaterialId) {
        this.tipo_MaterialId = tipo_MaterialId;
    }

    /**
     * @return the estadoDeMaterial
     */
    public Integer getEstadoDeMaterial() {
        return estadoDeMaterial;
    }

    /**
     * @param estadoDeMaterial the estadoDeMaterial to set
     */
    public void setEstadoDeMaterial(Integer estadoDeMaterial) {
        this.estadoDeMaterial = estadoDeMaterial;
    }

    /**
     * @return the categoriaTmanio_id
     */
    public Integer getCategoriaTmanio_id() {
        return categoriaTmanio_id;
    }

    /**
     * @param categoriaTmanio_id the categoriaTmanio_id to set
     */
    public void setCategoriaTmanio_id(Integer categoriaTmanio_id) {
        this.categoriaTmanio_id = categoriaTmanio_id;
    }

    /**
     * @return the colorIColor_id
     */
    public Integer getColorIColor_id() {
        return colorIColor_id;
    }

    /**
     * @param colorIColor_id the colorIColor_id to set
     */
    public void setColorIColor_id(Integer colorIColor_id) {
        this.colorIColor_id = colorIColor_id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the imagenUrl
     */
    public String getImagenUrl() {
        return imagenUrl;
    }

    /**
     * @param imagenUrl the imagenUrl to set
     */
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    /**
     * @return the dimensiones
     */
    public String getDimensiones() {
        return dimensiones;
    }

    /**
     * @param dimensiones the dimensiones to set
     */
    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     * @return the peso
     */
    public Integer getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
