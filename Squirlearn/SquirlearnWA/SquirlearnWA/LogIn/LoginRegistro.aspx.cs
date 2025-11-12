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
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            string nombre= txtNombre.Text.Trim();
            string apellido= txtApellido.Text.Trim();
            string email= txtEmail.Text.Trim();
            string codigo= txtCodigo.Text.Trim();
            string contraseña1= txtContraseña.Text.Trim();
            string contraseña2= txtConfirmarContraseña.Text.Trim();

            if (contraseña1 == contraseña2)
            {
                // Aquí iría la lógica para guardar el usuario en la base de datos
                // Por ahora, solo redirigimos al login
                if (!chkTerminos.Checked)
                {
                    lblError.Text = "Debes aceptar los términos y condiciones.";
                    return;
                }
                else
                {
                    // Aquí continuarías con el registro si todo está bien
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