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
            if (!IsPostBack && Session["ProductoSeleccionado"] != null)
            {
                dynamic producto = Session["ProductoSeleccionado"];

                lblNombreProducto.Text = producto.Nombre;
                lblDescripcion.Text = producto.Descripcion;
                lblPrecio.Text = "s/. " + producto.Precio; 
                imgProducto.ImageUrl = producto.ImagenUrl;

                // Limpia texto y convierte
                string precioTexto = producto.Precio
                    .Replace("S/", "")
                    .Replace("s/.", "")
                    .Replace("s/ ", "")
                    .Trim();



                // Cálculo inicial sin envío
                decimal precio = Convert.ToDecimal(precioTexto, CultureInfo.InvariantCulture);
                decimal ahorro = 0.00M;
                decimal total = precio - ahorro;

                lblSubtotal.Text = precio.ToString("0.00");
                lblAhorro.Text = ahorro.ToString("0.00");
                lblTotal.InnerText = "S/ " + total.ToString("0.00");
                Session["TotalCompra"] = total;
                Session["ProductoNombre"] = producto.Nombre;
                Session["ProductoDescripcion"] = producto.Descripcion;
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
                Session["TotalCompra"] =total;
            }
        }

        protected void btnConfirmar_Click(object sender, EventArgs e)
        {
            string metodo = "";
            
            if (rdbTarjeta.Checked)
                metodo = "tarjeta";
            else if (rdbYape.Checked)
                metodo = "yape";
            string nombrePagina = System.IO.Path.GetFileName(Request.Url.AbsolutePath);
            // Si es compra:
            Session["EsAlquiler"] = false;
            Response.Redirect("ModalPago.aspx?metodo=" + metodo + "&origen=" + nombrePagina);

           
            

            
            

            //Response.Redirect("QuillaTip.aspx");
        }
    }
}
