using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Instrumentos : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void btnVerDetalle1_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleProductoCompra.aspx");
        }
    }
}