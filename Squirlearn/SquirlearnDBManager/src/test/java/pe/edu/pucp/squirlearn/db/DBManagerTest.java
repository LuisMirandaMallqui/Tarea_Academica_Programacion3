package pe.edu.pucp.squirlearn.db;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alons
 */
public class DBManagerTest {
    
  
    @Test
     public void testGetInstance() {
        System.out.println("getInstance");                
        DBManager dBManager = DBManager.getInstance();
        assertNotNull(dBManager);
    }

    /**
     * Test of getConnection method, of class DBManager.
     */
    @Test
      public void testGetConnection() throws SQLException {
        System.out.println("getConnection");                
        DBManager dBManager = DBManager.getInstance();
        Connection conexion = dBManager.getConnection();
        assertNotNull(conexion);
    }
    
}
