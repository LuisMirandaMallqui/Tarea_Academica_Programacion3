package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import pe.edu.pucp.squirlearn.daoImpl.util.ParamReporteAlquiler;
import java.sql.Date;
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
        this.listaColumnas.add(new Columna("FECHA_ALTA", false, false));
        this.listaColumnas.add(new Columna("FECHA_BAJA", false, false));
        this.listaColumnas.add(new Columna("ESTADO_PUBLICACION", false, false));
        this.listaColumnas.add(new Columna("ITEM", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("CALIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int estadoId = safeFkId(
                (this.publicacion.getEstadoPublicacion() == null ? null : this.publicacion.getEstadoPublicacion().getEstadoPublicacionId()),
                "estados_publicaciones", "ESTADOPUBLI_ID"
        );
        int itemId = safeFkId(
                (this.publicacion.getItem() == null ? null : this.publicacion.getItem().getItemId()),
                "items", "ITEM_ID"
        );
        int personaId = safeFkId(
                (this.publicacion.getPersona() == null ? null : this.publicacion.getPersona().getPersonaId()),
                "personas", "PERSONA_ID"
        );

        this.statement.setDate(1, (java.sql.Date) this.publicacion.getFechaAlta());
        this.statement.setDate(2, (java.sql.Date) this.publicacion.getFechaBaja());
        this.statement.setInt(3, estadoId);
        this.statement.setInt(4, itemId);
        this.statement.setInt(5, personaId);
        this.statement.setInt(6, this.publicacion.getCalificacion()); // es int, no DTO
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int estadoId = safeFkId(
                (this.publicacion.getEstadoPublicacion() == null ? null : this.publicacion.getEstadoPublicacion().getEstadoPublicacionId()),
                "estados_publicaciones", "ESTADOPUBLI_ID"
        );
        int itemId = safeFkId(
                (this.publicacion.getItem() == null ? null : this.publicacion.getItem().getItemId()),
                "items", "ITEM_ID"
        );
        int personaId = safeFkId(
                (this.publicacion.getPersona() == null ? null : this.publicacion.getPersona().getPersonaId()),
                "personas", "PERSONA_ID"
        );

        int i = 1;
        this.statement.setDate(i++, (java.sql.Date) this.publicacion.getFechaAlta());
        this.statement.setDate(i++, (java.sql.Date) this.publicacion.getFechaBaja());
        this.statement.setInt(i++, estadoId);
        this.statement.setInt(i++, itemId);
        this.statement.setInt(i++, personaId);
        this.statement.setInt(i++, this.publicacion.getCalificacion());
        this.statement.setInt(i++, this.publicacion.getPublicacionId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.publicacion = new pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto();

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
        this.publicacion.setFechaAlta(this.resultSet.getDate("FECHA_ALTA"));
        this.publicacion.setFechaBaja(this.resultSet.getDate("FECHA_BAJA"));
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
                ps.setInt(1, estadoId);
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
                /* _inicio */Date.valueOf("2025-01-01"),
                /* _fin    */ Date.valueOf("2025-12-31")
        );
        String sql = "{CALL REPORTE_TRANSACCCIONES_OFERTADOR(?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosReporteTransaccionesOfertador, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosReporteTransaccionesOfertador(Object objetoParametros) {
        ParamReporteTransaccionesOfertador p = (ParamReporteTransaccionesOfertador) objetoParametros;
        try {
            // 1) _inicio (DATE), 2) _fin (DATE)
            this.statement.setDate(1, p.getInicio());
            this.statement.setDate(2, p.getFin());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ejecutarReporteTransaccionesReceptor() {
        Object parametros = new ParamReporteTransaccionesReceptor(
                /* _inicio */Date.valueOf("2025-01-01"),
                /* _fin    */ Date.valueOf("2025-12-31")
        );
        String sql = "{CALL REPORTE_TRANSACCCIONES_RECEPTOR(?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosReporteTransaccionesReceptor, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosReporteTransaccionesReceptor(Object objetoParametros) {
        ParamReporteTransaccionesReceptor p = (ParamReporteTransaccionesReceptor) objetoParametros;
        try {
            // 1) _inicio (DATE), 2) _fin (DATE)
            this.statement.setDate(1, p.getInicio());
            this.statement.setDate(2, p.getFin());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<PublicacionDto> listarPorFiltrosPublicacion(
            String terminoBusqueda,
            Boolean esVenta,
            Integer idCategoria,
            Integer idSubcategoria,
            Integer idColores,
            Integer idTamanos,
            Integer idFormatos,
            Integer idCondicion,
            Integer idEstado
    ) {
        StringBuilder sql = new StringBuilder(
                "SELECT P.PUBLICACION_ID, P.FECHA_ALTA, P.FECHA_BAJA, P.CALIFICACION, "
                + "P.ESTADO_PUBLICACION_ID, P.PERSONA_ID, "
                + "I.ITEM_ID AS ITEM_ID_ITEM, I.NOMBRE, I.DESCRIPCION, I.PRECIO, I.ES_VENTA, "
                + "I.COLOR_ID, I.CONDICION_ID, I.TAMANO_ID, I.FORMATO_ID, "
                + "I.subcategoria_ID_SUBCATEGORIA, I.subcategoria_CATEGORIA_ID "
                + "FROM publicaciones P "
                + "JOIN items I ON P.ITEM_ID_ITEM = I.ITEM_ID "
                + "WHERE 1=1 "
        );

        ArrayList<Object> parametros = new ArrayList<>();

        if (terminoBusqueda != null && !terminoBusqueda.isBlank()) {
            sql.append(" AND I.NOMBRE LIKE ? ");
            parametros.add("%" + terminoBusqueda + "%");
        }

        if (esVenta != null) {
            sql.append(" AND I.ES_VENTA = ? ");
            parametros.add(esVenta ? 1 : 0);
        }

        if (idCategoria != null) {
            sql.append(" AND I.subcategoria_CATEGORIA_ID = ? ");
            parametros.add(idCategoria);
        }

        if (idSubcategoria != null) {
            sql.append(" AND I.subcategoria_ID_SUBCATEGORIA = ? ");
            parametros.add(idSubcategoria);
        }

        if (idColores != null) {
            sql.append(" AND I.COLOR_ID = ? ");
            parametros.add(idColores);
        }

        if (idTamanos != null) {
            sql.append(" AND I.TAMANO_ID = ? ");
            parametros.add(idTamanos);
        }

        if (idFormatos != null) {
            sql.append(" AND I.FORMATO_ID = ? ");
            parametros.add(idFormatos);
        }

        if (idCondicion != null) {
            sql.append(" AND I.CONDICION_ID = ? ");
            parametros.add(idCondicion);
        }

        if (idEstado != null) {
            sql.append(" AND P.ESTADO_PUBLICACION_ID = ? ");
            parametros.add(idEstado);
        }

        Consumer<PreparedStatement> incluirValores = p -> {
            try {
                int i = 1;
                for (Object param : parametros) {
                    this.statement.setObject(i++, param);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        return (ArrayList<PublicacionDto>) this.listarTodos(sql.toString(), incluirValores, null);
    }
}
