package pe.edu.pucp.squirlearn.daoImpl.chat;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.EstadoMensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;

public class EstadoMensajeDaoImpl extends DAOImplBase implements EstadoMensajeDao{

    private EstadoMensajeDto estadoMensaje;

    public EstadoMensajeDaoImpl() {
        super("estados_mensajes");
        this.estadoMensaje = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADOMSJ_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.estadoMensaje.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i=1;
        this.statement.setString(i++, this.estadoMensaje.getNombre());
        this.statement.setInt(i++, this.estadoMensaje.getEstadoMsjId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoMensaje.getEstadoMsjId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoMensaje.getEstadoMsjId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoMensaje = new EstadoMensajeDto();
        this.estadoMensaje.setEstadoMsjId(this.resultSet.getInt("ESTADOMSJ_ID"));
        this.estadoMensaje.setNombre(this.resultSet.getString("NOMBRE"));
}

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoMensaje = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoMensaje);
    }
    
    @Override
    public Integer insertar(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
        return super.insertar();
    }
    @Override
    public EstadoMensajeDto obtenerPorId(Integer id) {
        this.estadoMensaje = new EstadoMensajeDto();
        this.estadoMensaje.setEstadoMsjId(id);
        super.obtenerPorId();
        return this.estadoMensaje;
    }

    @Override
    public ArrayList<EstadoMensajeDto> listarTodos() {
        return (ArrayList<EstadoMensajeDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
        return super.eliminar();
    }
}
