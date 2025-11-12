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


            string usuario = txtUsuario.Text.Trim();
            string contrasena = txtContraseña.Text.Trim();
            
            personaDto personaDto = personaSoap.logInPersona(usuario, contrasena);

            if (personaDto != null)
            {
                // Guardamos en sesión solo lo necesario
                Session["UsuarioId"] = personaDto.personaId;
                IList<rolPersonaDto> lista = personaDto.rolPersona;
                Session["Rol"] = lista[1].nombre;
                Session["NombreUsuario"] = personaDto.nombres + personaDto.primerApellido;
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