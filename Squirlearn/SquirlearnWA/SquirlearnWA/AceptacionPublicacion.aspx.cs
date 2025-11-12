using SoftInvBusiness;
using SquirLearnBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class AceptacionPublicacion : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("SolicitudPedidosAdmin.aspx");
        }

        protected void btnEnviar_Click(object sender, EventArgs e)

        {

            // 1️⃣ Obtener el texto ingresado
            string comentario = txtIncidencia.Text.Trim();

            // 2️⃣ Obtener la fecha actual del sistema
            DateTime fechaRechazo = DateTime.Now;

            // 3️⃣ Obtener el id de la publicación desde la sesión (si lo guardaste antes)
            int idPublicacion = Convert.ToInt32(Session["IdPublicacion"]);
            int idPersona = Convert.ToInt32(Session["UsuarioId"]);

            NotificacionDTO notificacion = new NotificacionDTO
            {
                UsuarioId = idPersona,

                Mensaje = comentario,
                Fecha = fechaRechazo,

            };
            notificacionBO.Insertar(notificacion);

            publicacionBO.CambiarEstado(idPublicacion, "Aceptado");


            Response.Redirect("ListadoDeSolicitudesAdmin.aspx");
        }

    }    
}