
package com.mycompany.squirdlearn.reports;

import com.google.protobuf.TextFormat.ParseException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.squirlearn.db.DBManager;

/**
 *
 * @author alons
 */
public class ReporteUtil {
    
   private static byte[] invocarReporte(String nombreReporte, HashMap parametros) {
        byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        String nmReporte = "/" + nombreReporte + ".jasper";
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteUtil.class.getResource(nmReporte));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros,conexion);
            reporte = JasperExportManager.exportReportToPdf(jp);
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return reporte;
    }

    public static byte[] reporteIncidenciasUsuarios() {
        return invocarReporte("Reporte_Incidencias_Usuarios",null);
    }
    
    public static byte[] reporteListadoVentasVendedores(String fechaInicio, String fechaFin) throws java.text.ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilInicio = null;
        java.util.Date utilFin = null;
        utilInicio = formato.parse(fechaInicio);
        utilFin = formato.parse(fechaFin);
        java.sql.Date sqlInicio = new java.sql.Date(utilInicio.getTime());
        java.sql.Date sqlFin = new java.sql.Date(utilFin.getTime());
        
        HashMap parametros = new HashMap();
        parametros.put("_fechaInicio", sqlInicio);
        parametros.put("_fechaFin", sqlFin);
        return invocarReporte("Reporte_Listado_Ventas_Vendedores",parametros);
    }
    
    public static byte[] reporteVentasAlquiler(Integer persona_id, String fechaInicio, String fechaFin) throws java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilInicio = null;
        java.util.Date utilFin = null;
        utilInicio = formato.parse(fechaInicio);
        utilFin = formato.parse(fechaFin);
        java.sql.Date sqlInicio = new java.sql.Date(utilInicio.getTime());
        java.sql.Date sqlFin = new java.sql.Date(utilFin.getTime());
        
        HashMap parametros = new HashMap();
        parametros.put("persona_id", persona_id);
        parametros.put("_fechaInicio", sqlInicio);
        parametros.put("_fechaFin", sqlFin);
        return invocarReporte("Reporte_Ventas_Alquiler",parametros);
    }
    
}
