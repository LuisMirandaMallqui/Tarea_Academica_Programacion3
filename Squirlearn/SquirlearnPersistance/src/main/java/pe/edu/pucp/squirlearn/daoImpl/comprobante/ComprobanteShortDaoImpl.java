/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.dao.comprobante.ComprobanteShortDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.daoImpl.util.Query;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteShortDto;

/**
 *
 * @author luism
 */
public class ComprobanteShortDaoImpl extends DAOImplBase implements ComprobanteShortDao {
    private ComprobanteShortDto comprobantesShort;

    public ComprobanteShortDaoImpl() {
        super("publicaciones");
        this.comprobantesShort = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PUBLICACION_ID", true, true));
        // No es necesario definir todas si solo vamos a usar lectura personalizada
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.comprobantesShort = new ComprobanteShortDto();

        // Datos de comprobantes
        this.comprobantesShort.setTransaccion(this.resultSet.getString("TRANSACCION_ID"));
        this.comprobantesShort.setFechaEmision(this.resultSet.getString("FECHA_EMISION"));
        this.comprobantesShort.setMonto(this.resultSet.getDouble("MONTO"));
        // Datos del detalles_comprobante
        this.comprobantesShort.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        // Datos del item
        this.comprobantesShort.setEsVenta(this.resultSet.getInt("ES_VENTA") == 1);
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.comprobantesShort);
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.comprobantesShort = null;
    }

    private StringBuilder generarPlantillaSqlParaFiltros() {
        return new StringBuilder(
                "SELECT C.TRANSACCION_ID, C.FECHA_EMISION, C.MONTO, "
                + "DC.DESCRIPCION, I.ES_VENTA"
                + "FROM comprobantes C"
                + "JOIN detalles_comprobantes DC ON DC.COMPROBANTE_ID_COMPROBANTE = C.COMPROBANTE_ID"
                + "JOIN items I ON DC.ITEM_ID_ITEM = I.ITEM_ID "
                + "WHERE 1=1 "
        );
    }

    private StringBuilder generarPlantillaSqlParaContar() {
        return new StringBuilder(
                "SELECT COUNT(*) AS TOTAL "
                + "FROM comprobantes C "
                + "WHERE 1=1 "
        );
    }

    @Override
    public ArrayList<ComprobanteShortDto> listarPorDuenoComprobanteShort(
            Integer personaId,
            Boolean esVenta,
            Integer pagina,
            Integer cantidadPorPagina
    ) {
        StringBuilder sql = generarPlantillaSqlParaFiltros();
        ArrayList<Object> parametros = new ArrayList<>();

        if (personaId != null) {
            sql.append(" AND C.PERSONA_ID_PERSONA = ? ");
            parametros.add(personaId);
        }

        // Filtro por Tipo: Si Venta o Alquiler
        if (esVenta != null) {
            sql.append(" AND I.ES_VENTA = ? ");
            parametros.add(esVenta ? 1 : 0);
        }

        Query.aplicarPaginacion(sql, parametros, pagina, cantidadPorPagina);

        Consumer<PreparedStatement> incluirValores = p -> {
            try {
                int i = 1;
                for (Object param : parametros) {
                    this.statement.setObject(i++, param);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        return (ArrayList<ComprobanteShortDto>) this.listarTodos(sql.toString(), incluirValores, null);//
    }

    @Override
    public Integer listarPorDuenoCantidadComprobanteShort(
            Integer personaId,
            Boolean esVenta
    ) {
        StringBuilder sql = generarPlantillaSqlParaContar();
        ArrayList<Object> parametros = new ArrayList<>();

        if (personaId != null) {
            sql.append(" AND C.PERSONA_ID_PERSONA = ? ");
            parametros.add(personaId);
        }

        // Filtro por Tipo: Si Venta o Alquiler
        if (esVenta != null) {
            sql.append(" AND I.ES_VENTA = ? ");
            parametros.add(esVenta ? 1 : 0);
        }

        Consumer<PreparedStatement> incluirValores = p -> {
            try {
                int i = 1;
                for (Object param : parametros) {
                    this.statement.setObject(i++, param);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        return ejecutarConteo(sql, parametros);
    }

    @Override
    public Integer insertar(ComprobanteShortDto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(ComprobanteShortDto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(ComprobanteShortDto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComprobanteShortDto obtenerPorId(Integer idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ComprobanteShortDto> listarTodos() {
        return (ArrayList<ComprobanteShortDto>) super.listarTodos();
    }
}
