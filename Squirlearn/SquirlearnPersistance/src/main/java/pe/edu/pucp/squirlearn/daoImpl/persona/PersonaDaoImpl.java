package pe.edu.pucp.squirlearn.daoImpl.persona;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.persona.PersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaDaoImpl extends DAOImplBase implements PersonaDao{

    private PersonaDto persona;

    public PersonaDaoImpl() {
        super("personas");
        this.persona = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PERSONA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRES", false, false));
        this.listaColumnas.add(new Columna("PRIMER_APELLIDO", false, false));
        this.listaColumnas.add(new Columna("SEGUNDO_APELLIDO", false, false));
        this.listaColumnas.add(new Columna("CODIGO", false, false));
        this.listaColumnas.add(new Columna("CORREO", false, false));
        this.listaColumnas.add(new Columna("CONTRASENA", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("ROL_PERSONA", false, false));
        this.listaColumnas.add(new Columna("ESTADO_PERSONA", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.persona.getNombres());
        this.statement.setString(2, this.persona.getPrimerApellido());
        this.statement.setString(3, this.persona.getSegundoApellido());
        this.statement.setString(4, this.persona.getCodigo());
        this.statement.setString(5, this.persona.getCorreo());
        this.statement.setString(6, this.persona.getContrasena());
        this.statement.setDate(7, (Date) this.persona.getFechaCreacion());
        this.statement.setInt(8, this.persona.getUsuarioCreacion());
        this.statement.setDate(9, (Date) this.persona.getFechaModificacion());
        this.statement.setInt(10, this.persona.getUsuarioModificacion());
        this.statement.setInt(11, this.persona.getRolPersona().getRolPersonaId());
        this.statement.setInt(12, this.persona.getEstadoPersona().getEstadoPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.persona.getNombres());
        this.statement.setString(2, this.persona.getPrimerApellido());
        this.statement.setString(3, this.persona.getSegundoApellido());
        this.statement.setString(4, this.persona.getCodigo());
        this.statement.setString(5, this.persona.getCorreo());
        this.statement.setString(6, this.persona.getContrasena());
        this.statement.setDate(7, (Date) this.persona.getFechaCreacion());
        this.statement.setInt(8, this.persona.getUsuarioCreacion());
        this.statement.setDate(9, (Date) this.persona.getFechaModificacion());
        this.statement.setInt(10, this.persona.getUsuarioModificacion());
        this.statement.setInt(11, this.persona.getRolPersona().getRolPersonaId());
        this.statement.setInt(12, this.persona.getEstadoPersona().getEstadoPersonaId());
        this.statement.setInt(13, this.persona.getPersonaId());
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
        this.persona.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.persona.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.persona.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.persona.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
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
