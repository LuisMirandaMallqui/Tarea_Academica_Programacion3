
using SquirlearnWA.notificacionSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.Administrador
{
    public partial class AceptacionPublicacion : System.Web.UI.Page
    {
        private PublicacionClient publicacionSOAP;
        private NotificacionClient notificacionSOAP;
        private const int ID_ESTADO_ACEPTADO = 5;

        public AceptacionPublicacion()
        {
            this.publicacionSOAP = new PublicacionClient();
            this.notificacionSOAP = new NotificacionClient();
        }



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
            string fechaAceptacion = DateTime.Now.ToString("dd-MM-yyyy");

            // 3️⃣ Obtener el id de la publicación desde la sesión (si lo guardaste antes)
            int idPublicacion = Convert.ToInt32(Session["IdPublicacion"]);
            int idPersona = Convert.ToInt32(Session["IdPersona"]);

            notificacionSOAP.InsertarNotificacion( comentario, idPersona);


            publicacionSOAP.CambiarEstadoPublicacion(idPublicacion, (int)Session["UsuarioId"], "Aceptada"); 


            Response.Redirect("ListadoDeSolicitudesAdmin.aspx");
        }

    }    
}