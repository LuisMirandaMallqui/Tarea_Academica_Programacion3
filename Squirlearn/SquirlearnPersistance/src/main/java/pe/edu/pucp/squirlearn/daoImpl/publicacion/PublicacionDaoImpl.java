package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.daoImpl.util.ParamReporteTransaccionesOfertador;
import pe.edu.pucp.squirlearn.daoImpl.util.ParamReporteTransaccionesReceptor;
import pe.edu.pucp.squirlearn.daoImpl.util.ParamReporteVenta;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;

public class PublicacionDaoImpl extends DAOImplBase implements PublicacionDao {

    private PublicacionDto publicacion;

    public PublicacionDaoImpl() {
        super("publicaciones");
        this.publicacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PUBLICACION_ID", true, true));
        this.listaColumnas.add(new Columna("ESTADO_PUBLICACION_ID", false, false));
        this.listaColumnas.add(new Columna("ITEM_ID_ITEM", false, false));
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("FECHA_ALTA", false, false));
        this.listaColumnas.add(new Columna("FECHA_BAJA", false, false));
        this.listaColumnas.add(new Columna("CALIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.publicacion.getEstadoPublicacion().getEstadoPublicacionId());
        this.statement.setInt(i++, this.publicacion.getItem().getItemId());
        this.statement.setInt(i++, this.publicacion.getPersona().getPersonaId());
        this.statement.setString(i++, this.publicacion.getFechaAlta());
        this.statement.setString(i++, this.publicacion.getFechaBaja());
        if (this.publicacion.getCalificacion() == null) {
            this.statement.setNull(i++, 0);
        } else {
            this.statement.setInt(i++, publicacion.getCalificacion());
        }
        this.statement.setString(i++, this.publicacion.getusuarioCreacion());
        this.statement.setString(i++, this.publicacion.getusuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.publicacion.getEstadoPublicacion().getEstadoPublicacionId());
        this.statement.setInt(i++, this.publicacion.getItem().getItemId());
        this.statement.setInt(i++, this.publicacion.getPersona().getPersonaId());
        this.statement.setString(i++, this.publicacion.getFechaAlta());
        this.statement.setString(i++, this.publicacion.getFechaBaja());
        if (this.publicacion.getCalificacion() == null) {
            this.statement.setNull(i++, 0);
        } else {
            this.statement.setInt(i++, publicacion.getCalificacion());
        }
        this.statement.setString(i++, this.publicacion.getusuarioCreacion());
        this.statement.setString(i++, this.publicacion.getusuarioModificacion());
        this.statement.setInt(i++, this.publicacion.getPublicacionId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.publicacion = new PublicacionDto();

        // EstadoPublicacion
        EstadoPublicacionDto ep = new EstadoPublicacionDto();
        ep.setEstadoPublicacionId(this.resultSet.getInt("ESTADO_PUBLICACION_ID"));
        this.publicacion.setEstadoPublicacion(ep);

        // Item
        ItemDto item = new ItemDto();
        item.setItemId(this.resultSet.getInt("ITEM_ID_ITEM"));

        this.publicacion.setItem(item);

        // Persona
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.publicacion.setPersona(persona);

        // Escalares
        this.publicacion.setPublicacionId(this.resultSet.getInt("PUBLICACION_ID"));
        this.publicacion.setFechaAlta(this.resultSet.getString("FECHA_ALTA"));
        this.publicacion.setFechaBaja(this.resultSet.getString("FECHA_BAJA"));
        this.publicacion.setCalificacion(this.resultSet.getInt("CALIFICACION"));
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

    @Override
    public ArrayList<PublicacionDto> listarPorEstado(Integer estadoId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE ESTADO_PUBLICACION_ID=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try {
                this.statement.setInt(1, estadoId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        return (ArrayList<PublicacionDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }

    public void ejecutarReporteVenta() {
        Object parametros = new ParamReporteVenta(
                /* _persona */1
        );
        String sql = "{CALL REPORTE_VENTA(?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosReporteVenta, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosReporteVenta(Object objetoParametros) {
        ParamReporteVenta p = (ParamReporteVenta) objetoParametros;
        try {
            // 1) _persona (INT)
            this.statement.setInt(1, p.getPersonaId());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ejecutarReporteTransaccionesOfertador() {
        Object parametros = new ParamReporteTransaccionesOfertador(
                /* _inicio */("2025-01-01"),
                /* _fin    */ ("2025-12-31")
        );
        String sql = "{CALL REPORTE_TRANSACCCIONES_OFERTADOR(?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosReporteTransaccionesOfertador, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosReporteTransaccionesOfertador(Object objetoParametros) {
        ParamReporteTransaccionesOfertador p = (ParamReporteTransaccionesOfertador) objetoParametros;
        try {
            // 1) _inicio (DATE), 2) _fin (DATE)
            this.statement.setString(1, p.getInicio());
            this.statement.setString(2, p.getFin());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ejecutarReporteTransaccionesReceptor() {
        Object parametros = new ParamReporteTransaccionesReceptor(
                /* _inicio */("2025-01-01"),
                /* _fin    */ ("2025-12-31")
        );
        String sql = "{CALL REPORTE_TRANSACCCIONES_RECEPTOR(?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosReporteTransaccionesReceptor, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosReporteTransaccionesReceptor(Object objetoParametros) {
        ParamReporteTransaccionesReceptor p = (ParamReporteTransaccionesReceptor) objetoParametros;
        try {
            // 1) _inicio (DATE), 2) _fin (DATE)
            this.statement.setString(1, p.getInicio());
            this.statement.setString(2, p.getFin());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<PublicacionDto> listarPorDueno(Integer personaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE PERSONA_ID=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try {
                this.statement.setInt(1, personaId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        return (ArrayList<PublicacionDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }
}
