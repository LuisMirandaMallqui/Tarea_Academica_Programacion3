package pe.edu.pucp.squirlearn.daoImpl.item;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.TamañoDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.TamañoDto;

public class TamañoDaoImpl extends DAOImplBase implements TamañoDao{

    private TamañoDto tamaño;

    public TamañoDaoImpl() {
        super("tamanos");
        this.tamaño = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("TAMANO_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.tamaño.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.tamaño.getNombre());
this.statement.setInt(i++, this.tamaño.getTamanoId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tamaño = new TamañoDto();
        this.tamaño.setTamanoId(this.resultSet.getInt("TAMANO_ID"));
        this.tamaño.setNombre(this.resultSet.getString("NOMBRE"));
}


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.tamaño.getTamanoId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.tamaño.getTamanoId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tamaño = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.tamaño);
    }
    
    @Override
    public Integer insertar(TamañoDto tamaño) {
        this.tamaño = tamaño;
        return super.insertar();
    }

    @Override
    public TamañoDto obtenerPorId(Integer id) {
        this.tamaño = new TamañoDto();
        this.tamaño.setTamanoId(id);
        super.obtenerPorId();
        return this.tamaño;
    }

    @Override
    public ArrayList<TamañoDto> listarTodos() {
        return (ArrayList<TamañoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(TamañoDto tamaño) {
        this.tamaño = tamaño;
        return super.modificar();
    }

    @Override
    public Integer eliminar(TamañoDto tamaño) {
        this.tamaño = tamaño;
        return super.eliminar();
    }

}
