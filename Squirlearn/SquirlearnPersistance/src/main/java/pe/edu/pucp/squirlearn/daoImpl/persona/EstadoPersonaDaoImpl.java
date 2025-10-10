package pe.edu.pucp.squirlearn.daoImpl.persona;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.persona.EstadoPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;

public class EstadoPersonaDaoImpl extends DAOImplBase implements EstadoPersonaDao{

    private EstadoPersonaDto estadoPersona;

    public EstadoPersonaDaoImpl() {
        super("estado_personas");
        this.estadoPersona = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADO_PERSONA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.estadoPersona.getNombre());
        this.statement.setDate(2, (Date) this.estadoPersona.getFechaCreacion());
        this.statement.setInt(3, this.estadoPersona.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoPersona.getFechaModificacion());
        this.statement.setInt(5, this.estadoPersona.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.estadoPersona.getNombre());
        this.statement.setDate(2, (Date) this.estadoPersona.getFechaCreacion());
        this.statement.setInt(3, this.estadoPersona.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoPersona.getFechaModificacion());
        this.statement.setInt(5, this.estadoPersona.getUsuarioModificacion());
        this.statement.setInt(6, this.estadoPersona.getEstadoPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoPersona.getEstadoPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoPersona.getEstadoPersonaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoPersona = new EstadoPersonaDto();
        this.estadoPersona.setEstadoPersonaId(this.resultSet.getInt("ESTADO_PERSONA_ID"));
        this.estadoPersona.setNombre(this.resultSet.getString("NOMBRE"));
        this.estadoPersona.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.estadoPersona.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.estadoPersona.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.estadoPersona.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoPersona = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoPersona);
    }
    
    @Override
    public Integer insertar(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
        return super.insertar();
    }
    @Override
    public EstadoPersonaDto obtenerPorId(Integer id) {
        this.estadoPersona = new EstadoPersonaDto();
        this.estadoPersona.setEstadoPersonaId(id);
        super.obtenerPorId();
        return this.estadoPersona;
    }

    @Override
    public ArrayList<EstadoPersonaDto> listarTodos() {
        return (ArrayList<EstadoPersonaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
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
