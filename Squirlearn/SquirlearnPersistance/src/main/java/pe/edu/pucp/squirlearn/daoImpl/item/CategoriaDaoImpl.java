package pe.edu.pucp.squirlearn.daoImpl.item;


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
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.categoria.getNombre());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.categoria.getNombre());
        this.statement.setInt(i++, this.categoria.getCategoriaId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.categoria = new pe.edu.pucp.squirlearn.model.item.CategoriaDto();
        this.categoria.setCategoriaId(this.resultSet.getInt("CATEGORIA_ID"));
        this.categoria.setNombre(this.resultSet.getString("NOMBRE"));
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



}
