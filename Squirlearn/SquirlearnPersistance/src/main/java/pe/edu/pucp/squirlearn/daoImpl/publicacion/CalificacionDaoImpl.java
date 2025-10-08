package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.publicacion.CalificacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.publicacion.CalificacionDto;

public class CalificacionDaoImpl extends DAOImplBase implements CalificacionDao{

    private CalificacionDto calificacion;

    public CalificacionDaoImpl() {
        super("calificacions");
        this.calificacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CALIFICACION_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.calificacion.getNombre());
        this.statement.setDate(2, (Date) this.calificacion.getFechaCreacion());
        this.statement.setInt(3, this.calificacion.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.calificacion.getFechaModificacion());
        this.statement.setInt(5, this.calificacion.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.calificacion.getNombre());
        this.statement.setDate(2, (Date) this.calificacion.getFechaCreacion());
        this.statement.setInt(3, this.calificacion.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.calificacion.getFechaModificacion());
        this.statement.setInt(5, this.calificacion.getUsuarioModificacion());
        this.statement.setInt(6, this.calificacion.getCalificacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.calificacion.getCalificacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.calificacion.getCalificacionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.calificacion = new CalificacionDto();
        this.calificacion.setCalificacionId(this.resultSet.getInt("CALIFICACION_ID"));
        this.calificacion.setNombre(this.resultSet.getString("NOMBRE"));
        this.calificacion.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.calificacion.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.calificacion.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.calificacion.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.calificacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.calificacion);
    }
    
    @Override
    public Integer insertar(CalificacionDto calificacion) {
        this.calificacion = calificacion;
        return super.insertar();
    }
    @Override
    public CalificacionDto obtenerPorId(Integer id) {
        this.calificacion = new CalificacionDto();
        this.calificacion.setCalificacionId(id);
        super.obtenerPorId();
        return this.calificacion;
    }

    @Override
    public ArrayList<CalificacionDto> listarTodos() {
        return (ArrayList<CalificacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(CalificacionDto calificacion) {
        this.calificacion = calificacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(CalificacionDto calificacion) {
        this.calificacion = calificacion;
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
