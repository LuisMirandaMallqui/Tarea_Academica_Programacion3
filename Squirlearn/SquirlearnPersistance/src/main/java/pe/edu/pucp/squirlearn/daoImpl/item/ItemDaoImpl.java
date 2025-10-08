package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.ItemDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class ItemDaoImpl extends DAOImplBase implements ItemDao{

    private ItemDto item;

    public ItemDaoImpl() {
        super("items");
        this.item = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ITEM_ID", true, true));
        this.listaColumnas.add(new Columna("PRECIO", false, false));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("ES_VENTA", false, false));
        this.listaColumnas.add(new Columna("SUBCATEGORIA", false, false));
        this.listaColumnas.add(new Columna("CATEGORIA", false, false));
        this.listaColumnas.add(new Columna("COLOR", false, false));
        this.listaColumnas.add(new Columna("ESTADO_ITEM", false, false));
        this.listaColumnas.add(new Columna("CONDICION", false, false));
        this.listaColumnas.add(new Columna("FORMATO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setDouble(1, this.item.getPrecio());
        this.statement.setString(2, this.item.getNombre());
        this.statement.setInt(3, (this.item.getEsVenta()!=null && this.item.getEsVenta())?1:0);
        this.statement.setInt(4, this.item.getSubcategoria().getSubcategoriaId());
        this.statement.setInt(5, this.item.getCategoria().getCategoriaId());
        this.statement.setInt(6, this.item.getColor().getColorId());
        this.statement.setInt(7, this.item.getEstadoItem().getEstadoItemId());
        this.statement.setInt(8, this.item.getCondicion().getCondicionId());
        this.statement.setInt(9, this.item.getFormato().getFormatoId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setDouble(1, this.item.getPrecio());
        this.statement.setString(2, this.item.getNombre());
        this.statement.setInt(3, (this.item.getEsVenta()!=null && this.item.getEsVenta())?1:0);
        this.statement.setInt(4, this.item.getSubcategoria().getSubcategoriaId());
        this.statement.setInt(5, this.item.getCategoria().getCategoriaId());
        this.statement.setInt(6, this.item.getColor().getColorId());
        this.statement.setInt(7, this.item.getEstadoItem().getEstadoItemId());
        this.statement.setInt(8, this.item.getCondicion().getCondicionId());
        this.statement.setInt(9, this.item.getFormato().getFormatoId());
        this.statement.setInt(10, this.item.getItemId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.item.getItemId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.item.getItemId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.item = new ItemDto();
        this.item.setItemId(this.resultSet.getInt("ITEM_ID"));
        this.item.setPrecio(this.resultSet.getDouble("PRECIO"));
        this.item.setNombre(this.resultSet.getString("NOMBRE"));
        this.item.setEsVenta(this.resultSet.getInt("ES_VENTA") == 1);
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.item = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.item);
    }
    
    @Override
    public Integer insertar(ItemDto item) {
        this.item = item;
        return super.insertar();
    }
    @Override
    public ItemDto obtenerPorId(Integer id) {
        this.item = new ItemDto();
        this.item.setItemId(id);
        super.obtenerPorId();
        return this.item;
    }

    @Override
    public ArrayList<ItemDto> listarTodos() {
        return (ArrayList<ItemDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ItemDto item) {
        this.item = item;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ItemDto item) {
        this.item = item;
        return super.eliminar();
    }


// ====== PLANTILLA PARA PROCEDIMIENTOS ALMACENADOS ======
public void ejecutarProcedimientoPlantilla() {
    Object parametros = null; // TODO: builder/DTO de parámetros
    String sql = "{call MI_SP_EJEMPLO ()}"; // TODO: SP real y firma
    Boolean conTransaccion = true;
    this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosPlantilla, parametros, conTransaccion);
}

private void incluirValorDeParametrosPlantilla(Object objetoParametros) {
    // TODO: castear objetoParametros y hacer setXxx en this.statement
    // this.statement.setInt(1, ...);
    // this.statement.setString(2, ...);
}

public void ejecutarProcedimientoSinParametros(String nombreSP, boolean conTransaccion) {
    String sql = "{call " + nombreSP + "()}";
    this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
}
// ====== FIN PLANTILLA PARA PROCEDIMIENTOS ALMACENADOS ======
}
