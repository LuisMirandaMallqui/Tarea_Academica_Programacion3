package pe.edu.pucp.squirlearn.daoImpl.item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.item.ColorDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.item.ColorDto;

public class ColorDaoImpl extends DAOImplBase implements ColorDao{

    private ColorDto color;

    public ColorDaoImpl() {
        super("colores");
        this.color = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("COLOR_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.color.getNombre());
        this.statement.setDate(i++, this.color.getFechaCreacion());
        this.statement.setInt(i++, this.color.getUsuarioCreacion());
        this.statement.setDate(i++, this.color.getFechaModificacion());
        this.statement.setInt(i++, this.color.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.color.getNombre());
        this.statement.setDate(i++, this.color.getFechaCreacion());
        this.statement.setInt(i++, this.color.getUsuarioCreacion());
        this.statement.setDate(i++, this.color.getFechaModificacion());
        this.statement.setInt(i++, this.color.getUsuarioModificacion());
        this.statement.setInt(i++, this.color.getColorId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.color = new ColorDto();
        this.color.setColorId(this.resultSet.getInt("COLOR_ID"));
        this.color.setNombre(this.resultSet.getString("NOMBRE"));
        this.color.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.color.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.color.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.color.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.color.getColorId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.color.getColorId());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.color = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.color);
    }
    
    @Override
    public Integer insertar(ColorDto color) {
        this.color = color;
        return super.insertar();
    }
    @Override
    public ColorDto obtenerPorId(Integer id) {
        this.color = new ColorDto();
        this.color.setColorId(id);
        super.obtenerPorId();
        return this.color;
    }

    @Override
    public ArrayList<ColorDto> listarTodos() {
        return (ArrayList<ColorDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ColorDto color) {
        this.color = color;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ColorDto color) {
        this.color = color;
        return super.eliminar();
    }



}
