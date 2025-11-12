package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.SubcategoriaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
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
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int categoriaId = safeFkId(
            (this.subcategoria.getCategoria() == null ? null : this.subcategoria.getCategoria().getCategoriaId()),
            "categorias", "CATEGORIA_ID"
        );
        int i = 1;
        this.statement.setString(i++, this.subcategoria.getNombre());      // NOMBRE
        this.statement.setInt(i++, categoriaId);                           // CATEGORIA_ID (FK)
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int categoriaId = safeFkId(
            (this.subcategoria.getCategoria() == null ? null : this.subcategoria.getCategoria().getCategoriaId()),
            "categorias", "CATEGORIA_ID"
        );
        int i = 1;
        this.statement.setString(i++, this.subcategoria.getNombre());
        this.statement.setInt(i++, categoriaId);
        this.statement.setInt(i++, this.subcategoria.getSubcategoriaId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.subcategoria = new SubcategoriaDto();

        CategoriaDto cat = new CategoriaDto();
        cat.setCategoriaId(this.resultSet.getInt("CATEGORIA_ID"));
        this.subcategoria.setCategoria(cat);

        this.subcategoria.setSubcategoriaId(this.resultSet.getInt("SUBCATEGORIA_ID"));
        this.subcategoria.setNombre(this.resultSet.getString("NOMBRE"));
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

    @Override
    public ArrayList<SubcategoriaDto> listarPorCategoria(Integer categoriaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE CATEGORIA_ID=?";
        Consumer<PreparedStatement> incluir = ps -> { 
            try { ps.setInt(1, categoriaId); 
            } catch (SQLException e) { 
                throw new RuntimeException(e); 
            } 
        };
        return (ArrayList<SubcategoriaDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }


}
