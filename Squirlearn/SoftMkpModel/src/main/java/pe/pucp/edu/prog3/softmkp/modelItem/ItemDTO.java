package pe.pucp.edu.prog3.softmkp.modelItem;

    public class ItemDTO {

        private Integer idItem;
        private Double precio;
        private String nombre;
        private Boolean esVenta;
        private SubcategoriaDTO subcategoria;
        private CategoriaDTO categoria;
        private ColorDTO color;
        private FacultadDTO facultad;
        private EstadoItemDTO estadoItem;
        private CondicionDTO condicion;
        private TamanoDTO tamano;
        private FormatoDTO formato;
        
        // Constructor vacío (todo inicializado en null)
    public ItemDTO() {
        this.idItem = null;
        this.precio = null;
        this.nombre = null;
        this.esVenta = null;
        this.subcategoria = null;
        this.categoria = null;
        this.color = null;
        this.facultad = null;
        this.estadoItem = null;
        this.condicion = null;
        this.tamano = null;
        this.formato = null;
    }

    // Constructor con parámetros
    public ItemDTO(Integer idItem, Double precio, String nombre, Boolean esVenta,
                   SubcategoriaDTO subcategoria, CategoriaDTO categoria, ColorDTO color,
                   FacultadDTO facultad, EstadoItemDTO estadoItem, CondicionDTO condicion,
                   TamanoDTO tamano, FormatoDTO formato) {
        this.idItem = idItem;
        this.precio = precio;
        this.nombre = nombre;
        this.esVenta = esVenta;
        this.subcategoria = subcategoria;
        this.categoria = categoria;
        this.color = color;
        this.facultad = facultad;
        this.estadoItem = estadoItem;
        this.condicion = condicion;
        this.tamano = tamano;
        this.formato = formato;
    }

    // Getters y Setters
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
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

    public Boolean getEsVenta() {
        return esVenta;
    }

    public void setEsVenta(Boolean esVenta) {
        this.esVenta = esVenta;
    }

    public SubcategoriaDTO getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaDTO subcategoria) {
        this.subcategoria = subcategoria;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public ColorDTO getColor() {
        return color;
    }

    public void setColor(ColorDTO color) {
        this.color = color;
    }

    public FacultadDTO getFacultad() {
        return facultad;
    }

    public void setFacultad(FacultadDTO facultad) {
        this.facultad = facultad;
    }

    public EstadoItemDTO getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(EstadoItemDTO estadoItem) {
        this.estadoItem = estadoItem;
    }

    public CondicionDTO getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionDTO condicion) {
        this.condicion = condicion;
    }

    public TamanoDTO getTamano() {
        return tamano;
    }

    public void setTamano(TamanoDTO tamano) {
        this.tamano = tamano;
    }

    public FormatoDTO getFormato() {
        return formato;
    }

    public void setFormato(FormatoDTO formato) {
        this.formato = formato;
    }

    }
