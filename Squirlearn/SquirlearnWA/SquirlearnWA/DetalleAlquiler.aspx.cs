using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class DetalleAlquiler : Page
    {
        private const double descuentoFijo = 1.50; // Ahorro fijo mostrado en pantalla

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                var producto = Session["ProductoSeleccionado"];
                if (producto != null)
                {
                    dynamic p = producto;
                    string tipo = p.Tipo ?? "Instrumento";

                    lblNombre.Text = p.Nombre;
                    lblDescripcion.Text = p.Descripcion;
                    lblPrecioDia.Text = $"Precio por día: s/. {p.Precio} / día";
                    lblPeriodo.Text = tipo == "Libro"
                        ? "Periodo máximo: 7 días"
                        : "Periodo máximo: 14 días";
                    imgProducto.ImageUrl = p.ImagenUrl;

                    // Guardar el precio en ViewState
                    ViewState["PrecioDia"] = Convert.ToDouble(p.Precio);

                    // Cálculo inicial
                    double precio = Convert.ToDouble(p.Precio);
                    lblSubtotal.Text = precio.ToString("0.00");
                    lblTotal.InnerText = $"s/. {precio:0.00}";
                }

                // 🔹 Aquí va el bloque nuevo
                if (Session["DiasAlquiler"] != null)
                {
                    lblDias.Text = Session["DiasAlquiler"].ToString();
                    Session.Remove("DiasAlquiler"); // limpia la sesión
                    ActualizarTotal(); // recalcula total
                }
            }
        }

        // Botón "Volver"
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Session["DiasAlquiler"] = lblDias.Text;
            Response.Redirect("DetalleProductoAlquiler.aspx");

        }

        // Aumentar días de alquiler
        protected void btnSumar_Click(object sender, EventArgs e)
        {
            int dias = int.Parse(lblDias.Text);
            if (dias < 14)
                dias++;

            lblDias.Text = dias.ToString();
            ActualizarTotal();
        }

        // Disminuir días de alquiler
        protected void btnRestar_Click(object sender, EventArgs e)
        {
            int dias = int.Parse(lblDias.Text);
            if (dias > 1)
                dias--;

            lblDias.Text = dias.ToString();
            ActualizarTotal();
        }

        // Aplicar código promocional
        protected void btnAplicarCodigo_Click(object sender, EventArgs e)
        {
            string codigo = txtCodigoPromo.Text.Trim();

            if (codigo.Equals("SQUIR10", StringComparison.OrdinalIgnoreCase))
                ViewState["DescuentoExtra"] = 0.10; // 10% de descuento
            else
                ViewState["DescuentoExtra"] = 0.0;

            ActualizarTotal();
        }

        // Cálculo del total según días y descuentos
        private void ActualizarTotal()
        {
            double precioDia = ViewState["PrecioDia"] != null ? (double)ViewState["PrecioDia"] : 0.0;
            int dias = int.Parse(lblDias.Text);

            double subtotal = precioDia * dias;
            double descuentoExtra = ViewState["DescuentoExtra"] != null ? (double)ViewState["DescuentoExtra"] : 0.0;

            double ahorroTotal = descuentoFijo + (subtotal * descuentoExtra);
            if (ahorroTotal > subtotal) ahorroTotal = subtotal; // evita negativos

            double total = subtotal - ahorroTotal;

            lblSubtotal.Text = subtotal.ToString("0.00");
            lblTotal.InnerText = $"s/. {total:0.00}";
        }

        // Botón "Realizar pedido"
        protected void btnAlquilar_Click(object sender, EventArgs e)
        {
            Session["TotalAlquiler"] = lblTotal.InnerText;
            Response.Redirect("QuillaTip.aspx");
        }
    }
}
