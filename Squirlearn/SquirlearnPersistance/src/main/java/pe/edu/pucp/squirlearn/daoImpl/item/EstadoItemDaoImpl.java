package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.EstadoItemDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;

public class EstadoItemDaoImpl extends DAOImplBase implements EstadoItemDao{

    private EstadoItemDto estadoItem;

    public EstadoItemDaoImpl() {
        super("estado_items");
        this.estadoItem = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADO_ITEM_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.estadoItem.getNombre());
        this.statement.setDate(2, (Date) this.estadoItem.getFechaCreacion());
        this.statement.setInt(3, this.estadoItem.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoItem.getFechaModificacion());
        this.statement.setInt(5, this.estadoItem.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.estadoItem.getNombre());
        this.statement.setDate(2, (Date) this.estadoItem.getFechaCreacion());
        this.statement.setInt(3, this.estadoItem.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoItem.getFechaModificacion());
        this.statement.setInt(5, this.estadoItem.getUsuarioModificacion());
        this.statement.setInt(6, this.estadoItem.getEstadoItemId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoItem.getEstadoItemId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoItem.getEstadoItemId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoItem = new EstadoItemDto();
        this.estadoItem.setEstadoItemId(this.resultSet.getInt("ESTADO_ITEM_ID"));
        this.estadoItem.setNombre(this.resultSet.getString("NOMBRE"));
        this.estadoItem.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.estadoItem.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.estadoItem.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.estadoItem.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoItem = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoItem);
    }
    
    @Override
    public Integer insertar(EstadoItemDto estadoItem) {
        this.estadoItem = estadoItem;
        return super.insertar();
    }
    @Override
    public EstadoItemDto obtenerPorId(Integer id) {
        this.estadoItem = new EstadoItemDto();
        this.estadoItem.setEstadoItemId(id);
        super.obtenerPorId();
        return this.estadoItem;
    }

    @Override
    public ArrayList<EstadoItemDto> listarTodos() {
        return (ArrayList<EstadoItemDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoItemDto estadoItem) {
        this.estadoItem = estadoItem;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoItemDto estadoItem) {
        this.estadoItem = estadoItem;
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
