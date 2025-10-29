using System;
using System.Collections.Generic;
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
            if (!IsPostBack && Session["ProductoSeleccionado"] != null)
            {
                dynamic producto = Session["ProductoSeleccionado"];

                lblNombreProducto.Text = producto.Nombre;
                lblDescripcion.Text = producto.Descripcion;
                lblPrecio.Text = "s/. " + producto.Precio;
                imgProducto.ImageUrl = producto.ImagenUrl;

                // Cálculo inicial sin envío
                decimal precio = Convert.ToDecimal(producto.Precio);
                decimal ahorro = 0.00M;
                decimal total = precio - ahorro;

                lblSubtotal.Text = precio.ToString("0.00");
                lblAhorro.Text = ahorro.ToString("0.00");
                lblTotal.InnerText = "s/. " + total.ToString("0.00");
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            // Vuelve al listado general
            Response.Redirect("DetalleProductoCompra.aspx");
        }

        protected void btnAplicarCodigo_Click(object sender, EventArgs e)
        {
            if (txtCodigoPromo.Text.Trim().ToUpper() == "SQUIR10")
            {
                decimal subtotal = Convert.ToDecimal(lblSubtotal.Text);
                decimal ahorro = subtotal * 0.10M; // 10% descuento
                decimal total = subtotal - ahorro;

                lblAhorro.Text = ahorro.ToString("0.00");
                lblTotal.InnerText = "s/. " + total.ToString("0.00");
            }
        }

        protected void btnConfirmar_Click(object sender, EventArgs e)
        {
            Session["TotalCompra"] = lblTotal.InnerText;
            Response.Redirect("QuillaTip.aspx");
        }
    }
}
