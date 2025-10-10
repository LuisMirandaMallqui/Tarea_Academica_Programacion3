package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.SubcategoriaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;

public class SubcategoriaDaoImpl extends DAOImplBase implements SubcategoriaDao{

    private SubcategoriaDto subcategoria;

    public SubcategoriaDaoImpl() {
        super("subcategorias");
        this.subcategoria = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("SUBCATEGORIA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("CATEGORIA", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.subcategoria.getNombre());
        this.statement.setInt(2, this.subcategoria.getCategoria().getCategoriaId());
        this.statement.setDate(3, (Date) this.subcategoria.getFechaCreacion());
        this.statement.setInt(4, this.subcategoria.getUsuarioCreacion());
        this.statement.setDate(5, (Date) this.subcategoria.getFechaModificacion());
        this.statement.setInt(6, this.subcategoria.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.subcategoria.getNombre());
        this.statement.setInt(2, this.subcategoria.getCategoria().getCategoriaId());
        this.statement.setDate(3, (Date) this.subcategoria.getFechaCreacion());
        this.statement.setInt(4, this.subcategoria.getUsuarioCreacion());
        this.statement.setDate(5, (Date) this.subcategoria.getFechaModificacion());
        this.statement.setInt(6, this.subcategoria.getUsuarioModificacion());
        this.statement.setInt(7, this.subcategoria.getSubcategoriaId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.subcategoria.getSubcategoriaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.subcategoria.getSubcategoriaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.subcategoria = new SubcategoriaDto();
        this.subcategoria.setSubcategoriaId(this.resultSet.getInt("SUBCATEGORIA_ID"));
        this.subcategoria.setNombre(this.resultSet.getString("NOMBRE"));
        this.subcategoria.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.subcategoria.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.subcategoria.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.subcategoria.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.subcategoria = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.subcategoria);
    }
    
    @Override
    public Integer insertar(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
        return super.insertar();
    }
    @Override
    public SubcategoriaDto obtenerPorId(Integer id) {
        this.subcategoria = new SubcategoriaDto();
        this.subcategoria.setSubcategoriaId(id);
        super.obtenerPorId();
        return this.subcategoria;
    }

    @Override
    public ArrayList<SubcategoriaDto> listarTodos() {
        return (ArrayList<SubcategoriaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
        return super.modificar();
    }

    @Override
    public Integer eliminar(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
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
