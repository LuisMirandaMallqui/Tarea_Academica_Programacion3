using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.MasterPages
{
    public partial class SquirLearn : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (Session["Rol"] != null)
            {
                if (Session["Rol"].ToString() == "Administrador")
                {
                    // Mostrar o habilitar opciones especiales
                    menuAdmin.Visible = false;
                    menuUsuario.Visible = true;
                }
                else
                {
                    menuAdmin.Visible = false;
                    menuUsuario.Visible = true;
                }
            }
        }

        protected void lkbCerrarSesion_Click(object sender, EventArgs e)
        {
            Session.Clear();
            Session.Abandon();

            // Redirige al usuario a la página de inicio de sesión
            Response.Redirect("../Login/LoginInicio.aspx");
        }

    }     
}