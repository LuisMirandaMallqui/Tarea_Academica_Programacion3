package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.CategoriaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;

public class CategoriaDaoImpl extends DAOImplBase implements CategoriaDao{

    private CategoriaDto categoria;

    public CategoriaDaoImpl() {
        super("categorias");
        this.categoria = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CATEGORIA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.categoria.getNombre());
        this.statement.setDate(2, (Date) this.categoria.getFechaCreacion());
        this.statement.setInt(3, this.categoria.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.categoria.getFechaModificacion());
        this.statement.setInt(5, this.categoria.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.categoria.getNombre());
        this.statement.setDate(2, (Date) this.categoria.getFechaCreacion());
        this.statement.setInt(3, this.categoria.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.categoria.getFechaModificacion());
        this.statement.setInt(5, this.categoria.getUsuarioModificacion());
        this.statement.setInt(6, this.categoria.getCategoriaId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.categoria.getCategoriaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.categoria.getCategoriaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.categoria = new CategoriaDto();
        this.categoria.setCategoriaId(this.resultSet.getInt("CATEGORIA_ID"));
        this.categoria.setNombre(this.resultSet.getString("NOMBRE"));
        this.categoria.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.categoria.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.categoria.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.categoria.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.categoria = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.categoria);
    }
    
    @Override
    public Integer insertar(CategoriaDto categoria) {
        this.categoria = categoria;
        return super.insertar();
    }
    @Override
    public CategoriaDto obtenerPorId(Integer id) {
        this.categoria = new CategoriaDto();
        this.categoria.setCategoriaId(id);
        super.obtenerPorId();
        return this.categoria;
    }

    @Override
    public ArrayList<CategoriaDto> listarTodos() {
        return (ArrayList<CategoriaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(CategoriaDto categoria) {
        this.categoria = categoria;
        return super.modificar();
    }

    @Override
    public Integer eliminar(CategoriaDto categoria) {
        this.categoria = categoria;
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
