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
        super("rol_personas");
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
        this.statement.setString(1, this.rolPersona.getNombre());
        this.statement.setDate(2, (Date) this.rolPersona.getFechaCreacion());
        this.statement.setInt(3, this.rolPersona.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.rolPersona.getFechaModificacion());
        this.statement.setInt(5, this.rolPersona.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.rolPersona.getNombre());
        this.statement.setDate(2, (Date) this.rolPersona.getFechaCreacion());
        this.statement.setInt(3, this.rolPersona.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.rolPersona.getFechaModificacion());
        this.statement.setInt(5, this.rolPersona.getUsuarioModificacion());
        this.statement.setInt(6, this.rolPersona.getRolPersonaId());
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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.rolPersona = new RolPersonaDto();
        this.rolPersona.setRolPersonaId(this.resultSet.getInt("ROL_PERSONA_ID"));
        this.rolPersona.setNombre(this.resultSet.getString("NOMBRE"));
        this.rolPersona.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.rolPersona.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.rolPersona.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.rolPersona.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
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
