using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace SquirlearnWA
{
    public partial class QuillaTip : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Redirigir automáticamente luego de 3 segundos
            Response.AddHeader("REFRESH", "3;URL=ConfirmacionPedido.aspx");
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleCompra.aspx");
        }
    }
}