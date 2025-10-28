using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


using System;
using System.Web.UI;

namespace SquirlearnWA
{
    public partial class DetalleCompra : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleProductoCompra.aspx");
        }

        protected void btnConfirmar_Click(object sender, EventArgs e)
        {
            // Redirige a la pantalla de carga antes de confirmar
            Response.Redirect("QuillaTip.aspx");
        }
    }
}