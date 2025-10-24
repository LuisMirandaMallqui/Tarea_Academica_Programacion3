package pe.edu.pucp.squirlearn.daoImpl.util;

import java.sql.Date;

public class ParamReporteTransaccionesOfertador {
    private Date inicio;
    private Date fin;

    public ParamReporteTransaccionesOfertador(java.sql.Date inicio, java.sql.Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    public Date getInicio() { return inicio; }
    public Date getFin() { return fin; }
}