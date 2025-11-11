package pe.edu.pucp.squirlearn.daoImpl.publicacion;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.publicacion.EstadoPublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;

public class EstadoPublicacionDaoImpl extends DAOImplBase implements EstadoPublicacionDao{

    private EstadoPublicacionDto estadoPublicacion;

    public EstadoPublicacionDaoImpl() {
        super("estados_publicaciones");
        this.estadoPublicacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADO_PUBLICACION_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.estadoPublicacion.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.estadoPublicacion.getNombre());
this.statement.setInt(i++, this.estadoPublicacion.getEstadoPublicacionId()); // WHERE
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoPublicacion.getEstadoPublicacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoPublicacion.getEstadoPublicacionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoPublicacion = new EstadoPublicacionDto();
        this.estadoPublicacion.setEstadoPublicacionId(this.resultSet.getInt("ESTADOPUBLI_ID"));
        this.estadoPublicacion.setNombre(this.resultSet.getString("NOMBRE"));
}


    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoPublicacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoPublicacion);
    }
    
    @Override
    public Integer insertar(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
        return super.insertar();
    }
    @Override
    public EstadoPublicacionDto obtenerPorId(Integer id) {
        this.estadoPublicacion = new EstadoPublicacionDto();
        this.estadoPublicacion.setEstadoPublicacionId(id);
        super.obtenerPorId();
        return this.estadoPublicacion;
    }

    @Override
    public ArrayList<EstadoPublicacionDto> listarTodos() {
        return (ArrayList<EstadoPublicacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoPublicacionDto estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
        return super.eliminar();
    }

}
