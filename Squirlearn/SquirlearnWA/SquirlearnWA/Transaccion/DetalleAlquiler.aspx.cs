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
    public partial class DetalleAlquiler : Page
    {
        private PublicacionClient publicacionSoap;
        
        public DetalleAlquiler()
        {
            publicacionSoap = new PublicacionClient(); 
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                publicacionDto publicacion = publicacionSoap.obtenerPorIdPublicacion((int)Session["ProductoSeleccionado"]);
                if (publicacion != null)
                {
                    itemDto item = publicacion.item;

                    lblNombre.Text = item.nombre;
                    lblDescripcion.Text = item.descripcion;
                    lblPrecioDia.Text = $"Precio por día: s/. {item.precio} / día";
                    imgProducto.ImageUrl = "https://via.placeholder.com/250";
                    lblVendedor.Text = publicacion.persona.nombres;

                    string precioTexto = $"S/ {item.precio:F2}"; 

                    // Guardar el precio en ViewState
                    ViewState["PrecioDia"] = Convert.ToDouble(precioTexto, CultureInfo.InvariantCulture);

                    // Cálculo inicial
                    double precio = Convert.ToDouble(precioTexto, CultureInfo.InvariantCulture);
                    lblSubtotal.Text = precio.ToString("0.00");
                    lblTotal.InnerText = $"s/. {precio:0.00}";
                    Session["ProductoNombre"] = item.nombre;
                    Session["ProductoDescripcion"] = item.descripcion;
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


        // Cálculo del total según días y descuentos
        private void ActualizarTotal()
        {
            double precioDia = ViewState["PrecioDia"] != null ? (double)ViewState["PrecioDia"] : 0.0;
            int dias = int.Parse(lblDias.Text);

            double subtotal = precioDia * dias;


            double total = subtotal ;

            lblSubtotal.Text = subtotal.ToString("0.00");
            lblTotal.InnerText = $"S/ {total:0.00}";
            Session["DiasAlquiler"] = lblDias.Text;
            Session["TotalCompra"] = total;
        }

        // Botón "Realizar pedido"
        protected void btnAlquilar_Click(object sender, EventArgs e)
        {

            //TERMINOS Y CONDICIONES
            if (!chkAceptar.Checked)
            {
                lblErrorTerminos.Visible = true;
                return;
            }

            lblErrorTerminos.Visible = false;




            string metodo = "";

            if (rdbTarjeta.Checked)
                metodo = "tarjeta";
            else if (rdbYape.Checked)
                metodo = "yape";

           
            

            // Datos adicionales del alquiler
            
            Session["EsAlquiler"] = true;

            string nombrePagina = System.IO.Path.GetFileName(Request.Url.AbsolutePath);
            Response.Redirect("ModalPago.aspx?metodo=" + metodo + "&origen=" + nombrePagina);

            //Session["TotalAlquiler"] = lblTotal.InnerText;
            //Response.Redirect("QuillaTip.aspx");
        }
    }
}
