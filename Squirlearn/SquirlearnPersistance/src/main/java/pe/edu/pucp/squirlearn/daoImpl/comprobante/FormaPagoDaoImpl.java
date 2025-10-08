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
        super("forma_pagos");
        this.formaPago = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("FORMA_PAGO_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.formaPago.getNombre());
        this.statement.setDate(2, (Date) this.formaPago.getFechaCreacion());
        this.statement.setInt(3, this.formaPago.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.formaPago.getFechaModificacion());
        this.statement.setInt(5, this.formaPago.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.formaPago.getNombre());
        this.statement.setDate(2, (Date) this.formaPago.getFechaCreacion());
        this.statement.setInt(3, this.formaPago.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.formaPago.getFechaModificacion());
        this.statement.setInt(5, this.formaPago.getUsuarioModificacion());
        this.statement.setInt(6, this.formaPago.getFormaPagoId());
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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.formaPago = new FormaPagoDto();
        this.formaPago.setFormaPagoId(this.resultSet.getInt("FORMA_PAGO_ID"));
        this.formaPago.setNombre(this.resultSet.getString("NOMBRE"));
        this.formaPago.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.formaPago.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.formaPago.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.formaPago.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
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


// ====== PLANTILLA PARA PROCEDIMIENTOS ALMACENADOS ======
public void ejecutarProcedimientoPlantilla() {
    Object parametros = null; // TODO: builder/DTO de parámetros
    String sql = "{call MI_SP_EJEMPLO ()}"; // TODO: SP real y firma
    Boolean conTransaccion = true;
    this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosPlantilla, parametros, conTransaccion);
}

private void incluirValorDeParametrosPlantilla(Object objetoParametros) {
    // TODO: castear objetoParametros y hacer setXxx en this.statement
    // this.statement.setInt(1, ...);
    // this.statement.setString(2, ...);
}

public void ejecutarProcedimientoSinParametros(String nombreSP, boolean conTransaccion) {
    String sql = "{call " + nombreSP + "()}";
    this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
}
// ====== FIN PLANTILLA PARA PROCEDIMIENTOS ALMACENADOS ======
}
