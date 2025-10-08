package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.FormatoDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;

public class FormatoDaoImpl extends DAOImplBase implements FormatoDao{

    private FormatoDto formato;

    public FormatoDaoImpl() {
        super("formatos");
        this.formato = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("FORMATO_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.formato.getNombre());
        this.statement.setDate(2, (Date) this.formato.getFechaCreacion());
        this.statement.setInt(3, this.formato.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.formato.getFechaModificacion());
        this.statement.setInt(5, this.formato.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.formato.getNombre());
        this.statement.setDate(2, (Date) this.formato.getFechaCreacion());
        this.statement.setInt(3, this.formato.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.formato.getFechaModificacion());
        this.statement.setInt(5, this.formato.getUsuarioModificacion());
        this.statement.setInt(6, this.formato.getFormatoId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.formato.getFormatoId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.formato.getFormatoId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.formato = new FormatoDto();
        this.formato.setFormatoId(this.resultSet.getInt("FORMATO_ID"));
        this.formato.setNombre(this.resultSet.getString("NOMBRE"));
        this.formato.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.formato.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.formato.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.formato.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.formato = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.formato);
    }
    
    @Override
    public Integer insertar(FormatoDto formato) {
        this.formato = formato;
        return super.insertar();
    }
    @Override
    public FormatoDto obtenerPorId(Integer id) {
        this.formato = new FormatoDto();
        this.formato.setFormatoId(id);
        super.obtenerPorId();
        return this.formato;
    }

    @Override
    public ArrayList<FormatoDto> listarTodos() {
        return (ArrayList<FormatoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(FormatoDto formato) {
        this.formato = formato;
        return super.modificar();
    }

    @Override
    public Integer eliminar(FormatoDto formato) {
        this.formato = formato;
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
