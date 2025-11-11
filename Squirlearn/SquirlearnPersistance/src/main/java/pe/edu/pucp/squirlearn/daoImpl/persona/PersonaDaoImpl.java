package pe.edu.pucp.squirlearn.daoImpl.persona;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;

import pe.edu.pucp.squirlearn.dao.persona.PersonaDao;
import pe.edu.pucp.squirlearn.dao.persona.RolPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.daoImpl.persona.RolPersonaDaoImpl;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaDaoImpl extends DAOImplBase implements PersonaDao {

    private PersonaDto persona;

    public PersonaDaoImpl() {
        super("personas");
        this.persona = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        // PK
        this.listaColumnas.add(new Columna("PERSONA_ID", true, true));
        // Atributos base del nuevo DTO
        this.listaColumnas.add(new Columna("NOMBRES", false, false));
        this.listaColumnas.add(new Columna("PRIMER_APELLIDO", false, false));
        this.listaColumnas.add(new Columna("SEGUNDO_APELLIDO", false, false));
        this.listaColumnas.add(new Columna("CODIGO", false, false));
        this.listaColumnas.add(new Columna("CORREO", false, false));
        this.listaColumnas.add(new Columna("CONTRASENA", false, false));
        this.listaColumnas.add(new Columna("USUARIO", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        // FK a estado_persona
        this.listaColumnas.add(new Columna("ESTADO_PERSONA", false, false));
        // Fecha actividad
        this.listaColumnas.add(new Columna("ULTIMA_ACTIVIDAD", false, false));

        // NOTA: se eliminaron columnas antiguas de auditoría que ya no existen en el DTO:
        // FECHA_CREACION, FECHA_MODIFICACION, USUARIO_MODIFICACION
        // También se quitó ROL_PERSONA (ya no es un único rol, sino una lista en tabla puente).
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.persona.getNombres());
        this.statement.setString(i++, this.persona.getPrimerApellido());
        this.statement.setString(i++, this.persona.getSegundoApellido());
        this.statement.setString(i++, this.persona.getCodigo());
        this.statement.setString(i++, this.persona.getCorreo());
        this.statement.setString(i++, this.persona.getContrasena());
        this.statement.setString(i++, this.persona.getUsuario());
        this.statement.setString(i++, this.persona.getUsuarioCreacion());

        // ESTADO_PERSONA (FK) — si viene null, usa 1 como fallback mínimo
        Integer estadoId = (this.persona.getEstadoPersona() == null
                ? null
                : this.persona.getEstadoPersona().getEstadoPersonaId());
        this.statement.setInt(i++, (estadoId == null || estadoId <= 0) ? 1 : estadoId);

        // ULTIMA_ACTIVIDAD
        this.statement.setDate(i++, (Date) this.persona.getUltimaActividad());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.persona.getNombres());
        this.statement.setString(i++, this.persona.getPrimerApellido());
        this.statement.setString(i++, this.persona.getSegundoApellido());
        this.statement.setString(i++, this.persona.getCodigo());
        this.statement.setString(i++, this.persona.getCorreo());
        this.statement.setString(i++, this.persona.getContrasena());
        this.statement.setString(i++, this.persona.getUsuario());
        this.statement.setString(i++, this.persona.getUsuarioCreacion());

        Integer estadoId = (this.persona.getEstadoPersona() == null
                ? null
                : this.persona.getEstadoPersona().getEstadoPersonaId());
        this.statement.setInt(i++, (estadoId == null || estadoId <= 0) ? 1 : estadoId);

        this.statement.setDate(i++, (Date) this.persona.getUltimaActividad());
        // WHERE PERSONA_ID=?
        this.statement.setInt(i++, this.persona.getPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.persona.getPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.persona.getPersonaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.persona = new PersonaDto();

        this.persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.persona.setNombres(this.resultSet.getString("NOMBRES"));
        this.persona.setPrimerApellido(this.resultSet.getString("PRIMER_APELLIDO"));
        this.persona.setSegundoApellido(this.resultSet.getString("SEGUNDO_APELLIDO"));
        this.persona.setCodigo(this.resultSet.getString("CODIGO"));
        this.persona.setCorreo(this.resultSet.getString("CORREO"));
        this.persona.setContrasena(this.resultSet.getString("CONTRASENA"));
        this.persona.setUsuario(this.resultSet.getString("USUARIO"));
        this.persona.setUsuarioCreacion(this.resultSet.getString("USUARIO_CREACION"));

        // EstadoPersona FK (setear sólo el ID para evitar llamada adicional)
        int estadoId = this.resultSet.getInt("ESTADO_PERSONA");
        if (!this.resultSet.wasNull()) {
            EstadoPersonaDto ep = new EstadoPersonaDto();
            ep.setEstadoPersonaId(estadoId);
            this.persona.setEstadoPersona(ep);
        }

        // Ultima actividad
        this.persona.setUltimaActividad(this.resultSet.getDate("ULTIMA_ACTIVIDAD"));

        // >>> IMPORTANTE: Poblar roles usando el método creado (tabla puente)
        RolPersonaDao rolDao = new RolPersonaDaoImpl();
        ArrayList<RolPersonaDto> roles = rolDao.listarPorPersona(this.persona.getPersonaId());
        this.persona.setRolPersona(roles);
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.persona = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.persona);
    }

    @Override
    public Integer insertar(PersonaDto persona) {
        this.persona = persona;
        return super.insertar();
    }

    @Override
    public PersonaDto obtenerPorId(Integer id) {
        this.persona = new PersonaDto();
        this.persona.setPersonaId(id);
        super.obtenerPorId();
        return this.persona;
    }

    @Override
    public ArrayList<PersonaDto> listarTodos() {
        return (ArrayList<PersonaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(PersonaDto persona) {
        this.persona = persona;
        return super.modificar();
    }

    @Override
    public Integer eliminar(PersonaDto persona) {
        this.persona = persona;
        return super.eliminar();
    }

    @Override
    public PersonaDto obtenerPorCodigo(String codigo) {
        String sql = this.generarSQLParaListarTodos() + " WHERE CODIGO=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try {
                ps.setString(1, codigo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        ArrayList lista = (ArrayList) this.listarTodos(sql, incluir, null);
        return (lista == null || lista.isEmpty()) ? null : (PersonaDto) lista.get(0);
    }

    @Override
    public PersonaDto buscarPorCorreo(String correo) {
        String sql = this.generarSQLParaListarTodos() + " WHERE CORREO=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try {
                ps.setString(1, correo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        ArrayList lista = (ArrayList) this.listarTodos(sql, incluir, null);
        return (lista == null || lista.isEmpty()) ? null : (PersonaDto) lista.get(0);
    }

    public void ejecutarReporteCalificaciones(String nombreSP, boolean conTransaccion) {
        String sql = "{call REPORTE_CALIFICACIONES()}";
        this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
    }
}
