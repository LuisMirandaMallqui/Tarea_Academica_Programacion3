package pe.edu.pucp.squirlearn.daoImpl.persona;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.persona.EstadoPersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;

public class EstadoPersonaDaoImpl extends DAOImplBase implements EstadoPersonaDao{

    private EstadoPersonaDto estadoPersona;

    public EstadoPersonaDaoImpl() {
        super("estados_personas");
        this.estadoPersona = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADO_PERSONA_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.estadoPersona.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.estadoPersona.getNombre());
this.statement.setInt(i++, this.estadoPersona.getEstadoPersonaId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoPersona = new EstadoPersonaDto();
        this.estadoPersona.setEstadoPersonaId(this.resultSet.getInt("ESTADOPERSONA_ID"));
        this.estadoPersona.setNombre(this.resultSet.getString("NOMBRE"));
}


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoPersona.getEstadoPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoPersona.getEstadoPersonaId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoPersona = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoPersona);
    }
    
    @Override
    public Integer insertar(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
        return super.insertar();
    }
    @Override
    public EstadoPersonaDto obtenerPorId(Integer id) {
        this.estadoPersona = new EstadoPersonaDto();
        this.estadoPersona.setEstadoPersonaId(id);
        super.obtenerPorId();
        return this.estadoPersona;
    }

    @Override
    public ArrayList<EstadoPersonaDto> listarTodos() {
        return (ArrayList<EstadoPersonaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
        return super.eliminar();
    }



}
