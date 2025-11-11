using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.Transaccion
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
                    //aqui obtenemos por ID el producto de la base de datos
                    //producto = obtener por ID(productoID); jala todos los campos 
                    lblNombre.Text = p.Nombre;
                    lblDescripcion.Text = p.Descripcion;
                    lblVendedor.Text = p.Vendedor ?? "Vendedor no especificado";
                    lblPrecio.Text = $"s/. {p.Precio:0.00}";
                    lblCategoria.Text = p.Categoria?.Nombre ?? "-";
                    lblSubcategoria.Text = p.Subcategoria?.Nombre ?? "-";
                    lblColor.Text = p.Color?.Nombre ?? "-";
                    lblEstado.Text = p.EstadoItem?.Nombre ?? "-";
                    lblCondicion.Text = p.Condicion?.Nombre ?? "-";
                    lblTamano.Text = p.Tamano?.Nombre ?? "-";
                    lblFormato.Text = p.Formato?.Nombre ?? "-";
                    lblTipo.Text = p.EsVenta ? "Venta" : "Alquiler";

                    imgProducto.ImageUrl = p.ImagenUrl ?? "https://via.placeholder.com/250";

                    // Guardamos tipo y precio, falta solucionar este campo :C, hay problemas con la sección de fechas
                    bool esVenta = true;
                    ViewState["EsVenta"] = esVenta; // esto podemos camviarlo por un dto del producto
                    ViewState["Precio"] = Convert.ToDouble(p.Precio);

                    if (esVenta)
                    {
                        // Si es venta, ocultar fechas
                        pnlFechas.Visible = false;
                        lblSubtotal.Text = p.Precio.ToString("0.00");
                        lblTotal.InnerText = $"s/. {p.Precio:0.00}";
                    }
                    else
                    {
                        // Si es alquiler, mostrar fechas
                        pnlFechas.Visible = true;
                        lblSubtotal.Text = "0.00";
                        lblTotal.InnerText = "s/. 0.00";
                    }
                }
            }

        }

        // Botón "Volver"
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("../Principal/SquirLearnInicio.aspx");

        }


        // Botón "Transaccionar pedido"
        protected void btnTransaccionar_Click(object sender, EventArgs e)
        {


            bool esVenta = ViewState["EsVenta"] != null && (bool)ViewState["EsVenta"];
            double precio = ViewState["Precio"] != null ? (double)ViewState["Precio"] : 0.0;

            if (!esVenta)
            {
                // Validar fechas
                if (string.IsNullOrEmpty(txtFechaInicio.Text) || string.IsNullOrEmpty(txtFechaFin.Text))
                {
                    lblErrorTerminos.Text = "Debe seleccionar el periodo de alquiler.";
                    lblErrorTerminos.Visible = true;
                    return;
                }

                DateTime inicio = DateTime.Parse(txtFechaInicio.Text);
                DateTime fin = DateTime.Parse(txtFechaFin.Text);
                int dias = (fin - inicio).Days;

                if (dias <= 0 || dias > 14)
                {
                    lblErrorTerminos.Text = "El periodo debe ser de 1 a 14 días.";
                    lblErrorTerminos.Visible = true;
                    return;
                }

                // Validar términos y condiciones
                if (!chkAceptar.Checked)
                {
                    lblErrorTerminos.Text = "Debe aceptar los términos y condiciones antes de continuar.";
                    lblErrorTerminos.Visible = true;
                    return;
                }

                lblErrorTerminos.Visible = false;

                // Calcular total
                double subtotal = precio * dias;
                double total = subtotal - descuentoFijo;
                if (total < 0) total = 0;

                lblSubtotal.Text = subtotal.ToString("0.00");
                lblTotal.InnerText = $"s/. {total:0.00}";

                //estas lineas pueden acortarse con el producto DTO
                Session["TotalCompra"] = total;
                Session["DiasAlquiler"] = dias;
                Session["EsAlquiler"] = true;
            }
            else
            {
                // Venta directa
                if (!chkAceptar.Checked)
                {
                    lblErrorTerminos.Text = "Debe aceptar los términos antes de continuar.";
                    lblErrorTerminos.Visible = true;
                    return;
                }

                lblErrorTerminos.Visible = false;
                Session["TotalCompra"] = precio;
                Session["EsAlquiler"] = false;
            }

            // Detectar método de pago, para esto se le debe pasar el monto total 
            string metodo = rdbTarjeta.Checked ? "tarjeta" :
                            rdbYape.Checked ? "yape" : "ninguno";

            string nombrePagina = System.IO.Path.GetFileName(Request.Url.AbsolutePath);
            Response.Redirect("ModalPago.aspx?metodo=" + metodo + "&origen=" + nombrePagina);
        }


    }
}
