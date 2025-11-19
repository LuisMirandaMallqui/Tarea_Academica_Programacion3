
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class SolicitudPedidosAdmin : System.Web.UI.Page
    {
        private PublicacionClient publicacionSOAP;

        public SolicitudPedidosAdmin()
        {

            publicacionSOAP = new PublicacionClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarPedido();
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListadoDeSolicitudesAdmin.aspx");
        }
        private void CargarPedido()
        {
            

            // 1️⃣ Obtener el ID de la publicación desde la URL
            int idPublicacion = Convert.ToInt32(Request.QueryString["id"]);

            // 2️⃣ Llamar al backend (BO → SOAP)
            publicacionDto publicacion = publicacionSOAP.obtenerPorIdPublicacion(idPublicacion);
           
            Session["IdPublicacion"] = publicacion.publicacionId;
            Session["IdPersona"] = publicacion.persona.personaId;

            // 4️⃣ Enlazar los datos al FormView
            fvPedido.DataSource = new[] { publicacion };
            fvPedido.DataBind();
        }
    }
}