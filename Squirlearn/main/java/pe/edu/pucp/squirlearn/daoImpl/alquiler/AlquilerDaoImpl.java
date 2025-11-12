package pe.edu.pucp.squirlearn.daoImpl.alquiler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.alquiler.AlquilerDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.daoImpl.util.ParamReporteAlquiler;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class AlquilerDaoImpl extends DAOImplBase implements AlquilerDao{

    private AlquilerDto alquiler;

    public AlquilerDaoImpl() {
        super("alquileres");
        this.alquiler = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ALQUILER_ID", true, true));
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("ITEM_ID", false, false));
        this.listaColumnas.add(new Columna("FECHA_INICIO", false, false));
        this.listaColumnas.add(new Columna("FECHA_FIN", false, false));
        this.listaColumnas.add(new Columna("DEVUELTO", false, false));
        this.listaColumnas.add(new Columna("MONTO", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
    }

    @Override
protected void incluirValorDeParametrosParaInsercion() throws SQLException {
    int idx = 1;

    // Resolver IDs de claves foráneas de forma segura desde la BD (mínimo ID disponible)
    Integer _personaId = (this.alquiler.getPersona() == null) ? null : this.alquiler.getPersona().getPersonaId();
    Integer _itemId    = (this.alquiler.getItem() == null)    ? null : this.alquiler.getItem().getItemId();

    int personaId = safeFkId(_personaId, "personas", "PERSONA_ID");
    int itemId    = safeFkId(_itemId,    "items",    "ITEM_ID");

    this.statement.setInt(idx++, personaId);
    this.statement.setInt(idx++, itemId);
    this.statement.setDate(idx++, this.alquiler.getFechaInicio());
    this.statement.setDate(idx++, this.alquiler.getFechaFin());
    this.statement.setInt(idx++, this.alquiler.getDevuelto() ? 1 : 0);
    this.statement.setDouble(idx++, this.alquiler.getMonto());
    this.statement.setString(idx++, this.alquiler.getUsuarioCreacion());
    this.statement.setDate(idx++, this.alquiler.getFechaCreacion());
}

@Override
protected void incluirValorDeParametrosParaModificacion() throws SQLException {
    int i = 1;

    // Permitir que Persona/Item vengan nulos desde el test y ponerles un ID válido
    Integer providedPersonaId = (this.alquiler.getPersona() == null) ? null : this.alquiler.getPersona().getPersonaId();
    Integer providedItemId    = (this.alquiler.getItem()    == null) ? null : this.alquiler.getItem().getItemId();

    int personaId = safeFkId(providedPersonaId, "personas", "PERSONA_ID");
    int itemId    = safeFkId(providedItemId,    "items",    "ITEM_ID");

    // Orden EXACTO del UPDATE impreso por el DAO
    this.statement.setInt(i++, personaId);                                   // PERSONA_ID=?
    this.statement.setInt(i++, itemId);                                      // ITEM_ID=?
    this.statement.setDate(i++, this.alquiler.getFechaInicio());             // FECHA_INICIO=?
    this.statement.setDate(i++, this.alquiler.getFechaFin());                // FECHA_FIN=?
    this.statement.setInt(i++, this.alquiler.getDevuelto() ? 1 : 0);         // DEVUELTO=?
    this.statement.setDouble(i++, this.alquiler.getMonto());                 // MONTO=?
    this.statement.setString(i++, this.alquiler.getUsuarioCreacion());
    this.statement.setDate(i++, this.alquiler.getFechaCreacion());
    // WHERE ALQUILER_ID=?
    this.statement.setInt(i++, this.alquiler.getAlquilerId());
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
        PersonaDto per = new PersonaDto();
        per.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.alquiler.setPersona(per);
        ItemDto item = new ItemDto();
        item.setItemId(this.resultSet.getInt("ITEM_ID"));
        this.alquiler.setPersona(per);
        this.alquiler.setItem(item);
        this.alquiler.setAlquilerId(this.resultSet.getInt("ALQUILER_ID"));
        this.alquiler.setFechaInicio(this.resultSet.getDate("FECHA_INICIO"));
        this.alquiler.setFechaFin(this.resultSet.getDate("FECHA_FIN"));
        this.alquiler.setDevuelto(this.resultSet.getInt("DEVUELTO") == 1);
        this.alquiler.setMonto(this.resultSet.getDouble("MONTO"));
        this.alquiler.setUsuarioCreacion(this.resultSet.getString("USUARIO_CREACION"));
        this.alquiler.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
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

    @Override
    public ArrayList<AlquilerDto> listarPorDueno(Integer personaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE PERSONA_ID=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try { 
                ps.setInt(1, personaId); 
            } catch (SQLException e) { 
                throw new RuntimeException(e); 
            }
        };
        return (ArrayList<AlquilerDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }
    
    public void ejecutarReporteAlquiler() {
        Object parametros = new ParamReporteAlquiler(
            /* _persona */ 1,
            /* _inicio  */ Date.valueOf("2025-01-01"),
            /* _fin     */ Date.valueOf("2025-12-31")
        );
        String sql = "{CALL REPORTE_ALQUILER(?, ?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosReporteAlquiler, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosReporteAlquiler(Object objetoParametros) {
        ParamReporteAlquiler p = (ParamReporteAlquiler) objetoParametros;
        try {
            // 1) _persona (INT), 2) _inicio (DATE), 3) _fin (DATE)
            this.statement.setInt(1, p.getPersonaId());
            this.statement.setDate(2, p.getInicio());
            this.statement.setDate(3, p.getFin());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
