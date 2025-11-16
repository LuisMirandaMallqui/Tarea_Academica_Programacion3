package pe.edu.pucp.squirlearn.daoImpl.item;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.CondicionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;

public class CondicionDaoImpl extends DAOImplBase implements CondicionDao{

    private CondicionDto condicion;

    public CondicionDaoImpl() {
        super("condiciones");
        this.condicion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CONDICION_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.condicion.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.condicion.getNombre());
this.statement.setInt(i++, this.condicion.getCondicionId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.condicion = new pe.edu.pucp.squirlearn.model.item.CondicionDto();
        this.condicion.setCondicionId(this.resultSet.getInt("CONDICION_ID"));
        this.condicion.setNombre(this.resultSet.getString("NOMBRE"));
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


}
