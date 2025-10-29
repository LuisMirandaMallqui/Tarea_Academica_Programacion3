using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ListadoDeSolicitudesAdmin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarSolicitudes();
            }

        }
        private void CargarSolicitudes()
        {
            /*
            PedidoBO pedidoBO = new PedidoBO();
            List<Pedido> solicitudes = pedidoBO.ListarSolicitudesPendientes();

            rptSolicitudes.DataSource = solicitudes;
            rptSolicitudes.DataBind();
            */
            var solicitudes = new List<dynamic>
            {
                new { IdSolicitud = 1, VendedorNombre = "Pedro Enrique de Paul",FechaSolicitud = new DateTime(2025, 10, 25) },
                new { IdSolicitud = 2, VendedorNombre = "Gabriela del Solar",FechaSolicitud = new DateTime(2025, 10, 25) },
                new { IdSolicitud = 3, VendedorNombre = "Carlos Méndez",FechaSolicitud = new DateTime(2025, 10, 25) },
                new { IdSolicitud = 4, VendedorNombre = "Lucía Fernández",FechaSolicitud = new DateTime(2025, 10, 25) },
                new { IdSolicitud = 5, VendedorNombre = "José Ramírez",FechaSolicitud = new DateTime(2025, 10, 25) }
            };

            rptSolicitudes.DataSource = solicitudes;
            rptSolicitudes.DataBind();
        }
    }
}