package pe.edu.pucp.squirlearn.dao;

import java.util.ArrayList;

public interface IDAO <T> {
    int insertar(T objeto);
    int modificar(T objeto);
    int eliminar(int idObjeto);
    T obtenerPorId(int idObjeto);
    ArrayList<T> listarTodos();
}