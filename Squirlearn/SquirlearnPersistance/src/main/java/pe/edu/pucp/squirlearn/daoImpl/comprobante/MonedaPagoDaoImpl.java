package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.comprobante.MonedaPagoDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;

public class MonedaPagoDaoImpl extends DAOImplBase implements MonedaPagoDao{

    private MonedaPagoDto monedaPago;

    public MonedaPagoDaoImpl() {
        super("monedas");
        this.monedaPago = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("MONEDA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.monedaPago.getNombre());
        this.statement.setDate(i++, this.monedaPago.getFechaCreacion());
        this.statement.setInt(i++, this.monedaPago.getUsuarioCreacion());
        this.statement.setDate(i++, this.monedaPago.getFechaModificacion());
        this.statement.setInt(i++, this.monedaPago.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.monedaPago.getNombre());
        this.statement.setDate(i++, this.monedaPago.getFechaCreacion());
        this.statement.setInt(i++, this.monedaPago.getUsuarioCreacion());
        this.statement.setDate(i++, this.monedaPago.getFechaModificacion());
        this.statement.setInt(i++, this.monedaPago.getUsuarioModificacion());
        this.statement.setInt(i++, this.monedaPago.getMonedaId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.monedaPago = new MonedaPagoDto();
        this.monedaPago.setMonedaId(this.resultSet.getInt("MONEDA_ID"));
        this.monedaPago.setNombre(this.resultSet.getString("NOMBRE"));
        this.monedaPago.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.monedaPago.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.monedaPago.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.monedaPago.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.monedaPago.getMonedaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.monedaPago.getMonedaId());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.monedaPago = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.monedaPago);
    }
    
    @Override
    public Integer insertar(MonedaPagoDto monedaPago) {
        this.monedaPago = monedaPago;
        return super.insertar();
    }
    @Override
    public MonedaPagoDto obtenerPorId(Integer id) {
        this.monedaPago = new MonedaPagoDto();
        this.monedaPago.setMonedaId(id);
        super.obtenerPorId();
        return this.monedaPago;
    }

    @Override
    public ArrayList<MonedaPagoDto> listarTodos() {
        return (ArrayList<MonedaPagoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(MonedaPagoDto monedaPago) {
        this.monedaPago = monedaPago;
        return super.modificar();
    }

    @Override
    public Integer eliminar(MonedaPagoDto monedaPago) {
        this.monedaPago = monedaPago;
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
