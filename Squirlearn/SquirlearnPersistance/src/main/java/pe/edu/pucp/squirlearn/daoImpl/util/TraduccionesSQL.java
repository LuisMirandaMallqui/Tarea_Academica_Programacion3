package pe.edu.pucp.squirlearn.daoImpl.util;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author luism
 */
public class TraduccionesSQL {
    /**
     * Constructor privado para prevenir que esta clase de utilidad
     * sea instanciada.
     */
    private TraduccionesSQL() {
        // No hacer nada
    }

    /**
     * Convierte de forma segura un java.util.Date (que incluye fecha y hora)
     * a un java.sql.Timestamp, manejando valores nulos.
     *
     * @param utilDate El objeto java.util.Date de entrada (puede ser null).
     * @return Un objeto java.sql.Timestamp o null si la entrada fue null.
     */
    public static Timestamp toSqlTimestamp(Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new Timestamp(utilDate.getTime());
    }
    
    // Aquí puedes agregar más métodos de utilidad en el futuro,
    // por ejemplo, para manejar `java.time.LocalDate` si migras.
}
