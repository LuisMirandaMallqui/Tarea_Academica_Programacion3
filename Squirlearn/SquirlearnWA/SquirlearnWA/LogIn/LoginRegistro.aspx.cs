using SquirlearnWA.personaSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Registro : System.Web.UI.Page
    {

        private PersonaClient personaSoap;

        public Registro()
        {
            personaSoap = new PersonaClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            string nombre= txtNombre.Text.Trim();
            string primerApellido= txtPrimerApellido.Text.Trim();
            string segundoApellido = txtSegundoApellido.Text.Trim();
            string correo = txtEmail.Text.Trim();
            string codigo= txtCodigo.Text.Trim();
            string contraseña1= txtContraseña.Text.Trim();
            string contraseña2= txtConfirmarContraseña.Text.Trim();

            if (contraseña1 == contraseña2)
            {
                if (!chkTerminos.Checked)
                {
                    lblError.Text = "Debes aceptar los términos y condiciones.";
                    return;
                }
                else
                {
                    personaSoap.insertarPersona(nombre, primerApellido,segundoApellido, codigo, correo, contraseña1, Session["NombreUsuario"].ToString(), DateTime.Now.Date);
                    lblError.Text = ""; // Limpia el mensaje
                    Response.Redirect("../Login/LoginInicio.aspx");
                }
                   
            }
            else
            {
                // Mostrar mensaje de error
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Las contraseñas no coinciden');", true);
            }
        }
    }
}