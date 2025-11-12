using SquirlearnWA.MasterPages;
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
            
            
            string usuario = txtUsuario.Text.Trim();
            string contrasena = txtContraseña.Text.Trim();
            
            var loginBO = new LoginBO();
            PersonaDto personaDto = loginBO.ValidarUsuario(usuario, contrasena);

            if (personaDto != null)
            {
                // Guardamos en sesión solo lo necesario
                Session["UsuarioId"] = personaDto.Id;
                Session["Rol"] = personaDto.Rol;
                Session["NombreUsuario"] = personaDto.Nombres + personaDto.primerApellido;
                Response.Redirect(personaDto.Rol == "Administrador"
                                  ? "../PantallaInicio/AdminInicio.aspx"
                                  : "../PantallaInicio/SquirLearnInicio.aspx");
            }
            else
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Usuario o contraseña incorrectos');", true);
            }

            
            /*
            // Simulamos usuarios con roles distintos
           
            if (usuario == "admin" && contrasena == "123")
            {
                Session["Usuario"] = usuario;
                Session["Rol"] = "Administrador";
                Response.Redirect("~/AdminInicio.aspx");
            }
            else if (usuario == "usuario" && contrasena == "123")
            {
                Session["Usuario"] = usuario;
                Session["Rol"] = "Usuario";
                Response.Redirect("~/SquirLearnInicio.aspx");
            }
            else
            {
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