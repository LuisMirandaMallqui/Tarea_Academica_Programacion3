package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.comprobante.ComprobanteDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;

public class ComprobanteDaoImpl extends DAOImplBase implements ComprobanteDao{

    private ComprobanteDto comprobante;

    public ComprobanteDaoImpl() {
        super("comprobantes");
        this.comprobante = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("COMPROBANTE_ID", true, true));
        this.listaColumnas.add(new Columna("MONTO", false, false));
        this.listaColumnas.add(new Columna("TRANSACCION", false, false));
        this.listaColumnas.add(new Columna("FECHA_EMISION", false, false));
        this.listaColumnas.add(new Columna("IMPUESTO", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("FORMA_PAGO", false, false));
        this.listaColumnas.add(new Columna("MONEDA", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setDouble(1, this.comprobante.getMonto());
        this.statement.setString(2, this.comprobante.getTransaccion());
        this.statement.setDate(3, (Date) this.comprobante.getFechaEmision());
        this.statement.setDouble(4, this.comprobante.getImpuesto());
        this.statement.setInt(5, this.comprobante.getPersona().getPersonaId());
        this.statement.setInt(6, this.comprobante.getFormaPago().getFormaPagoId());
        this.statement.setInt(7, this.comprobante.getMoneda().getMonedaId());
        this.statement.setDate(8, (Date) this.comprobante.getFechaModificacion());
        this.statement.setInt(9, this.comprobante.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setDouble(1, this.comprobante.getMonto());
        this.statement.setString(2, this.comprobante.getTransaccion());
        this.statement.setDate(3, (Date) this.comprobante.getFechaEmision());
        this.statement.setDouble(4, this.comprobante.getImpuesto());
        this.statement.setInt(5, this.comprobante.getPersona().getPersonaId());
        this.statement.setInt(6, this.comprobante.getFormaPago().getFormaPagoId());
        this.statement.setInt(7, this.comprobante.getMoneda().getMonedaId());
        this.statement.setDate(8, (Date) this.comprobante.getFechaModificacion());
        this.statement.setInt(9, this.comprobante.getUsuarioModificacion());
        this.statement.setInt(10, this.comprobante.getComprobanteId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.comprobante.getComprobanteId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.comprobante.getComprobanteId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.comprobante = new ComprobanteDto();
        this.comprobante.setComprobanteId(this.resultSet.getInt("COMPROBANTE_ID"));
        this.comprobante.setMonto(this.resultSet.getDouble("MONTO"));
        this.comprobante.setTransaccion(this.resultSet.getString("TRANSACCION"));
        this.comprobante.setFechaEmision(this.resultSet.getDate("FECHA_EMISION"));
        this.comprobante.setImpuesto(this.resultSet.getDouble("IMPUESTO"));
        this.comprobante.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.comprobante.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.comprobante = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.comprobante);
    }
    
    @Override
    public Integer insertar(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
        return super.insertar();
    }
    @Override
    public ComprobanteDto obtenerPorId(Integer id) {
        this.comprobante = new ComprobanteDto();
        this.comprobante.setComprobanteId(id);
        super.obtenerPorId();
        return this.comprobante;
    }

    @Override
    public ArrayList<ComprobanteDto> listarTodos() {
        return (ArrayList<ComprobanteDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
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
