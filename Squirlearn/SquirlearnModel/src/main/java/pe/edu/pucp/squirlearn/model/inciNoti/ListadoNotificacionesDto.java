
package pe.edu.pucp.squirlearn.model.inciNoti;

import java.util.ArrayList;
import java.util.List;


public class ListadoNotificacionesDto {
    
    private List<NotificacionDto> lista;
    private Integer totalRegistros;
    
    public ListadoNotificacionesDto(){
        this.lista = null;
        this.totalRegistros = null;
    }
    
    public ListadoNotificacionesDto(List<NotificacionDto> lista, Integer totalRegistros) {
        this.lista = lista;
        this.totalRegistros = totalRegistros;
    }
    
    public List<NotificacionDto> getLista() {
        return lista;
    }

    public void setLista(List<NotificacionDto> lista) {
        this.lista = lista;
    }

    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    
}
