package pe.edu.pucp.squirlearn.model.publicacion;

import java.util.List;

public class ListadoPublicacionGestionDto {

    private List<PublicacionShortDto> lista;
    private Integer totalPaginas;
    
    public ListadoPublicacionGestionDto(){
        this.lista = null;
        this.totalPaginas = null;
    }
    
    public ListadoPublicacionGestionDto(List<PublicacionShortDto> lista, Integer totalPaginas) {
        this.lista = lista;
        this.totalPaginas = totalPaginas;
    }
    
    public List<PublicacionShortDto> getLista() {
        return lista;
    }

    public void setLista(List<PublicacionShortDto> lista) {
        this.lista = lista;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
    
}
