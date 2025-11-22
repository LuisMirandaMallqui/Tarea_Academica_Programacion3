package pe.edu.pucp.squirlearn.daoImpl.persona;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.dao.persona.PersonaDao;
import pe.edu.pucp.squirlearn.dao.persona.RolPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
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
        this.listaColumnas.add(new Columna("ESTADO_PERSONA_ID_ESTADOPERSONA", false, false));
        this.listaColumnas.add(new Columna("NOMBRES", false, false));
        this.listaColumnas.add(new Columna("PRIMER_APELLIDO", false, false));
        this.listaColumnas.add(new Columna("SEGUNDO_APELLIDO", false, false));
        this.listaColumnas.add(new Columna("CODIGO", false, false));
        this.listaColumnas.add(new Columna("CORREO", false, false));
        this.listaColumnas.add(new Columna("CONTRASENA", false, false));
        this.listaColumnas.add(new Columna("ULTIMA_ACTIVIDAD", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
       
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        
        int i = 1;

        this.statement.setInt(i++, this.persona.getEstadoPersona().getEstadoPersonaId());
        this.statement.setString(i++, this.persona.getNombres());
        this.statement.setString(i++, this.persona.getPrimerApellido());
        this.statement.setString(i++, this.persona.getSegundoApellido());
        this.statement.setString(i++, this.persona.getCodigo());
        this.statement.setString(i++, this.persona.getCorreo());
        this.statement.setString(i++, this.persona.getContrasena());
        this.statement.setString(i++, this.persona.getUltimaActividad());
        this.statement.setString(i++, this.persona.getusuarioCreacion());
        this.statement.setString(i++, this.persona.getusuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        
        int i = 1;
        this.statement.setInt(i++, this.persona.getEstadoPersona().getEstadoPersonaId());
        this.statement.setString(i++, this.persona.getNombres());
        this.statement.setString(i++, this.persona.getPrimerApellido());
        this.statement.setString(i++, this.persona.getSegundoApellido());
        this.statement.setString(i++, this.persona.getCodigo());
        this.statement.setString(i++, this.persona.getCorreo());
        this.statement.setString(i++, this.persona.getContrasena());
        this.statement.setString(i++, this.persona.getUltimaActividad());
        this.statement.setString(i++, this.persona.getusuarioCreacion());
        this.statement.setString(i++, this.persona.getusuarioModificacion());
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
        
        EstadoPersonaDto ep = new EstadoPersonaDto();
        ep.setEstadoPersonaId(this.resultSet.getInt("ESTADO_PERSONA_ID_ESTADOPERSONA"));
        this.persona.setEstadoPersona(ep);

        this.persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.persona.setNombres(this.resultSet.getString("NOMBRES"));
        this.persona.setPrimerApellido(this.resultSet.getString("PRIMER_APELLIDO"));
        this.persona.setSegundoApellido(this.resultSet.getString("SEGUNDO_APELLIDO"));
        this.persona.setCodigo(this.resultSet.getString("CODIGO"));
        this.persona.setCorreo(this.resultSet.getString("CORREO"));
        this.persona.setContrasena(this.resultSet.getString("CONTRASENA"));
        this.persona.setUltimaActividad(this.resultSet.getString("ULTIMA_ACTIVIDAD"));
        this.persona.setusuarioCreacion(this.resultSet.getString("USUARIO_CREACION"));
        this.persona.setusuarioModificacion(this.resultSet.getString("USUARIO_MODIFICACION"));
        
        
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
    protected void agregarObjetoALaLista(List lista) throws SQLException {
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
                this.statement.setString(1, codigo);
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
                this.statement.setString(1, correo);
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
    
    @Override
    public Boolean existeUsuarioEnBD(PersonaDto per){
        String sql = this.generarSQLParaListarTodos() + " WHERE CODIGO=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try {
                this.statement.setString(1, per.getCodigo());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        ArrayList lista = (ArrayList) this.listarTodos(sql, incluir, null);
        return (lista != null && !lista.isEmpty());
    }
}
