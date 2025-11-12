using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ResponderIncidencia : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {


            if (Request.QueryString["id"] != null)
            {
                int id = int.Parse(Request.QueryString["id"]);
                CargarIncidencia(id);
            }

        }
        private void CargarIncidencia(int id)
        {
            // Ejemplo: traer datos desde la base de datos
            //var incidencia = IncidenciaBO.ObtenerPorId(id);  // Lógica de negocio (BO)
            txtID.Text = id.ToString();
            txtDescripcion.Text="Retraso en entrega de pedido";
            ddlEstado.SelectedValue= "Pendiente";
            //txtID.Text = incidencia.ID.ToString();
            //txtDescripcion.Text = incidencia.Descripcion;
            //ddlEstado.SelectedValue = incidencia.Estado;
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("IncidenciasAdmin.aspx"); 
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            int id = int.Parse(txtID.Text);
            string respuesta = txtRespuesta.Text;
            string nuevoEstado = ddlEstado.SelectedValue;

            // Llamar al Business Object para actualizar
            //IncidenciaBO.ActualizarIncidencia(id, respuesta, nuevoEstado);

            // Puedes redirigir de nuevo a la lista
            Response.Redirect("IncidenciasAdmin.aspx");
        }
    }
}