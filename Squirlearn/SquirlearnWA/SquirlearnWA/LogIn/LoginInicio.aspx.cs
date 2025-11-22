using SquirlearnWA.MasterPages;
using SquirlearnWA.personaSOAP;
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

        private PersonaClient personaSoap;

        public LoginInicio()
        {
            personaSoap = new PersonaClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        
        protected void btnLogin_Click(object sender, EventArgs e)
        {


            string correoElectronico = txtUsuario.Text.Trim();
            string contrasena = txtContraseña.Text.Trim();
            
            personaDto usuarioLogeado = personaSoap.logInPersona(correoElectronico, contrasena);

            if (usuarioLogeado != null)
            {

                // Guardamos en sesión solo lo necesario
                Session["usuarioId"] = usuarioLogeado.personaId;
                
                IList<rolPersonaDto> lista = usuarioLogeado.rolPersona;
                Session["rol"] = lista[1].nombre;
                Session["nombreUsuario"] = usuarioLogeado.nombres + usuarioLogeado.primerApellido;
                Session["correoUsuario"] = usuarioLogeado.correo;
                Response.Redirect(lista[1].nombre == "Administrador"
                                  ? "../PantallaInicio/AdminInicio.aspx"
                                  : "../PantallaInicio/SquirLearnInicio.aspx");
            }
            else
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Usuario o contraseña incorrectos');", true);
            }


        }

        protected void btnRegistro_Click(object sender, EventArgs e)
        {
            Response.Redirect("LoginRegistro.aspx");
           
        }

       
    }
}