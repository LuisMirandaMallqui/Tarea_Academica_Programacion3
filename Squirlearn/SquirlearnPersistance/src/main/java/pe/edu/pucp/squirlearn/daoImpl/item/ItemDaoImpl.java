package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.ItemDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.edu.pucp.squirlearn.model.item.ColorDto;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class ItemDaoImpl extends DAOImplBase implements ItemDao{

    private ItemDto item;

    public ItemDaoImpl() {
        super("items");
        this.item = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ITEM_ID", true, true));
        this.listaColumnas.add(new Columna("COLOR_ID", false, false));
        this.listaColumnas.add(new Columna("ESTADO_ITEM_ID", false, false));
        this.listaColumnas.add(new Columna("CONDICION_ID", false, false));
        this.listaColumnas.add(new Columna("TAMANO_ID", false, false));
        this.listaColumnas.add(new Columna("FORMATO_ID", false, false));
        this.listaColumnas.add(new Columna("subcategoria_ID_SUBCATEGORIA", false, false));
        this.listaColumnas.add(new Columna("subcategoria_CATEGORIA_ID", false, false));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("DESCRIPCION", false, false));
        this.listaColumnas.add(new Columna("PRECIO", false, false));
        this.listaColumnas.add(new Columna("ES_VENTA", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.item.getColor().getColorId()); 
        this.statement.setInt(i++, this.item.getEstadoItem().getEstadoItemId());   
        this.statement.setInt(i++, this.item.getCondicion().getCondicionId());                                                // COLOR_ID
        this.statement.setInt(i++, this.item.getTamano().getTamanoId());                                             // TAMANO_ID
        this.statement.setInt(i++, this.item.getFormato().getFormatoId());                                              // FORMATO_ID
        this.statement.setInt(i++, this.item.getSubcategoria().getSubcategoriaId());                                                  // subcategoria_ID_SUBCATEGORIA
        this.statement.setInt(i++, this.item.getCategoria().getCategoriaId());         
        this.statement.setString(i++, this.item.getNombre());                               // NOMBRE
        this.statement.setString(i++, this.item.getDescripcion());                          // DESCRIPCION
        this.statement.setDouble(i++, this.item.getPrecio());                           // PRECIO
        this.statement.setInt(i++, this.item.getEsVenta()? 1 : 0);                          // ES_VENTA (TINYINT)
        this.statement.setString(i++, this.item.getusuarioCreacion());   
        this.statement.setString(i++, this.item.getusuarioModificacion());          
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i=1;
        this.statement.setInt(i++, this.item.getColor().getColorId()); 
        this.statement.setInt(i++, this.item.getEstadoItem().getEstadoItemId());   
        this.statement.setInt(i++, this.item.getCondicion().getCondicionId());                                                // COLOR_ID
        this.statement.setInt(i++, this.item.getTamano().getTamanoId());                                             // TAMANO_ID
        this.statement.setInt(i++, this.item.getFormato().getFormatoId());                                              // FORMATO_ID
        this.statement.setInt(i++, this.item.getSubcategoria().getSubcategoriaId());                                                  // subcategoria_ID_SUBCATEGORIA
        this.statement.setInt(i++, this.item.getCategoria().getCategoriaId());         
        this.statement.setString(i++, this.item.getNombre());                               // NOMBRE
        this.statement.setString(i++, this.item.getDescripcion());                          // DESCRIPCION
        this.statement.setDouble(i++, this.item.getPrecio());                           // PRECIO
        this.statement.setInt(i++, this.item.getEsVenta()? 1 : 0);                          // ES_VENTA (TINYINT)
        this.statement.setString(i++, this.item.getusuarioCreacion());  
        this.statement.setString(i++, this.item.getusuarioModificacion());   
        this.statement.setInt(i++, this.item.getItemId()); // WHERE ITEM_ID=?
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.item.getItemId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.item.getItemId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.item = new ItemDto();

        this.item.setItemId(this.resultSet.getInt("ITEM_ID"));
        // Color
        ColorDto color = new ColorDto();
        color.setColorId(this.resultSet.getInt("COLOR_ID"));
        this.item.setColor(color);

        // EstadoItem
        EstadoItemDto ei = new EstadoItemDto();
        ei.setEstadoItemId(this.resultSet.getInt("ESTADO_ITEM_ID"));
        this.item.setEstadoItem(ei);

        // Condicion
        CondicionDto cond = new CondicionDto();
        cond.setCondicionId(this.resultSet.getInt("CONDICION_ID"));
        this.item.setCondicion(cond);

        // Tamano
        TamanoDto tam = new TamanoDto();
        tam.setTamanoId(this.resultSet.getInt("TAMANO_ID"));
        this.item.setTamano(tam);

        // Formato
        FormatoDto fmt = new FormatoDto();
        fmt.setFormatoId(this.resultSet.getInt("FORMATO_ID"));
        this.item.setFormato(fmt);

        // Subcategoria (par compuesto)
        SubcategoriaDto sub = new SubcategoriaDto();
        sub.setSubcategoriaId(this.resultSet.getInt("subcategoria_ID_SUBCATEGORIA"));
        this.item.setSubcategoria(sub);
        
        // Categoria
        CategoriaDto cat = new CategoriaDto();
        cat.setCategoriaId(this.resultSet.getInt("subcategoria_CATEGORIA_ID"));
        this.item.setCategoria(cat);

        // Escalares
        this.item.setNombre(this.resultSet.getString("NOMBRE"));
        this.item.setPrecio(this.resultSet.getDouble("PRECIO"));
        this.item.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.item.setEsVenta(this.resultSet.getInt("ES_VENTA") == 1);
    }


    @Override
    protected void limpiarObjetoDelResultSet() {
        this.item = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.item);
    }
    
    @Override
    public Integer insertar(ItemDto item) {
        this.item = item;
        return super.insertar();
    }
    @Override
    public ItemDto obtenerPorId(Integer id) {
        this.item = new ItemDto();
        this.item.setItemId(id);
        super.obtenerPorId();
        return this.item;
    }

    @Override
    public ArrayList<ItemDto> listarTodos() {
        return (ArrayList<ItemDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ItemDto item) {
        this.item = item;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ItemDto item) {
        this.item = item;
        return super.eliminar();
    }


}
