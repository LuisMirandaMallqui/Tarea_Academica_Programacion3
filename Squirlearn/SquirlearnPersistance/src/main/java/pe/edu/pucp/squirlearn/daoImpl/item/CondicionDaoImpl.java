package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.CondicionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;

public class CondicionDaoImpl extends DAOImplBase implements CondicionDao{

    private CondicionDto condicion;

    public CondicionDaoImpl() {
        super("condicions");
        this.condicion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CONDICION_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.condicion.getNombre());
        this.statement.setDate(2, (Date) this.condicion.getFechaCreacion());
        this.statement.setInt(3, this.condicion.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.condicion.getFechaModificacion());
        this.statement.setInt(5, this.condicion.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.condicion.getNombre());
        this.statement.setDate(2, (Date) this.condicion.getFechaCreacion());
        this.statement.setInt(3, this.condicion.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.condicion.getFechaModificacion());
        this.statement.setInt(5, this.condicion.getUsuarioModificacion());
        this.statement.setInt(6, this.condicion.getCondicionId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.condicion.getCondicionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.condicion.getCondicionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.condicion = new CondicionDto();
        this.condicion.setCondicionId(this.resultSet.getInt("CONDICION_ID"));
        this.condicion.setNombre(this.resultSet.getString("NOMBRE"));
        this.condicion.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.condicion.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.condicion.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.condicion.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.condicion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.condicion);
    }
    
    @Override
    public Integer insertar(CondicionDto condicion) {
        this.condicion = condicion;
        return super.insertar();
    }
    @Override
    public CondicionDto obtenerPorId(Integer id) {
        this.condicion = new CondicionDto();
        this.condicion.setCondicionId(id);
        super.obtenerPorId();
        return this.condicion;
    }

    @Override
    public ArrayList<CondicionDto> listarTodos() {
        return (ArrayList<CondicionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(CondicionDto condicion) {
        this.condicion = condicion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(CondicionDto condicion) {
        this.condicion = condicion;
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
