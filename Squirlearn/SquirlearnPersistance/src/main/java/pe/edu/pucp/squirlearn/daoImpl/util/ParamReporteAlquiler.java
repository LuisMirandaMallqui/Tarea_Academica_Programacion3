package pe.edu.pucp.squirlearn.daoImpl.util;

import java.sql.Date;

public class ParamReporteAlquiler {
    private Integer personaId;
    private String inicio;
    private String fin;

    public ParamReporteAlquiler(Integer personaId, String inicio, String fin) {
        this.personaId = personaId;
        this.inicio = inicio;
        this.fin = fin;
    }
    public Integer getPersonaId() { return personaId; }
    public String getInicio() { return inicio; }
    public String getFin() { return fin; }
}