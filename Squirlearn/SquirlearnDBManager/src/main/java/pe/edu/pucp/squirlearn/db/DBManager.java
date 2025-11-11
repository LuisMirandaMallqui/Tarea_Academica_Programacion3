package pe.edu.pucp.squirlearn.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.edu.pucp.squirlearn.db.util.Cifrado;


public class DBManager {

    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";

    private Connection conexion;
    private String driver;
    private String tipo_de_driver;
    private String base_de_datos;
    private String nombre_de_host;
    private String puerto;
    private String usuario;
    private String contraseña;
    private static DBManager dbManager = null;
    
    private DBManager(){
    }

    public static DBManager getInstance() {
        if (DBManager.dbManager == null) {
            DBManager.createInstance();
        }
        return DBManager.dbManager;
    }

    private static void createInstance() {
        if (DBManager.dbManager == null) {            
            DBManager.dbManager = new DBManager();
            DBManager.dbManager.leer_archivo_de_propiedades();
        }
    }

    public Connection getConnection() throws SQLException {
        try {            
            Class.forName(this.driver);
        
            this.conexion = DriverManager.getConnection(getURL(), this.usuario, this.contraseña);
//            this.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root","13Ag2019");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al generar la conexión - " + ex);
        }
        return conexion;
    }

    private String getURL() {
        String url = this.tipo_de_driver.concat("://");
        url = url.concat(this.nombre_de_host);
        url = url.concat(":");
        url = url.concat(this.puerto);
        url = url.concat("/");
        url = url.concat(this.base_de_datos);
        url = url.concat("?useSSL=false");
        //System.out.println(url);
        return url;
    }

    private void leer_archivo_de_propiedades() {
        Properties properties = new Properties();
        try {      
            String nmArchivoConf = "/" + ARCHIVO_CONFIGURACION;
            properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
            this.driver = properties.getProperty("driver");
            this.tipo_de_driver = properties.getProperty("tipo_de_driver");
            this.base_de_datos = properties.getProperty("base_de_datos");
            this.nombre_de_host = properties.getProperty("nombre_de_host");
            this.puerto = properties.getProperty("puerto");
            this.usuario = properties.getProperty("usuario");
            this.contraseña = properties.getProperty("contrasenha");
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }
    
    public String retornarSQLParaUltimoAutoGenerado() {
        return "select @@last_insert_id as id";
    }
    
}