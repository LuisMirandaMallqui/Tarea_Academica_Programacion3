package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;

public class PublicacionDaoImpl extends DAOImplBase implements PublicacionDao{

    private PublicacionDto publicacion;

    public PublicacionDaoImpl() {
        super("publicacions");
        this.publicacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PUBLICACION_ID", true, true));
        this.listaColumnas.add(new Columna("FECHA_ALTA", false, false));
        this.listaColumnas.add(new Columna("FECHA_BAJA", false, false));
        this.listaColumnas.add(new Columna("ESTADO_PUBLICACION", false, false));
        this.listaColumnas.add(new Columna("ITEM", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("CALIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setDate(1, (Date) this.publicacion.getFechaAlta());
        this.statement.setDate(2, (Date) this.publicacion.getFechaBaja());
        this.statement.setInt(3, this.publicacion.getEstadoPublicacion().getEstadoPublicacionId());
        this.statement.setInt(4, this.publicacion.getItem().getItemId());
        this.statement.setInt(5, this.publicacion.getPersona().getPersonaId());
        this.statement.setInt(6, this.publicacion.getCalificacion().getCalificacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setDate(1, (Date) this.publicacion.getFechaAlta());
        this.statement.setDate(2, (Date) this.publicacion.getFechaBaja());
        this.statement.setInt(3, this.publicacion.getEstadoPublicacion().getEstadoPublicacionId());
        this.statement.setInt(4, this.publicacion.getItem().getItemId());
        this.statement.setInt(5, this.publicacion.getPersona().getPersonaId());
        this.statement.setInt(6, this.publicacion.getCalificacion().getCalificacionId());
        this.statement.setInt(7, this.publicacion.getPublicacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.publicacion.getPublicacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.publicacion.getPublicacionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.publicacion = new PublicacionDto();
        this.publicacion.setPublicacionId(this.resultSet.getInt("PUBLICACION_ID"));
        this.publicacion.setFechaAlta(this.resultSet.getDate("FECHA_ALTA"));
        this.publicacion.setFechaBaja(this.resultSet.getDate("FECHA_BAJA"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.publicacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.publicacion);
    }
    
    @Override
    public Integer insertar(PublicacionDto publicacion) {
        this.publicacion = publicacion;
        return super.insertar();
    }
    @Override
    public PublicacionDto obtenerPorId(Integer id) {
        this.publicacion = new PublicacionDto();
        this.publicacion.setPublicacionId(id);
        super.obtenerPorId();
        return this.publicacion;
    }

    @Override
    public ArrayList<PublicacionDto> listarTodos() {
        return (ArrayList<PublicacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(PublicacionDto publicacion) {
        this.publicacion = publicacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(PublicacionDto publicacion) {
        this.publicacion = publicacion;
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
