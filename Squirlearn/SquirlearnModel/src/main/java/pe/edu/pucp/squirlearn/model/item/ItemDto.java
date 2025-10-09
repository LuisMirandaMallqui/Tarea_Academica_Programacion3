package pe.edu.pucp.squirlearn.model.item;

    public class ItemDto {

        private Integer itemId;
        private Double precio;
        private String nombre;
        private String descripcion;
        private Boolean esVenta;
        private SubcategoriaDto subcategoria;
        private CategoriaDto categoria;
        private ColorDto color;
        private EstadoItemDto estadoItem;
        private CondicionDto condicion;
        private TamanoDto tamano;
        private FormatoDto formato;
        
        // Constructor vacío
    public ItemDto() {
        this.itemId = null;
        this.precio = null;
        this.nombre = null;
        this.descripcion = null;
        this.esVenta = null;
        this.subcategoria = null;
        this.categoria = null;
        this.color = null;
        this.estadoItem = null;
        this.condicion = null;
        this.tamano = null;
        this.formato = null;
    }

    // Constructor con parámetros
    public ItemDto(Integer itemId, Double precio, String nombre,String descripcion ,Boolean esVenta,
                   SubcategoriaDto subcategoria, CategoriaDto categoria, ColorDto color, 
                   EstadoItemDto estadoItem, CondicionDto condicion,
                   TamanoDto tamano, FormatoDto formato) {
        this.itemId = itemId;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esVenta = esVenta;
        this.subcategoria = subcategoria;
        this.categoria = categoria;
        this.color = color;
        this.estadoItem = estadoItem;
        this.condicion = condicion;
        this.tamano = tamano;
        this.formato = formato;
    }

    // Getters y Setters
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsVenta() {
        return esVenta;
    }

    public void setEsVenta(Boolean esVenta) {
        this.esVenta = esVenta;
    }

    public SubcategoriaDto getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public ColorDto getColor() {
        return color;
    }

    public void setColor(ColorDto color) {
        this.color = color;
    }

    public EstadoItemDto getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(EstadoItemDto estadoItem) {
        this.estadoItem = estadoItem;
    }

    public CondicionDto getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionDto condicion) {
        this.condicion = condicion;
    }

    public TamanoDto getTamano() {
        return tamano;
    }

    public void setTamano(TamanoDto tamano) {
        this.tamano = tamano;
    }

    public FormatoDto getFormato() {
        return formato;
    }

    public void setFormato(FormatoDto formato) {
        this.formato = formato;
    }

}
