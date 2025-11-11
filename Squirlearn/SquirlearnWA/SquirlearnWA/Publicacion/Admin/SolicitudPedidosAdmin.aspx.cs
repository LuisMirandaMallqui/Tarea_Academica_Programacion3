using SoftInvBusiness;
using SquirLearnBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class SolicitudPedidosAdmin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarPedido();
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListadoDeSolicitudesAdmin.aspx");
        }
        private void CargarPedido()
        {
            /*
            int idPedido = Convert.ToInt32(Request.QueryString["id"]);
            PedidoBO pedidoBO = new PedidoBO();
            var pedido = pedidoBO.ObtenerPedidoPorId(idPedido);

            // Enlazar el pedido directamente al FormView
            fvPedido.DataSource = new[] { pedido };
            fvPedido.DataBind();
            */
            /*
            var pedido = new
            {
                
                VendedorNombre = "Gabriela del Solar",
                Descripcion = "lapiceros de colores de buena calidad",
                //FechaSolicitud = new DateTime(2025, 10, 25),
                Stock = 69,
                ImagenURL = "",
                NombreProducto="Lapiceros de colores",
                PrecioUnitario=30.00,
                TipoPublicacion="Alquiler",
                PeriodoTiempo=15
            };

            */

            // 1️⃣ Obtener el ID de la publicación desde la URL
            int idPublicacion = Convert.ToInt32(Request.QueryString["id"]);

            // 2️⃣ Llamar al backend (BO → SOAP)
            PublicacionBO bo = new PublicacionBO();
            var publicacion = bo.ObtenerPorId(idPublicacion);

            // 3️⃣ También obtener el nombre del usuario si solo tienes su ID
            BuscarPersonaBO usuarioBO = new BuscarPersonaBO();
            PersonaDto persona = usuarioBO.BuscarPersonaPorId(publicacion.UsuarioId, idPublicacion);
            publicacion.NombreVendedor = persona.Nombre;

            // Guardar los IDs en la sesión
            Session["IdPublicacion"] = publicacion.IdPublicacion;
            Session["IdPersona"] = persona.Id;

            // 4️⃣ Enlazar los datos al FormView
            fvPedido.DataSource = new[] { publicacion };
            fvPedido.DataBind();
        }
    }
}