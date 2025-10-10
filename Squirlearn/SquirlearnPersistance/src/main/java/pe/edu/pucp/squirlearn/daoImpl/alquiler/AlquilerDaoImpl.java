package pe.edu.pucp.squirlearn.daoImpl.alquiler;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.alquiler.AlquilerDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;

public class AlquilerDaoImpl extends DAOImplBase implements AlquilerDao{

    private AlquilerDto alquiler;

    public AlquilerDaoImpl() {
        super("alquilers");
        this.alquiler = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ALQUILER_ID", true, true));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("ITEM", false, false));
        this.listaColumnas.add(new Columna("FECHA_INICIO", false, false));
        this.listaColumnas.add(new Columna("FECHA_FIN", false, false));
        this.listaColumnas.add(new Columna("DEVUELTO", false, false));
        this.listaColumnas.add(new Columna("MONTO", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.alquiler.getPersona().getPersonaId());
        this.statement.setInt(2, this.alquiler.getItem().getItemId());
        this.statement.setDate(3, (Date) this.alquiler.getFechaInicio());
        this.statement.setDate(4, (Date) this.alquiler.getFechaFin());
        this.statement.setInt(5, (this.alquiler.getDevuelto()!=null && this.alquiler.getDevuelto())?1:0);
        this.statement.setDouble(6, this.alquiler.getMonto());
        this.statement.setDate(7, (Date) this.alquiler.getFechaCreacion());
        this.statement.setInt(8, this.alquiler.getUsuarioCreacion());
        this.statement.setDate(9, (Date) this.alquiler.getFechaModificacion());
        this.statement.setInt(10, this.alquiler.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.alquiler.getPersona().getPersonaId());
        this.statement.setInt(2, this.alquiler.getItem().getItemId());
        this.statement.setDate(3, (Date) this.alquiler.getFechaInicio());
        this.statement.setDate(4, (Date) this.alquiler.getFechaFin());
        this.statement.setInt(5, (this.alquiler.getDevuelto()!=null && this.alquiler.getDevuelto())?1:0);
        this.statement.setDouble(6, this.alquiler.getMonto());
        this.statement.setDate(7, (Date) this.alquiler.getFechaCreacion());
        this.statement.setInt(8, this.alquiler.getUsuarioCreacion());
        this.statement.setDate(9, (Date) this.alquiler.getFechaModificacion());
        this.statement.setInt(10, this.alquiler.getUsuarioModificacion());
        this.statement.setInt(11, this.alquiler.getAlquilerId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.alquiler.getAlquilerId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.alquiler.getAlquilerId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.alquiler = new AlquilerDto();
        this.alquiler.setAlquilerId(this.resultSet.getInt("ALQUILER_ID"));
        this.alquiler.setFechaInicio(this.resultSet.getDate("FECHA_INICIO"));
        this.alquiler.setFechaFin(this.resultSet.getDate("FECHA_FIN"));
        this.alquiler.setDevuelto(this.resultSet.getInt("DEVUELTO") == 1);
        this.alquiler.setMonto(this.resultSet.getDouble("MONTO"));
        this.alquiler.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.alquiler.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.alquiler.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.alquiler.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.alquiler = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.alquiler);
    }
    
    @Override
    public Integer insertar(AlquilerDto alquiler) {
        this.alquiler = alquiler;
        return super.insertar();
    }
    @Override
    public AlquilerDto obtenerPorId(Integer id) {
        this.alquiler = new AlquilerDto();
        this.alquiler.setAlquilerId(id);
        super.obtenerPorId();
        return this.alquiler;
    }

    @Override
    public ArrayList<AlquilerDto> listarTodos() {
        return (ArrayList<AlquilerDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(AlquilerDto alquiler) {
        this.alquiler = alquiler;
        return super.modificar();
    }

    @Override
    public Integer eliminar(AlquilerDto alquiler) {
        this.alquiler = alquiler;
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
