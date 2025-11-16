
package pe.edu.pucp.squirlearn.daoImpl.util;


public class ParamReporteTransaccionesReceptor {
    private String inicio;
    private String fin;

    public ParamReporteTransaccionesReceptor(String inicio,String fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    public String getInicio() { return inicio; }
    public String getFin() { return fin; }
}