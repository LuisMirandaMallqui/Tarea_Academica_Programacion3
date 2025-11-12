package pe.edu.pucp.squirlearn.daoImpl.item;


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
    }

   @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.formato.getNombre());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.formato.getNombre());
        this.statement.setInt(i++, this.formato.getFormatoId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.formato = new FormatoDto();
        this.formato.setFormatoId(this.resultSet.getInt("FORMATO_ID"));
        this.formato.setNombre(this.resultSet.getString("NOMBRE"));
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


}
