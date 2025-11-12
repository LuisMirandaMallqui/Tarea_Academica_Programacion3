using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ReestablecerContraseña : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnRestablecer_Click(object sender, EventArgs e)
        {
            // Aquí puedes manejar el envío del correo de restablecimiento
            // Ejemplo:
            // EnviarCorreoRecuperacion(txtCorreo.Text);

            // Llama al script JS para mostrar el modal
            ScriptManager.RegisterStartupScript(this, GetType(), "modal", "mostrarModal();", true);
        }



        protected void btnContinuar_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PerfilUsusario/Perfil.aspx");
        }

        protected void btnVolver_Click3(object sender, EventArgs e)
        {
            Response.Redirect("../PerfilUsuario/Perfil.aspx");
        }
    }
}