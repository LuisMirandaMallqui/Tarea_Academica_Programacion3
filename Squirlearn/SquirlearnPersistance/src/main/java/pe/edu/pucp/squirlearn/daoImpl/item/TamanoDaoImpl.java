package pe.edu.pucp.squirlearn.daoImpl.item;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;
import pe.edu.pucp.squirlearn.dao.item.TamanoDao;

public class TamanoDaoImpl extends DAOImplBase implements TamanoDao{

    private TamanoDto tamano;

    public TamanoDaoImpl() {
        super("tamanos");
        this.tamano = null;
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
        this.statement.setString(i++, this.tamano.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.tamano.getNombre());
this.statement.setInt(i++, this.tamano.getTamanoId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tamano = new TamanoDto();
        this.tamano.setTamanoId(this.resultSet.getInt("TAMANO_ID"));
        this.tamano.setNombre(this.resultSet.getString("NOMBRE"));
}


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.tamano.getTamanoId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.tamano.getTamanoId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tamano = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.tamano);
    }
    
    @Override
    public Integer insertar(TamanoDto tamaño) {
        this.tamano = tamaño;
        return super.insertar();
    }

    @Override
    public TamanoDto obtenerPorId(Integer id) {
        this.tamano = new TamanoDto();
        this.tamano.setTamanoId(id);
        super.obtenerPorId();
        return this.tamano;
    }

    @Override
    public ArrayList<TamanoDto> listarTodos() {
        return (ArrayList<TamanoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(TamanoDto tamaño) {
        this.tamano = tamaño;
        return super.modificar();
    }

    @Override
    public Integer eliminar(TamanoDto tamaño) {
        this.tamano = tamaño;
        return super.eliminar();
    }

}
