package pe.edu.pucp.squirlearn.daoImpl.util;

public class ParamReporteTransaccionesOfertador {
    private String inicio;
    private String fin;

    public ParamReporteTransaccionesOfertador(String inicio, String fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    public String getInicio() { return inicio; }
    public String getFin() { return fin; }
}