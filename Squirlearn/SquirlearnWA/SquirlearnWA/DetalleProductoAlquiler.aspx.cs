using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class DetalleProductoAlquiler : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                var producto = Session["ProductoSeleccionado"];

                if (producto != null)
                {
                    dynamic p = producto;

                    // Mostrar datos comunes
                    lblNombre.Text = p.Nombre;
                    lblPrecio.Text = $"S/.+ {Convert.ToDecimal(p.Precio.Replace("S/","").Trim(),System.Globalization.CultureInfo.InvariantCulture).ToString("F2")} / día";
                    lblDescripcion.Text = p.Descripcion;
                    imgProducto.ImageUrl = p.ImagenUrl;

                   
                    // Detectar tipo para personalizar texto
                    string tipo = p.Tipo ?? "Producto";

                    if (tipo == "Libro")
                    {
                        lblTipo.Text = "Tipo: Alquiler de Libro";
                        lblPeriodo.Text = "Periodo máximo: 7 días";
                    }
                    else if (tipo == "Instrumento")
                    {
                        lblTipo.Text = "Tipo: Alquiler de Instrumento";
                        lblPeriodo.Text = "Periodo máximo: 12 días";
                    }
                    else
                    {
                        lblTipo.Text = "Tipo: Alquiler general";
                        lblPeriodo.Text = "Periodo máximo: 10 días";
                    }
                }
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            // Regresa a la lista de instrumentos (modo alquiler)
            Response.Redirect("Instrumentos.aspx");
        }

        protected void btnAlquilar_Click(object sender, EventArgs e)
        {
            // Redirige al flujo de alquiler detallado
            Response.Redirect("DetalleAlquiler.aspx");
        }
    }
}