using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class LoginInicio : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        
        protected void btnLogin_Click(object sender, EventArgs e)
        {
            // Simulación de autenticación
            string usuario = txtUsuario.Text.Trim();
            string contrasena = txtContraseña.Text.Trim();

            Response.Redirect("~/SquirLearnInicio.aspx");
            /*
            if (usuario == "admin" && contrasena == "123")
            {
                // Redirige al Master principal
               
            }
            else
            {
                // Mostrar mensaje (puedes usar un Label o alert JS)
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Usuario o contraseña incorrectos');", true);
            }
            */
        }

        protected void btnRegistro_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/LoginRegistro.aspx");
           
        }

       
    }
}