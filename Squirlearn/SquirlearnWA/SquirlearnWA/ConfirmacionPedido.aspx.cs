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
            // Si se llega a esta página, el pedido ya fue confirmado
            // (Aquí podrías guardar en la BD si aún no lo hiciste)
        }

        protected void btnVolverInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }

        protected void btnIrChat_Click(object sender, EventArgs e)
        {
            // Simulación de creación de chat para este pedido
            string chatId = Guid.NewGuid().ToString();
            string vendedor = Session["VendedorNombre"]?.ToString() ?? "Oscar Ibañez";
            string producto = Session["ProductoNombre"]?.ToString() ?? "Producto Desconocido";

            // Guardar datos en sesión
            Session["ChatActivo"] = chatId;
            Session["VendedorNombre"] = vendedor;
            Session["ProductoNombre"] = producto;

            // Redirigir al chat del pedido
            Response.Redirect("Chat.aspx?chatId=" + chatId);
        }
    }
}