package pe.edu.pucp.squirlearn.daoImpl.persona;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.persona.RolPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;

public class RolPersonaDaoImpl extends DAOImplBase implements RolPersonaDao{

    private RolPersonaDto rolPersona;

    public RolPersonaDaoImpl() {
        super("roles_personas");
        this.rolPersona = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ROL_PERSONA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.rolPersona.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.rolPersona.getNombre());
this.statement.setInt(i++, this.rolPersona.getRolPersonaId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.rolPersona = new RolPersonaDto();
        this.rolPersona.setRolPersonaId(this.resultSet.getInt("ROLPERSONA_ID"));
        this.rolPersona.setNombre(this.resultSet.getString("NOMBRE"));
}

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.rolPersona.getRolPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.rolPersona.getRolPersonaId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.rolPersona = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.rolPersona);
    }
    
    @Override
    public Integer insertar(RolPersonaDto rolPersona) {
        this.rolPersona = rolPersona;
        return super.insertar();
    }
    @Override
    public RolPersonaDto obtenerPorId(Integer id) {
        this.rolPersona = new RolPersonaDto();
        this.rolPersona.setRolPersonaId(id);
        super.obtenerPorId();
        return this.rolPersona;
    }

    @Override
    public ArrayList<RolPersonaDto> listarTodos() {
        return (ArrayList<RolPersonaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(RolPersonaDto rolPersona) {
        this.rolPersona = rolPersona;
        return super.modificar();
    }

    @Override
    public Integer eliminar(RolPersonaDto rolPersona) {
        this.rolPersona = rolPersona;
        return super.eliminar();
    }
    @Override
    public ArrayList<RolPersonaDto> listarPorPersona(Integer personaId) {
        // Ajusta el nombre de la tabla puente si fuese distinto en tu BD.
        // Supuesto común: 'personas_roles(PERSONA_ID, ROL_PERSONA_ID)'
        final String sql =
            "SELECT rp.ROL_PERSONA_ID, rp.NOMBRE " +
            "FROM roles_personas rp " +
            "JOIN personas_roles pr ON pr.ROL_PERSONA_ID = rp.ROL_PERSONA_ID " +
            "WHERE pr.PERSONA_ID = ?";

        Consumer<PreparedStatement> incluir = ps -> {
            try {
                ps.setInt(1, personaId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        // Reutiliza el mapeo estándar de esta clase (instanciarObjetoDelResultSet)
        return (ArrayList<RolPersonaDto>)(ArrayList) this.listarTodos(sql, incluir, null);
    }
}
