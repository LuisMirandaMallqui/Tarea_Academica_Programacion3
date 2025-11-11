using SoftInvBusiness;
using SquirLearnBusiness;
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
        private FiltroPorCategoriaBO filtroPorCategoriaBO = new FiltroPorCategoriaBO();
        private const int RegistrosPorPagina = 5;
        // 🟦 Propiedades limpias con ViewState
        private List<PublicacionDTO> ListaLibros
        {
            get => ViewState["ListaLibros"] as List<PublicacionDTO>;
            set => ViewState["ListaLibros"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }

        private string CategoriaActual
        {
            get => ViewState["CategoriaActual"]?.ToString() ?? "Compra";
            set => ViewState["CategoriaActual"] = value;
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                //CargarLibros("Compra");

                // Mostrar por defecto la categoría "Compra"
                ViewState["CategoriaActual"] = "Compra";
                lblCategoria.InnerText = "(Compra)";
                ViewState["PaginaActual"] = 0;
                CargarLibros("Compra");
            }
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            CategoriaActual = "Compra";
            PaginaActual = 0;
            lblCategoria.InnerText = "(Compra)";
            CargarLibros("Compra");
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            CategoriaActual = "Alquiler";
            PaginaActual = 0;
            lblCategoria.InnerText = "(Alquiler)";
            CargarLibros("Alquiler");
        }
        //SIMULACION
        /*
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
        */
        private void CargarLibros(string tipo)
        {
            string palabra = txtBusqueda.Text.Trim();
            string condicion = ddlCondicion.SelectedValue;
            string subcategoria = ddlSubcategoria.SelectedValue;
            string tamano = null;
            string color = null;

            List<PublicacionDTO> lista = filtroPorCategoriaBO.FiltrarPorCategoria(
                categoria: "Libros",
                 tipo:tipo,
                palabraClave: palabra,
                condicion: condicion,
                subcategoria: subcategoria,
                tamano:tamano,
                color:color

            );

            if (lista != null && lista.Count > 0)
            {
                ListaLibros = lista;
                lblTotalResultados.Text = $"Se encontraron {lista.Count} resultados.";
                MostrarPagina();
            }
            else
            {
                rptLibros.DataSource = null;
                rptLibros.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No se encontraron libros con los filtros seleccionados.";
            }
        }
        /*
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
        */


        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            PaginaActual = 0;
            CargarLibros(CategoriaActual);
        }

        protected void rptLibros_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string[] datos = e.CommandArgument.ToString().Split('|');

                if (datos.Length >= 9)
                {
                    Session.Remove("ProductoSeleccionado");
                    Session["ProductoSeleccionado"] = new
                    {
                        IdVendedor = datos[0],
                        ImagenUrl = datos[1],
                        Titulo = datos[2],
                        Subcategoria = datos[3],
                        Precio = datos[4],
                        Descripcion = datos[5],
                        EstadoProducto = datos[6],
                        Periodo = datos[7],
                        IdPublicacion = datos[8],
                        Tipo = CategoriaActual
                    };

                    Session["PaginaAnterior"] = "Libros.aspx";
                    string url = CategoriaActual == "Compra"
                        ? "DetalleProductoCompra.aspx"
                        : "DetalleAlquiler.aspx";

                    Response.Redirect(url);
                }
            }
        }

        private void MostrarPagina()
        {
            if (ListaLibros == null || ListaLibros.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaLibros.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaLibros.Count);

            var pagina = ListaLibros.GetRange(inicio, fin - inicio);

            rptLibros.DataSource = pagina;
            rptLibros.DataBind();

            lblPagina.Text = $"Página {PaginaActual + 1} de {totalPaginas}";
            btnAnterior.Enabled = PaginaActual > 0;
            btnSiguiente.Enabled = PaginaActual < totalPaginas - 1;
            lblSinResultados.Text = "";
        }
        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 0)
            {
                PaginaActual--;
                MostrarPagina();
            }
        }
        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            int totalPaginas = (int)Math.Ceiling((double)ListaLibros.Count / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                MostrarPagina();
            }
        }
    }
}
