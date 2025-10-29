using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Libros : Page
    {
        //private string categoriaActual = "Compra"; <- Eliminar

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarLibros("Compra");
            }
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            ViewState["CategoriaActual"] = "Compra";
            CargarLibros("Compra");
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            ViewState["CategoriaActual"] = "Alquiler";
            CargarLibros("Alquiler");
        }

        private void CargarLibros(string categoria)
        {
            lblCategoria.InnerText = categoria.ToUpper();

            var libros = new List<dynamic>();

            if (categoria == "Compra")
            {
                libros = new List<dynamic>
                {
                    new { Nombre = "Cálculo de Stewart", Descripcion = "Libro clásico de cálculo universitario", Precio = 80.00, ImagenUrl = "../Imagenes/libros.png" },
                    new { Nombre = "Física Universitaria", Descripcion = "Volumen I – Sears y Zemansky", Precio = 75.00, ImagenUrl = "../Imagenes/libros.png" },
                    new { Nombre = "Álgebra Lineal", Descripcion = "David C. Lay – 5ta edición", Precio = 65.00, ImagenUrl = "../Imagenes/libros.png" }
                };
            }
            else if (categoria == "Alquiler")
            {
                libros = new List<dynamic>
                {
                    new { Nombre = "Cálculo de Stewart", Descripcion = "Disponible para alquiler por semana", Precio = 5.00, ImagenUrl = "../Imagenes/libros.png" },
                    new { Nombre = "Física Universitaria", Descripcion = "Edición de consulta rápida", Precio = 5.00, ImagenUrl = "../Imagenes/libros.png" },
                    new { Nombre = "Álgebra Lineal", Descripcion = "Versión digital por 10 días", Precio = 5.00, ImagenUrl = "../Imagenes/libros.png" } 
                };
            }

            ViewState["CategoriaActual"] = categoria;
            rptLibros.DataSource = libros;
            rptLibros.DataBind();
        }

        protected void rptLibros_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string categoria = ViewState["CategoriaActual"].ToString();

                // Separa los datos enviados desde el CommandArgument
                string[] datos = e.CommandArgument.ToString().Split('|');

                if (datos.Length >= 4)
                {
                    // Limpiar selección anterior
                    Session.Remove("ProductoSeleccionado");

                    // Guardar el libro y el tipo de producto
                    Session["ProductoSeleccionado"] = new
                    {
                        Tipo = "Libro",
                        Nombre = datos[0],
                        Descripcion = datos[1],
                        Precio = datos[2],
                        ImagenUrl = datos[3]
                    };



                    // Guardar la página actual antes de ir al detalle
                    Session["PaginaAnterior"] = "Libros.aspx";

                    // Redirigir según la categoría
                    string url = categoria == "Compra"
                    ? "DetalleProductoCompra.aspx"
                    : "DetalleAlquiler.aspx";


                    Response.Redirect(url);
                }
            }
        }
    }
}
