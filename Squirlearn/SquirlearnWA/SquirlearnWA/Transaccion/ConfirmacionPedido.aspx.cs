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
            if (!IsPostBack)
            {
                if (Session["PagoError"] != null)
                {
                    // Mostrar el mensaje de error
                    lblError.Text = Session["PagoError"].ToString();
                    pnlError.Visible = true;

                    // Ocultar la parte de éxito
                    divExito.Visible = false;

                    // Limpiar la sesión para que no se repita el error
                    Session.Remove("PagoError");
                }
                else
                {
                    // No hay error: mostrar solo el éxito
                    pnlError.Visible = false;
                    divExito.Visible = true;
                     lblNombre.Text = Session["ProductoNombre"].ToString();
                     lblDescripcion.Text = Session["ProductoDescripcion"].ToString();
                     lblTotal.Text = Session["TotalCompra"].ToString();
                    bool esAlquiler = (bool)Session["EsAlquiler"];

                    if (esAlquiler)
                    {
                        string dias = Session["DiasAlquiler"].ToString();
                        lblTipoOperacion.Text = $"Alquiler por {dias} días";
                    }
                    else
                    {
                        lblTipoOperacion.Text = "Compra única";
                    }
                }
            }

          
            
            
            
        }

        protected void btnVolverInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PantallaInicio/SquirLearnInicio.aspx");
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
            Response.Redirect("../PantallaInicio/Chat.aspx?chatId=" + chatId);
        }

        protected void Button3_Click(object sender, EventArgs e)
        {

        }

        protected void Button3_Click1(object sender, EventArgs e)
        {
            string origen= Request.QueryString["origen"];
            Response.Redirect(origen);
        }
    }
}