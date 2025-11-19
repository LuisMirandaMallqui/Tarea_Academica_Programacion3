
using SquirlearnWA.notificacionSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class RechazoPublicacion : System.Web.UI.Page
    {
        private PublicacionClient publicacionSOAP;
        private NotificacionClient notificacionSOAP;
        private const int ID_ESTADO_RECHAZADO = 5;
        protected void Page_Load(object sender, EventArgs e)
        {
            this.publicacionSOAP = new PublicacionClient();
            this.notificacionSOAP = new NotificacionClient();
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
            string fechaRechazo = DateTime.Now.ToString("dd-MM-yyyy");

            // 3️⃣ Obtener el id de la publicación desde la sesión (si lo guardaste antes)
            int idPublicacion = Convert.ToInt32(Session["IdPublicacion"]);
            int idPersona = Convert.ToInt32(Session["IdPersona"]);

            notificacionSOAP.insertarNotificacion( comentario, idPersona);


            publicacionSOAP.cambiarEstadoPublicacion(idPublicacion, Session["usuarioNombre"].ToString(), "Rechazada");



            Response.Redirect("ListadoDeSolicitudesAdmin.aspx");
        }
    }
}