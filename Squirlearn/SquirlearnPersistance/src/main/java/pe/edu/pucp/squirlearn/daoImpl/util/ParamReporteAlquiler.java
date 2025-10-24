package pe.edu.pucp.squirlearn.daoImpl.util;

import java.sql.Date;

public class ParamReporteAlquiler {
    private Integer personaId;
    private Date inicio;
    private Date fin;

    public ParamReporteAlquiler(Integer personaId, Date inicio, java.sql.Date fin) {
        this.personaId = personaId;
        this.inicio = inicio;
        this.fin = fin;
    }
    public Integer getPersonaId() { return personaId; }
    public java.sql.Date getInicio() { return inicio; }
    public java.sql.Date getFin() { return fin; }
}