/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.squirlearn.daoImpl.publicacion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.dao.publicacion.PublicacionShortDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.daoImpl.util.Query;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionShortDto;

public class PublicacionShortDaoImpl extends DAOImplBase implements PublicacionShortDao {

    private PublicacionShortDto publicacionShort;

    public PublicacionShortDaoImpl() {
        super("publicaciones"); // La tabla base sigue siendo publicaciones
        this.publicacionShort = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PUBLICACION_ID", true, true));
        // No es necesario definir todas si solo vamos a usar lectura personalizada
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.publicacionShort = new PublicacionShortDto();

        // Datos de la Publicación
        this.publicacionShort.setPublicacionId(this.resultSet.getInt("PUBLICACION_ID"));
        this.publicacionShort.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.publicacionShort.setEstadoPublicacionId(this.resultSet.getInt("ESTADO_PUBLICACION_ID"));
        this.publicacionShort.setFechaEnvio(this.resultSet.getString("FECHA_ALTA")); // Ojo: Convertir si es necesario

        // Datos del Item
        this.publicacionShort.setItemId(this.resultSet.getInt("ITEM_ID_ITEM"));
        this.publicacionShort.setNombre(this.resultSet.getString("NOMBRE_ITEM")); // Alias usado en el SQL
        this.publicacionShort.setPrecio(this.resultSet.getDouble("PRECIO"));
        this.publicacionShort.setEsVenta(this.resultSet.getInt("ES_VENTA") == 1);

        // Datos de Nombres 
        this.publicacionShort.setEstadoNombre(this.resultSet.getString("ESTADO_NOMBRE"));
        this.publicacionShort.setCategoriaNombre(this.resultSet.getString("CATEGORIA_NOMBRE"));
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.publicacionShort);
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
        this.publicacionShort = null;
    }

    private StringBuilder generarPlantillaSqlParaFiltros() {
        return new StringBuilder(
                "SELECT P.PUBLICACION_ID, P.FECHA_ALTA, "
                + "P.ESTADO_PUBLICACION_ID, P.PERSONA_ID, "
                + "I.ITEM_ID AS ITEM_ID_ITEM, I.PRECIO, I.ES_VENTA, "
                + "I.subcategoria_ID_SUBCATEGORIAsubcategorias, I.subcategoria_CATEGORIA_ID "
                + "C.Nombre AS CategoriaNombre"
                + "EP.Nombre AS EstadoNombre"
                + "FROM publicaciones P"
                + "JOIN items I ON P.ITEM_ID_ITEM = I.ITEM_ID "
                + "JOIN categorias C ON I.subcategoria_CATEGORIA_ID = C.CATEGORIA_ID"
                + "JOIN estados_publicaciones EP ON P.ESTADO_PUBLICACION_ID = EP.ESTADOPUBLI_ID "
                + "WHERE 1=1 "
        );
    }

    @Override
    public ArrayList<PublicacionShortDto> listarPorFiltrosPublicacion(
            String terminoBusqueda,
            Boolean esVenta,
            Integer idCategoria,
            Integer idSubcategoria,
            Integer idColor,
            Integer idTamano,
            Integer idFormato,
            Integer idCondicion,
            Integer pagina,
            Integer cantidadPorPagina
    ) {

        StringBuilder sql = generarPlantillaSqlParaFiltros();

        ArrayList<Object> parametros = new ArrayList<>();

        if (terminoBusqueda != null && !terminoBusqueda.isBlank()) {
            sql.append(" AND I.NOMBRE LIKE ? ");
            parametros.add("%" + terminoBusqueda + "%");
        }

        if (esVenta != null) {
            sql.append(" AND I.ES_VENTA = ? ");
            parametros.add(esVenta ? 1 : 0);
        }

        if (idCategoria != 0) {
            sql.append(" AND I.subcategoria_CATEGORIA_ID = ? ");
            parametros.add(idCategoria);
        }

        if (idSubcategoria != 0) {
            sql.append(" AND I.subcategoria_ID_SUBCATEGORIA = ? ");
            parametros.add(idSubcategoria);
        }

        if (idColor != 0) {
            sql.append(" AND I.COLOR_ID = ? ");
            parametros.add(idColor);
        }

        if (idTamano != 0) {
            sql.append(" AND I.TAMANO_ID = ? ");
            parametros.add(idTamano);
        }

        if (idFormato != 0) {
            sql.append(" AND I.FORMATO_ID = ? ");
            parametros.add(idFormato);
        }

        if (idCondicion != 0) {
            sql.append(" AND I.CONDICION_ID = ? ");
            parametros.add(idCondicion);
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

        return (ArrayList<PublicacionShortDto>) this.listarTodos(sql.toString(), incluirValores, null);//
    }

    @Override
    public ArrayList<PublicacionShortDto> listarPorFiltrosPublicacion(
            Integer usuarioId,
            Integer cantidadPorPagina,
            Integer pagina,
            Integer estadoId
    ) {
        StringBuilder sql = generarPlantillaSqlParaFiltros();

        ArrayList<Object> parametros = new ArrayList<>();
        if (usuarioId != null) {
            sql.append(" AND P.PERSONA_ID = ? ");
            parametros.add(usuarioId);
        }

        if (estadoId != null) {
            sql.append(" AND P.ESTADO_PUBLICACION_ID = ? ");
            parametros.add(estadoId);
        }
        Query.aplicarPaginacion(sql, parametros, pagina, cantidadPorPagina); // POR PROBAR

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
        return (ArrayList<PublicacionShortDto>) this.listarTodos(sql.toString(), incluirValores, null);//
    }

    @Override
    public Integer insertar(PublicacionShortDto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(PublicacionShortDto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(PublicacionShortDto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PublicacionShortDto obtenerPorId(Integer idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PublicacionShortDto> listarTodos() {
        return (ArrayList<PublicacionShortDto>) super.listarTodos();
    }

}
