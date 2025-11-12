using SquirlearnWA.publicacionSOAP;
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

        private PublicacionClient publicacionSoap;

        public DetalleCompra()
        {
            publicacionSoap = new PublicacionClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack && Session["ProductoSeleccionado"] != null)
            {
                publicacionDto publicacion = publicacionSoap.obtenerPorIdPublicacion((int)Session["ProductoSeleccionado"]);

                itemDto item = publicacion.item;

                lblNombreProducto.Text = item.nombre;
                lblDescripcion.Text = item.descripcion;
                lblPrecio.Text = "s/. " + item.precio; 
                imgProducto.ImageUrl = "https://via.placeholder.com/250";
                lblVendedor.Text = publicacion.persona.nombres;

                // Limpia texto y convierte
                string precioTexto = $"S/ {item.precio:F2}";



                // Cálculo inicial sin envío
                decimal precio = Convert.ToDecimal(precioTexto, CultureInfo.InvariantCulture);
                decimal ahorro = 0.00M;
                decimal total = precio - ahorro;

                lblSubtotal.Text = precio.ToString("0.00");
                lblAhorro.Text = ahorro.ToString("0.00");
                lblTotal.InnerText = "S/ " + total.ToString("0.00");
                Session["TotalCompra"] = total;
                Session["ProductoNombre"] = item.nombre;
                Session["ProductoDescripcion"] = item.descripcion;
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
            string nombrePagina = System.IO.Path.GetFileName(Request.Url.AbsolutePath);
            // Si es compra:
            Session["EsAlquiler"] = false;
            Response.Redirect("ModalPago.aspx?metodo=" + metodo + "&origen=" + nombrePagina);

            //Response.Redirect("QuillaTip.aspx");
        }
    }
}
