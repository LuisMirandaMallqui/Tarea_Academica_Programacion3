using SquirlearnWA.incidenciaSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ReportesAdmin : System.Web.UI.Page
    {

        private IncidenciaClient incidenciaSOAP;


        public ReportesAdmin()
        {

            incidenciaSOAP= new IncidenciaClient();


        }


        protected void Page_Load(object sender, EventArgs e)
        {





        }

        // Botón para generar reporte de incidencias
        protected void btnGenerarIncidencias_Click(object sender, EventArgs e)
        {
            try
            {
                // Lógica para generar reporte de incidencias hasta la fecha
                // Por ejemplo, llamar a un método que genere un PDF o Excel
                GenerarReporteIncidencias();

                // Mensaje opcional
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Reporte de incidencias generado correctamente.');", true);
            }
            catch (Exception ex)
            {
                // Manejo de error
                ClientScript.RegisterStartupScript(this.GetType(), "alert", $"alert('Error: {ex.Message}');", true);
            }
        }

        // Botón de "Aceptar" dentro del modal para generar reporte de ventas por periodo
        protected void btnGenerarVentas_Click(object sender, EventArgs e)
        {
            try
            {
                // Obtener fechas del modal usando Request.Form
                string fechaInicioStr = Request.Form["fechaInicio"];
                string fechaFinStr = Request.Form["fechaFin"];

                if (string.IsNullOrEmpty(fechaInicioStr) || string.IsNullOrEmpty(fechaFinStr))
                {
                    ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Debe ingresar ambas fechas.');", true);
                    return;
                }

                DateTime fechaInicio = DateTime.Parse(fechaInicioStr);
                DateTime fechaFin = DateTime.Parse(fechaFinStr);

                // Validación de rango
                if (fechaFin < fechaInicio)
                {
                    ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('La fecha fin no puede ser menor a la fecha inicio.');", true);
                    return;
                }

                // Llamar a método para generar reporte de ventas por periodo
                GenerarReporteVentas(fechaInicio, fechaFin);

                // Mensaje de éxito
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Reporte de ventas generado correctamente.');", true);
            }
            catch (Exception ex)
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", $"alert('Error: {ex.Message}');", true);
            }
        }

        // Métodos de generación de reportes
        private void GenerarReporteIncidencias()
        {
            // Lógica para generar el reporte de incidencias
            // Puede ser exportar a Excel, PDF, etc.
        }

        private void GenerarReporteVentas(DateTime inicio, DateTime fin)
        {
            // Lógica para generar reporte de ventas por periodo
            // Puede ser exportar a Excel, PDF, etc.
        }



    }
}