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
    public partial class Instrumentos : Page
    {
        private FiltroPorCategoriaBO filtroPorCategoriaBO = new FiltroPorCategoriaBO();
        private const int RegistrosPorPagina = 5;
        private List<PublicacionDTO> ListaInstrumentos
        {
            get => ViewState["ListaInstrumentos"] as List<PublicacionDTO>;
            set => ViewState["ListaInstrumentos"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            // if (!IsPostBack)
            //    CargarInstrumentos("Compra");
            if (!IsPostBack)
            {
                CategoriaActual = "Compra";
                lblCategoria.InnerText = "(Compra)";
                PaginaActual = 0;
                CargarInstrumentos("Compra");
            }

        }
        private string CategoriaActual
        {
            get => ViewState["CategoriaActual"]?.ToString() ?? "Compra";
            set => ViewState["CategoriaActual"] = value;
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            CategoriaActual = "Compra";
            PaginaActual = 0;
            lblCategoria.InnerText = "(Compra)";
            CargarInstrumentos("Compra");
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            CategoriaActual = "Alquiler";
            PaginaActual = 0;
            lblCategoria.InnerText = "(Alquiler)";
            CargarInstrumentos("Alquiler");
        }
        //SIMULACION
        /*
        private void CargarInstrumentos(string categoria)
        {
            lblCategoria.InnerText = categoria.ToUpper();

            var instrumentos = new List<dynamic>();

            if (categoria == "Compra")
            {
                instrumentos = new List<dynamic>
                {
                    new { Nombre = "Calculadora fx-1500", Descripcion = "Calculadora científica modelo fx-350 PLUS", Precio = 30.50, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Multímetro digital", Descripcion = "Ideal para prácticas de electrónica y física", Precio = 25.00, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Regla metálica 30cm", Descripcion = "Alta precisión, aluminio anodizado", Precio = 10.00, ImagenUrl = "../Imagenes/instrumentos.png" }
                };
            }
            else
            {
                instrumentos = new List<dynamic>
                {
                    new { Nombre = "Calculadora fx-1500", Descripcion = "Alquila la fx-350 PLUS por días o semanas", Precio = 2.00, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Multímetro digital", Descripcion = "Alquiler para prácticas de laboratorio", Precio = 2.00, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Regla metálica 30cm", Descripcion = "Alquiler por semana - aluminio anodizado", Precio = 2.00, ImagenUrl = "../Imagenes/instrumentos.png" }
                };
            }

            ViewState["CategoriaActual"] = categoria;
            rptInstrumentos.DataSource = instrumentos;
            rptInstrumentos.DataBind();
        }
        */
        private void CargarInstrumentos(string tipo)
        {
            string palabra = txtBusqueda.Text.Trim();
            string condicion = ddlCondicion.SelectedValue;
            string subcategoria = ddlSubcategoria.SelectedValue;
            string tamano = null;
            string color = null;

            List<PublicacionDTO> lista = filtroPorCategoriaBO.FiltrarPorCategoria(
                categoria: "Instrumentos",
                tipo: tipo,
                palabraClave: palabra,
                condicion: condicion,
                subcategoria: subcategoria,
                tamano:tamano,
                color:color

            );

            if (lista != null && lista.Count > 0)
            {
                ListaInstrumentos = lista;
                lblTotalResultados.Text = $"Se encontraron {lista.Count} resultados.";
                MostrarPagina();
            }
            else
            {
                rptInstrumentos.DataSource = null;
                rptInstrumentos.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No se encontraron instrumentos con los filtros seleccionados.";
            }
        }
        private void MostrarPagina()
        {
            if (ListaInstrumentos == null || ListaInstrumentos.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaInstrumentos.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaInstrumentos.Count);

            var pagina = ListaInstrumentos.GetRange(inicio, fin - inicio);

            rptInstrumentos.DataSource = pagina;
            rptInstrumentos.DataBind();

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
            int totalPaginas = (int)Math.Ceiling((double)ListaInstrumentos.Count / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                MostrarPagina();
            }
        }

        protected void rptInstrumentos_ItemCommand(object source, RepeaterCommandEventArgs e)
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

                    Session["PaginaAnterior"] = "Instrumentos.aspx";
                    string url = CategoriaActual == "Compra"
                        ? "DetalleProductoCompra.aspx"
                        : "DetalleAlquiler.aspx";

                    Response.Redirect(url);
                }
            }
        }


        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            PaginaActual = 0;
            CargarInstrumentos(CategoriaActual);
        }








    }


}
