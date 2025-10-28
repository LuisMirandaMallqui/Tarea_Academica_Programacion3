using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ConfirmacionPedido : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void btnVolverAtras_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleCompra.aspx");
        }

        protected void btnVolverInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }
    }
}