package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.publicacion.EstadoPublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;

public class EstadoPublicacionDaoImpl extends DAOImplBase implements EstadoPublicacionDao{

    private EstadoPublicacionDto estadoPublicacion;

    public EstadoPublicacionDaoImpl() {
        super("estado_publicacions");
        this.estadoPublicacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADO_PUBLICACION_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.estadoPublicacion.getNombre());
        this.statement.setDate(2, (Date) this.estadoPublicacion.getFechaCreacion());
        this.statement.setInt(3, this.estadoPublicacion.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoPublicacion.getFechaModificacion());
        this.statement.setInt(5, this.estadoPublicacion.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.estadoPublicacion.getNombre());
        this.statement.setDate(2, (Date) this.estadoPublicacion.getFechaCreacion());
        this.statement.setInt(3, this.estadoPublicacion.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoPublicacion.getFechaModificacion());
        this.statement.setInt(5, this.estadoPublicacion.getUsuarioModificacion());
        this.statement.setInt(6, this.estadoPublicacion.getEstadoPublicacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoPublicacion.getEstadoPublicacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoPublicacion.getEstadoPublicacionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoPublicacion = new EstadoPublicacionDto();
        this.estadoPublicacion.setEstadoPublicacionId(this.resultSet.getInt("ESTADO_PUBLICACION_ID"));
        this.estadoPublicacion.setNombre(this.resultSet.getString("NOMBRE"));
        this.estadoPublicacion.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.estadoPublicacion.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.estadoPublicacion.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.estadoPublicacion.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoPublicacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoPublicacion);
    }
    
    @Override
    public Integer insertar(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
        return super.insertar();
    }
    @Override
    public EstadoPublicacionDto obtenerPorId(Integer id) {
        this.estadoPublicacion = new EstadoPublicacionDto();
        this.estadoPublicacion.setEstadoPublicacionId(id);
        super.obtenerPorId();
        return this.estadoPublicacion;
    }

    @Override
    public ArrayList<EstadoPublicacionDto> listarTodos() {
        return (ArrayList<EstadoPublicacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
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
