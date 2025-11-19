package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.comprobante.DetalleComprobanteDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class DetalleComprobanteDaoImpl extends DAOImplBase implements DetalleComprobanteDao{

    private DetalleComprobanteDto detalleComprobante;

    public DetalleComprobanteDaoImpl() {
        super("detalles_comprobantes");
        this.detalleComprobante = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("DETALLECOM_ID", true, true));
        this.listaColumnas.add(new Columna("COMPROBANTE_ID_COMPROBANTE", false, false));
        this.listaColumnas.add(new Columna("ITEM_ID_ITEM", false, false));
        this.listaColumnas.add(new Columna("ALQUILER_ID_ALQUILER", false, false));
        this.listaColumnas.add(new Columna("DESCRIPCION", false, false));
        this.listaColumnas.add(new Columna("PRECIO", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++,  this.detalleComprobante.getComprobante().getComprobanteId());
        this.statement.setInt(i++, this.detalleComprobante.getItem().getItemId());
        this.statement.setInt(i++, this.detalleComprobante.getAlquiler().getAlquilerId());
        this.statement.setString(i++, this.detalleComprobante.getDescripcion());
        this.statement.setDouble(i++, this.detalleComprobante.getPrecio());
        this.statement.setString(i++, this.detalleComprobante.getusuarioCreacion());
       
        
    }
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.detalleComprobante.getComprobante().getComprobanteId());
        this.statement.setInt(i++, this.detalleComprobante.getItem().getItemId());
        this.statement.setInt(i++, this.detalleComprobante.getAlquiler().getAlquilerId());
        this.statement.setString(i++, this.detalleComprobante.getDescripcion());
        this.statement.setDouble(i++, this.detalleComprobante.getPrecio());
        this.statement.setString(i++, this.detalleComprobante.getusuarioCreacion());
        this.statement.setInt(i++, this.detalleComprobante.getDetalleComId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.detalleComprobante = new DetalleComprobanteDto();

        this.detalleComprobante.setDetalleComId(this.resultSet.getInt("DETALLECOM_ID"));
        // Comprobante
        ComprobanteDto comp = new ComprobanteDto();
        comp.setComprobanteId(this.resultSet.getInt("COMPROBANTE_ID_COMPROBANTE"));
        this.detalleComprobante.setComprobante(comp);

        // Item (nullable)
        int itemId = this.resultSet.getInt("ITEM_ID_ITEM");
        if (!this.resultSet.wasNull()) {
            ItemDto item = new ItemDto();
            item.setItemId(itemId);
            this.detalleComprobante.setItem(item);
        }

        // Alquiler (nullable)
        int alqId = this.resultSet.getInt("ALQUILER_ID_ALQUILER");
        if (!this.resultSet.wasNull()) {
            AlquilerDto alq = new AlquilerDto();
            alq.setAlquilerId(alqId);
            this.detalleComprobante.setAlquiler(alq);
        }

        // Escalares
        this.detalleComprobante.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.detalleComprobante.setPrecio(this.resultSet.getDouble("PRECIO"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.detalleComprobante.getDetalleComId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.detalleComprobante.getDetalleComId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.detalleComprobante = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.detalleComprobante);
    }
    
    @Override
    public Integer insertar(DetalleComprobanteDto detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
        return super.insertar();
    }
    @Override
    public DetalleComprobanteDto obtenerPorId(Integer id) {
        this.detalleComprobante = new DetalleComprobanteDto();
        this.detalleComprobante.setDetalleComId(id);
        super.obtenerPorId();
        return this.detalleComprobante;
    }

    @Override
    public ArrayList<DetalleComprobanteDto> listarTodos() {
        return (ArrayList<DetalleComprobanteDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(DetalleComprobanteDto detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
        return super.modificar();
    }

    @Override
    public Integer eliminar(DetalleComprobanteDto detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
        return super.eliminar();
    }

    @Override
    public ArrayList<DetalleComprobanteDto> listarPorComprobante(Integer personaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE COMPROBANTE_ID_COMPROBANTE=?";
        Consumer<PreparedStatement> incluir = ps -> { 
            try { 
                ps.setInt(1, personaId); 
            } catch (SQLException e) { 
                throw new RuntimeException(e); 
            } 
        };
        return (ArrayList<DetalleComprobanteDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }
}
