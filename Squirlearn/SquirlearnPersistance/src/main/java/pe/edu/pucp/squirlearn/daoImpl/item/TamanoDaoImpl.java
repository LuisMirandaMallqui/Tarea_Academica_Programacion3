package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;
import pe.edu.pucp.squirlearn.dao.item.TamanoDao;

public class TamanoDaoImpl extends DAOImplBase implements TamanoDao{

    private TamanoDto tamaño;

    public TamanoDaoImpl() {
        super("tamanos");
        this.tamaño = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("TAMANO_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.tamaño.getNombre());
        this.statement.setDate(2, (Date) this.tamaño.getFechaCreacion());
        this.statement.setInt(3, this.tamaño.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.tamaño.getFechaModificacion());
        this.statement.setInt(5, this.tamaño.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.tamaño.getNombre());
        this.statement.setDate(2, (Date) this.tamaño.getFechaCreacion());
        this.statement.setInt(3, this.tamaño.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.tamaño.getFechaModificacion());
        this.statement.setInt(5, this.tamaño.getUsuarioModificacion());
        this.statement.setInt(6, this.tamaño.getTamanoId());
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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tamaño = new TamanoDto();
        this.tamaño.setTamanoId(this.resultSet.getInt("TAMANO_ID"));
        this.tamaño.setNombre(this.resultSet.getString("NOMBRE"));
        this.tamaño.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.tamaño.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.tamaño.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.tamaño.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
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
    public Integer insertar(TamanoDto tamaño) {
        this.tamaño = tamaño;
        return super.insertar();
    }

    @Override
    public TamanoDto obtenerPorId(Integer id) {
        this.tamaño = new TamanoDto();
        this.tamaño.setTamanoId(id);
        super.obtenerPorId();
        return this.tamaño;
    }

    @Override
    public ArrayList<TamanoDto> listarTodos() {
        return (ArrayList<TamanoDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(TamanoDto tamaño) {
        this.tamaño = tamaño;
        return super.modificar();
    }

    @Override
    public Integer eliminar(TamanoDto tamaño) {
        this.tamaño = tamaño;
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
