using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class DetalleProductoCompra : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("Instrumentos.aspx");
        }

        protected void btnComprar_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleCompra.aspx");
        }
    }
}