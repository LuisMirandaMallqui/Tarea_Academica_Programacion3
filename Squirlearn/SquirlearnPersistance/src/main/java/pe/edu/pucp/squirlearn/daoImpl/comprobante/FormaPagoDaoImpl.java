package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.comprobante.FormaPagoDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;

public class FormaPagoDaoImpl extends DAOImplBase implements FormaPagoDao{

    private FormaPagoDto formaPago;

    public FormaPagoDaoImpl() {
        super("formas_pago");
        this.formaPago = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("FORMAPAGO_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.formaPago.getNombre());
        this.statement.setDate(i++, this.formaPago.getFechaCreacion());
        this.statement.setInt(i++, this.formaPago.getUsuarioCreacion());
        this.statement.setDate(i++, this.formaPago.getFechaModificacion());
        this.statement.setInt(i++, this.formaPago.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.formaPago.getNombre());
        this.statement.setDate(i++, this.formaPago.getFechaCreacion());
        this.statement.setInt(i++, this.formaPago.getUsuarioCreacion());
        this.statement.setDate(i++, this.formaPago.getFechaModificacion());
        this.statement.setInt(i++, this.formaPago.getUsuarioModificacion());
        this.statement.setInt(i++, this.formaPago.getFormaPagoId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.formaPago = new pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto();
        this.formaPago.setFormaPagoId(this.resultSet.getInt("FORMAPAGO_ID"));
        this.formaPago.setNombre(this.resultSet.getString("NOMBRE"));
        this.formaPago.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.formaPago.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.formaPago.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.formaPago.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.formaPago.getFormaPagoId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.formaPago.getFormaPagoId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.formaPago = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.formaPago);
    }
    
    @Override
    public Integer insertar(FormaPagoDto formaPago) {
        this.formaPago = formaPago;
        return super.insertar();
    }
    @Override
    public FormaPagoDto obtenerPorId(Integer id) {
        this.formaPago = new FormaPagoDto();
        this.formaPago.setFormaPagoId(id);
        super.obtenerPorId();
        return this.formaPago;
    }

    @Override
    public ArrayList<FormaPagoDto> listarTodos() {
        return (ArrayList<FormaPagoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(FormaPagoDto formaPago) {
        this.formaPago = formaPago;
        return super.modificar();
    }

    @Override
    public Integer eliminar(FormaPagoDto formaPago) {
        this.formaPago = formaPago;
        return super.eliminar();
    }
}
