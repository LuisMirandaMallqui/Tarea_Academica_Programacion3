package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.publicacion.HistoriaPublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.publicacion.HistoriaPublicacionDto;

public class HistoriaPublicacionDaoImpl extends DAOImplBase implements HistoriaPublicacionDao{

    private HistoriaPublicacionDto historiaPublicacion;

    public HistoriaPublicacionDaoImpl() {
        super("historia_publicacions");
        this.historiaPublicacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("HISTORIA_PUBLI_ID", true, true));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("PUBLICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setDate(1, (Date) this.historiaPublicacion.getFechaModificacion());
        this.statement.setInt(2, this.historiaPublicacion.getPublicacion().getPublicacionId());
        this.statement.setInt(3, this.historiaPublicacion.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setDate(1, (Date) this.historiaPublicacion.getFechaModificacion());
        this.statement.setInt(2, this.historiaPublicacion.getPublicacion().getPublicacionId());
        this.statement.setInt(3, this.historiaPublicacion.getUsuarioModificacion());
        this.statement.setInt(4, this.historiaPublicacion.getHistoriaPubliId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.historiaPublicacion.getHistoriaPubliId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.historiaPublicacion.getHistoriaPubliId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.historiaPublicacion = new HistoriaPublicacionDto();
        this.historiaPublicacion.setHistoriaPubliId(this.resultSet.getInt("HISTORIA_PUBLI_ID"));
        this.historiaPublicacion.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.historiaPublicacion.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.historiaPublicacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.historiaPublicacion);
    }
    
    @Override
    public Integer insertar(HistoriaPublicacionDto historiaPublicacion) {
        this.historiaPublicacion = historiaPublicacion;
        return super.insertar();
    }
    @Override
    public HistoriaPublicacionDto obtenerPorId(Integer id) {
        this.historiaPublicacion = new HistoriaPublicacionDto();
        this.historiaPublicacion.setHistoriaPubliId(id);
        super.obtenerPorId();
        return this.historiaPublicacion;
    }

    @Override
    public ArrayList<HistoriaPublicacionDto> listarTodos() {
        return (ArrayList<HistoriaPublicacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(HistoriaPublicacionDto historiaPublicacion) {
        this.historiaPublicacion = historiaPublicacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(HistoriaPublicacionDto historiaPublicacion) {
        this.historiaPublicacion = historiaPublicacion;
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
