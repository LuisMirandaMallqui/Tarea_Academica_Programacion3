using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.LogIn
{
    public partial class Registro : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            string nombre= txtNombre.Text.Trim();
            string primerApellido= txtApellido.Text.Trim();
            string segundoApellido = txtApellido.Text.Trim();
            string email= txtEmail.Text.Trim();
            string codigo= txtCodigo.Text.Trim();
            string contraseña1= txtContraseña.Text.Trim();
            string contraseña2= txtConfirmarContraseña.Text.Trim();

            if (contraseña1 == contraseña2)
            {
                // Aquí iría la lógica para guardar el usuario en la base de datos
                //primero validamos si la persona existe en PUCP con el código y correo
                //luego validamos si ya está registrado en Squirlearn
                //si todo está bien, guardamos el usuario
                //solo usamos el método para registrar el usuario y de  ahí el BO que se encarge
                int resultado = RegistrarUsuario(nombres, primerApellido, segundoApellido, codigo, correo, contraseña, nombre+primerApellido,DateTime.Now());

                if (!chkTerminos.Checked)
                {
                    lblError.Text = "Debe aceptar los términos y condiciones.";
                    return;
                }
                else if(resultado == 0)
                {
                    lblError.Text = "El usuario ya está registrado o no pertenece a la comunidad PUCP";
                }
                else
                {
                    lblError.Text = "";
                    Response.Redirect("~/LoginInicio.aspx");
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