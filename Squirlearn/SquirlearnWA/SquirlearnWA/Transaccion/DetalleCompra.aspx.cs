using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace SquirlearnWA
{
    public partial class DetalleCompra : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                    lblNombre.Text = Session["nombre"].ToString();
                    lblPrecioDia.Text = $"Precio por día: s/. {Session["precioProducto"].ToString()} / día";
                    imgProducto.ImageUrl = "https://via.placeholder.com/250";// imagen genérica por ahora... :¿


                    string precioTexto = Session["precioProducto"].ToString()
                        .Replace("s/.", "")
                        .Replace("S/.", "")
                        .Replace("s/", "")
                        .Replace("S/", "")
                        .Trim();

                    // Cálculo inicial
                    double precio = Convert.ToDouble(precioTexto, CultureInfo.InvariantCulture);
                    lblSubtotal.Text = precio.ToString("0.00");
                    lblTotal.InnerText = $"s/. {precio:0.00}";
                    Session["montoTotal"] = precio;

            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            // Vuelve al listado general
            Response.Redirect("DetalleProductoCompra.aspx");
        }

        protected void btnConfirmar_Click(object sender, EventArgs e)
        {
            string metodo = "";

            if (rdbTarjeta.Checked)
                metodo = "tarjeta";
            else if (rdbYape.Checked)
                metodo = "yape";

            Session["metodoPago"] = metodo;
            string nombrePagina = System.IO.Path.GetFileName(Request.Url.AbsolutePath);

            Response.Redirect("ModalPago.aspx?metodo=" + metodo + "&origen=" + nombrePagina);

        }
    }
}
