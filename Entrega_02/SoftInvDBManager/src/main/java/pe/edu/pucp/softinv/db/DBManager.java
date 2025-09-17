package pe.edu.pucp.softinv.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DBManager que lee jdbc.properties (claves en español) y construye el URL.
 * Incluye createDatabaseIfNotExist para evitar "Unknown database 'soft-test'".
 */
public class DBManager {
    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";
    private static DBManager instance;

    private final String url;
    private final String user;
    private final String password;

    private DBManager() {
        try (InputStream in = DBManager.class.getClassLoader().getResourceAsStream(ARCHIVO_CONFIGURACION)) {
            if (in == null) throw new IllegalStateException("No se encontró " + ARCHIVO_CONFIGURACION + " en resources");
            Properties p = new Properties();
            p.load(in);

            String driver   = p.getProperty("driver", "com.mysql.cj.jdbc.Driver").trim();
            String tipo     = p.getProperty("tipo_de_driver", "jdbc:mysql").trim(); // jdbc:mysql
            String host     = p.getProperty("nombre_de_host").trim();
            String puerto   = p.getProperty("puerto", "3306").trim();
            String base     = p.getProperty("base_de_datos").trim();
            this.user       = p.getProperty("usuario").trim();
            this.password   = p.getProperty("contrasenha"); // texto plano

            if (!driver.isBlank()) Class.forName(driver);

            // crea la BD si no existe + SSL + timezone
            this.url = String.format(
                "%s://%s:%s/%s?createDatabaseIfNotExist=true&sslMode=REQUIRED&serverTimezone=UTC",
                tipo, host, puerto, base
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo inicializar DBManager", e);
        }
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) instance = new DBManager();
        return instance;
    }

    /** Retorna una conexión abierta. Lanza RuntimeException si falla. */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo abrir conexión a: " + url, e);
        }
    }
}
