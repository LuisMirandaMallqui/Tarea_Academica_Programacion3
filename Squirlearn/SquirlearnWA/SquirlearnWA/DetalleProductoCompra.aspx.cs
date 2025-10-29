using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class DetalleProductoCompra : Page
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
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            // Recupera la página anterior desde la sesión
            string paginaAnterior = Session["PaginaAnterior"] != null
                ? Session["PaginaAnterior"].ToString()
                : "SquirLearnInicio.aspx"; // Si no hay nada guardado, va al inicio

            Response.Redirect(paginaAnterior);
        }

        protected void btnComprar_Click(object sender, EventArgs e)
        {
            // Redirige al flujo de compra (donde se hace el cálculo de totales, etc.)
            Response.Redirect("DetalleCompra.aspx");
        }
    }
}