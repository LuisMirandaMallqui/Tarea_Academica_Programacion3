using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class RegistrarIncidencia : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnEnviar_Click(object sender, EventArgs e)
        {
            string mensaje = txtIncidencia.Text.Trim();

            if (!string.IsNullOrEmpty(mensaje))
            {
                // Aquí podrías guardar la incidencia en la base de datos
                // Ejemplo:
                // incidenciaBO.RegistrarIncidencia(usuarioId, mensaje);

                // Mostrar el modal de confirmación
                ScriptManager.RegisterStartupScript(this, GetType(), "mostrarModal", "mostrarModalConfirmacion();", true);

                // Limpiar el texto (opcional)
                txtIncidencia.Text = string.Empty;
            }
        }

       

        protected void btnContinuar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Perfil.aspx");
        }

        protected void btnVolver_Click4(object sender, EventArgs e)
        {
            Response.Redirect("Perfil.aspx");
        }
    }

}