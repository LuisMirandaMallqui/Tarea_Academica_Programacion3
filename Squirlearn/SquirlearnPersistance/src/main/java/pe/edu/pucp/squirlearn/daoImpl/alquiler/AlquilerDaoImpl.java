package pe.edu.pucp.squirlearn.daoImpl.alquiler;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.alquiler.AlquilerDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.daoImpl.util.ParamReporteAlquiler;
import pe.edu.pucp.squirlearn.daoImpl.util.TraduccionesSQL;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class AlquilerDaoImpl extends DAOImplBase implements AlquilerDao {

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
        this.statement.setInt(idx++, this.alquiler.getPersona().getPersonaId());
        this.statement.setInt(idx++, this.alquiler.getItem().getItemId());
        this.statement.setString(idx++, this.alquiler.getFechaInicio());
        this.statement.setString(idx++, this.alquiler.getFechaFin());
        this.statement.setInt(idx++, this.alquiler.getDevuelto() ? 1 : 0);
        this.statement.setDouble(idx++, this.alquiler.getMonto());
        this.statement.setString(idx++, this.alquiler.getUsuarioCreacion());
        this.statement.setString(idx++, this.alquiler.getFechaCreacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;

        // Orden EXACTO del UPDATE impreso por el DAO
        this.statement.setInt(i++, this.alquiler.getPersona().getPersonaId());                                   // PERSONA_ID=?
        this.statement.setInt(i++, this.alquiler.getItem().getItemId());
        this.statement.setString(i++, this.alquiler.getFechaInicio());
        this.statement.setString(i++, this.alquiler.getFechaFin());   
        this.statement.setInt(i++, this.alquiler.getDevuelto() ? 1 : 0);         // DEVUELTO=?
        this.statement.setDouble(i++, this.alquiler.getMonto());                 // MONTO=?
        this.statement.setString(i++, this.alquiler.getUsuarioCreacion());
        this.statement.setString(i++, this.alquiler.getFechaCreacion());
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
        ItemDto item = new ItemDto();
        item.setItemId(this.resultSet.getInt("ITEM_ID"));
        
        this.alquiler.setAlquilerId(this.resultSet.getInt("ALQUILER_ID"));
        this.alquiler.setPersona(per);
        this.alquiler.setItem(item);
        this.alquiler.setFechaInicio(this.resultSet.getString("FECHA_INICIO"));
        this.alquiler.setFechaFin(this.resultSet.getString("FECHA_FIN"));
        this.alquiler.setDevuelto(this.resultSet.getInt("DEVUELTO") == 1);
        this.alquiler.setMonto(this.resultSet.getDouble("MONTO"));
        this.alquiler.setUsuarioCreacion(this.resultSet.getString("USUARIO_CREACION"));
        this.alquiler.setFechaCreacion(this.resultSet.getString("FECHA_CREACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.alquiler = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
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
                this.statement.setInt(1, personaId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        return (ArrayList<AlquilerDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }

    public void ejecutarReporteAlquiler() {
        Object parametros = new ParamReporteAlquiler(
                //                /* _persona */1,
                //                /* _inicio  */ Date.valueOf("2025-01-01"),
                //                /* _fin     */ Date.valueOf("2025-12-31")

                /* _persona */1,
                /* _inicio  */ ("2025-01-01"),
                /* _fin     */ ("2025-12-31")
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
            this.statement.setString(2, p.getInicio());
            this.statement.setString(3, p.getFin());
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
