using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Perfil : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Mostrar el nombre del usuario desde sesión o base de datos
                if (Session["NombreUsuario"] != null)
                {
                    lblNombreUsuario.Text = Session["NombreUsuario"].ToString();
                }
                else
                {
                    lblNombreUsuario.Text = "Invitado";
                }
            }

        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {

            Response.Redirect("../PantallaInicio/SquirLearnInicio.aspx");
          
        }

        protected void btnCerrarSesion_Click(object sender, EventArgs e)
        {
            Response.Redirect("../Login/LoginInicio.aspx");
        }
    }
}