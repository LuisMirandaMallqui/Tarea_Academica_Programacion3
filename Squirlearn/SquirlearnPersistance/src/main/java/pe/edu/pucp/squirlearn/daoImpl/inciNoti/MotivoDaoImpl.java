package pe.edu.pucp.squirlearn.daoImpl.inciNoti;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.inciNoti.MotivoDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;

public class MotivoDaoImpl extends DAOImplBase implements MotivoDao{

    private MotivoDto motivo;

    public MotivoDaoImpl() {
        super("motivos");
        this.motivo = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("MOTIVO_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.motivo.getNombre());
        this.statement.setDate(i++, this.motivo.getFechaCreacion());
        this.statement.setInt(i++, this.motivo.getUsuarioCreacion());
        this.statement.setDate(i++, this.motivo.getFechaModificacion());
        this.statement.setInt(i++, this.motivo.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.motivo.getNombre());
        this.statement.setDate(i++, this.motivo.getFechaCreacion());
        this.statement.setInt(i++, this.motivo.getUsuarioCreacion());
        this.statement.setDate(i++, this.motivo.getFechaModificacion());
        this.statement.setInt(i++, this.motivo.getUsuarioModificacion());
        this.statement.setInt(i++, this.motivo.getMotivoId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.motivo = new MotivoDto();
        this.motivo.setMotivoId(this.resultSet.getInt("MOTIVO_ID"));
        this.motivo.setNombre(this.resultSet.getString("NOMBRE"));
        this.motivo.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.motivo.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.motivo.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.motivo.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.motivo.getMotivoId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.motivo.getMotivoId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.motivo = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.motivo);
    }
    
    @Override
    public Integer insertar(MotivoDto motivo) {
        this.motivo = motivo;
        return super.insertar();
    }
    @Override
    public MotivoDto obtenerPorId(Integer id) {
        this.motivo = new MotivoDto();
        this.motivo.setMotivoId(id);
        super.obtenerPorId();
        return this.motivo;
    }

    @Override
    public ArrayList<MotivoDto> listarTodos() {
        return (ArrayList<MotivoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(MotivoDto motivo) {
        this.motivo = motivo;
        return super.modificar();
    }

    @Override
    public Integer eliminar(MotivoDto motivo) {
        this.motivo = motivo;
        return super.eliminar();
    }


}
