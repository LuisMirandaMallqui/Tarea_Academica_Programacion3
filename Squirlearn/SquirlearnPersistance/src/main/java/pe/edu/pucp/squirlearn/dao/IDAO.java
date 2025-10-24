package pe.edu.pucp.squirlearn.dao;

import java.util.ArrayList;

public interface IDAO <T> {
    public Integer insertar(T objeto);
    public Integer modificar(T objeto);
    public Integer eliminar(T objeto);
    public T obtenerPorId(Integer idObjeto);
    public ArrayList<T> listarTodos();
}