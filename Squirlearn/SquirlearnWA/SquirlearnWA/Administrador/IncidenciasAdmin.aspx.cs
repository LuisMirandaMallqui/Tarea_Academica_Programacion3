using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class IncidenciasAdmin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                var incidencias = new List<dynamic>
                {
                    new { ID = 23, Descripcion = "Retraso en entrega de pedido", Estado = "Pendiente" },
                    new { ID = 14, Descripcion = "Error en el cobro", Estado = "Resuelta" }
                };

                rptIncidencias.DataSource = incidencias;
                rptIncidencias.DataBind();
            }

        }
    }
}