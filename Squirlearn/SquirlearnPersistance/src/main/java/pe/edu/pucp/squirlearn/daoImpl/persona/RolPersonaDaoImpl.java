package pe.edu.pucp.squirlearn.daoImpl.persona;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.rolPersona.getNombre());
        this.statement.setDate(i++, this.rolPersona.getFechaCreacion());
        this.statement.setInt(i++, this.rolPersona.getUsuarioCreacion());
        this.statement.setDate(i++, this.rolPersona.getFechaModificacion());
        this.statement.setInt(i++, this.rolPersona.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.rolPersona.getNombre());
        this.statement.setDate(i++, this.rolPersona.getFechaCreacion());
        this.statement.setInt(i++, this.rolPersona.getUsuarioCreacion());
        this.statement.setDate(i++, this.rolPersona.getFechaModificacion());
        this.statement.setInt(i++, this.rolPersona.getUsuarioModificacion());
        this.statement.setInt(i++, this.rolPersona.getRolPersonaId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.rolPersona = new RolPersonaDto();
        this.rolPersona.setRolPersonaId(this.resultSet.getInt("ROLPERSONA_ID"));
        this.rolPersona.setNombre(this.resultSet.getString("NOMBRE"));
        this.rolPersona.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.rolPersona.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.rolPersona.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.rolPersona.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
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

}
