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
            string origen= Request.QueryString["origen"];
            // Redirigir automáticamente luego de 3 segundos
            Response.AddHeader("REFRESH", "3;URL=ConfirmacionPedido.aspx?origen=" + Server.UrlEncode(origen));
        }

        
    }
}