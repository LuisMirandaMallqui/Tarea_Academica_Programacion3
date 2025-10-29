using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Promociones : Page
    {
        private List<dynamic> promociones;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
                CargarPromociones();
        }

        private void CargarPromociones()
        {
            promociones = new List<dynamic>
            {
                new { Nombre = "Libro de Cálculo - Edición Limitada", Descripcion = "Incluye guía de ejercicios", Tipo = "Libro", PrecioOriginal = 80.00, Descuento = 20, PrecioFinal = 64.00, ImagenUrl = "../Imagenes/libros.png" },
                new { Nombre = "Multímetro Digital", Descripcion = "Alta precisión y resistencia", Tipo = "Instrumento", PrecioOriginal = 25.00, Descuento = 10, PrecioFinal = 22.50, ImagenUrl = "../Imagenes/instrumentos.png" },
                new { Nombre = "Clase Grabada de Física I", Descripcion = "Conceptos esenciales explicados paso a paso", Tipo = "Clase", PrecioOriginal = 40.00, Descuento = 30, PrecioFinal = 28.00, ImagenUrl = "../Imagenes/clases.png" },
                new { Nombre = "Apuntes de Programación C++", Descripcion = "Resumen práctico y estructurado", Tipo = "Apunte", PrecioOriginal = 18.00, Descuento = 15, PrecioFinal = 15.30, ImagenUrl = "../Imagenes/apuntes.png" }
            };

            rptPromociones.DataSource = promociones;
            rptPromociones.DataBind();
        }

        protected void rptPromociones_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string[] datos = e.CommandArgument.ToString().Split('|');
                if (datos.Length >= 5)
                {
                    Session["ProductoSeleccionado"] = new
                    {
                        Nombre = datos[0],
                        Descripcion = datos[1],
                        Precio = datos[2],
                        ImagenUrl = datos[3],
                        Tipo = datos[4]
                    };

                    // Todas las promociones se tratan como "compra"
                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string texto = txtBusqueda.Text.Trim().ToLower();
            string tipo = ddlTipo.SelectedValue;

            var filtrados = new List<dynamic>();
            foreach (dynamic promo in promociones)
            {
                bool cumple = true;
                if (!string.IsNullOrEmpty(texto) && !promo.Nombre.ToLower().Contains(texto))
                    cumple = false;
                if (!string.IsNullOrEmpty(tipo) && promo.Tipo != tipo)
                    cumple = false;

                if (cumple)
                    filtrados.Add(promo);
            }

            rptPromociones.DataSource = filtrados;
            rptPromociones.DataBind();
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }
    }
}