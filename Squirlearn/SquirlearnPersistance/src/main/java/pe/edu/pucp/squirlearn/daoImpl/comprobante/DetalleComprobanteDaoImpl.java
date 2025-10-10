package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.comprobante.DetalleComprobanteDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;

public class DetalleComprobanteDaoImpl extends DAOImplBase implements DetalleComprobanteDao{

    private DetalleComprobanteDto detalleComprobante;

    public DetalleComprobanteDaoImpl() {
        super("detalle_comprobantes");
        this.detalleComprobante = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("DETALLE_COM_ID", true, true));
        this.listaColumnas.add(new Columna("DESCRIPCION", false, false));
        this.listaColumnas.add(new Columna("PRECIO", false, false));
        this.listaColumnas.add(new Columna("ITEM", false, false));
        this.listaColumnas.add(new Columna("ALQUILER", false, false));
        this.listaColumnas.add(new Columna("COMPROBANTE", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.detalleComprobante.getDescripcion());
        this.statement.setDouble(2, this.detalleComprobante.getPrecio());
        this.statement.setInt(3, this.detalleComprobante.getItem().getItemId());
        this.statement.setInt(4, this.detalleComprobante.getAlquiler().getAlquilerId());
        this.statement.setInt(5, this.detalleComprobante.getComprobante().getComprobanteId());
        this.statement.setDate(6, (Date) this.detalleComprobante.getFechaModificacion());
        this.statement.setInt(7, this.detalleComprobante.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.detalleComprobante.getDescripcion());
        this.statement.setDouble(2, this.detalleComprobante.getPrecio());
        this.statement.setInt(3, this.detalleComprobante.getItem().getItemId());
        this.statement.setInt(4, this.detalleComprobante.getAlquiler().getAlquilerId());
        this.statement.setInt(5, this.detalleComprobante.getComprobante().getComprobanteId());
        this.statement.setDate(6, (Date) this.detalleComprobante.getFechaModificacion());
        this.statement.setInt(7, this.detalleComprobante.getUsuarioModificacion());
        this.statement.setInt(8, this.detalleComprobante.getDetalleComId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.detalleComprobante.getDetalleComId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.detalleComprobante.getDetalleComId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.detalleComprobante = new DetalleComprobanteDto();
        this.detalleComprobante.setDetalleComId(this.resultSet.getInt("DETALLE_COM_ID"));
        this.detalleComprobante.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.detalleComprobante.setPrecio(this.resultSet.getDouble("PRECIO"));
        this.detalleComprobante.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.detalleComprobante.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.detalleComprobante = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.detalleComprobante);
    }
    
    @Override
    public Integer insertar(DetalleComprobanteDto detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
        return super.insertar();
    }
    @Override
    public DetalleComprobanteDto obtenerPorId(Integer id) {
        this.detalleComprobante = new DetalleComprobanteDto();
        this.detalleComprobante.setDetalleComId(id);
        super.obtenerPorId();
        return this.detalleComprobante;
    }

    @Override
    public ArrayList<DetalleComprobanteDto> listarTodos() {
        return (ArrayList<DetalleComprobanteDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(DetalleComprobanteDto detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
        return super.modificar();
    }

    @Override
    public Integer eliminar(DetalleComprobanteDto detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
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
