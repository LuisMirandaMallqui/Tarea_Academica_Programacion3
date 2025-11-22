
using SquirlearnWA.personaSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using personaDto = SquirlearnWA.personaSOAP.personaDto;

namespace SquirlearnWA
{
    public partial class SolicitudPedidosAdmin : System.Web.UI.Page
    {
        private PublicacionClient publicacionSOAP;
        private PersonaClient personaSOAP;

        public SolicitudPedidosAdmin()
        {

            publicacionSOAP = new PublicacionClient();
            personaSOAP = new PersonaClient();
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
            Session["idPublicacion"]=idPublicacion;

            // 2️⃣ Llamar al backend (BO → SOAP)
            publicacionDto publicacion = publicacionSOAP.obtenerPorIdCompleto(idPublicacion);

            personaDto personaCompleta = personaSOAP.obtenerPorIdPersona(publicacion.persona.personaId);
            publicacion.persona.nombres = personaCompleta.nombres;
            publicacion.persona.primerApellido = personaCompleta.primerApellido;
            publicacion.persona.segundoApellido = personaCompleta.segundoApellido;
            publicacion.persona.correo = personaCompleta.correo;
            Session["usuarioNombre"] = personaCompleta.nombres + ' ' + personaCompleta.primerApellido;


            Session["IdPersona"] = publicacion.persona.personaId;
      

            // 4️⃣ Enlazar los datos al FormView
            fvPedido.DataSource = new[] { publicacion };
            fvPedido.DataBind();
        }
    }
}