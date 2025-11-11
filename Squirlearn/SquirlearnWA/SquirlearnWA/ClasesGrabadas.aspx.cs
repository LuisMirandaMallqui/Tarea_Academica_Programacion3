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
    public partial class ClasesGrabadas : Page
    {
        private FiltroPorCategoriaBO filtroPorCategoriaBO = new FiltroPorCategoriaBO();
        private const int RegistrosPorPagina = 5;

        private List<PublicacionDTO> ListaClases
        {
            get => ViewState["ListaClases"] as List<PublicacionDTO>;
            set => ViewState["ListaClases"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 1;
            set => ViewState["PaginaActual"] = value;
        }

        
        protected void Page_Load(object sender, EventArgs e)
        {
            // if (!IsPostBack)
            //    CargarClases("Compra");
            if (!IsPostBack)
            {
                PaginaActual = 0;
                CargarClases();
            }
        }


        //SIMULACION
        /*
        private void CargarClases(string categoria)
        {
            lblCategoria.InnerText = categoria.ToUpper();

            var clases = new List<dynamic>();

            if (categoria == "Compra")
            {
                clases = new List<dynamic>
                {
                    new { Nombre = "Matemática Básica - 1", Descripcion = "Clases introductorias de matemáticas básicas", Precio = 15.50, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Historia Universal", Descripcion = "3 clases que resumen la I y II Guerra Mundial", Precio = 30.50, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Programación Inicial", Descripcion = "Conceptos básicos de algoritmos", Precio = 20.00, ImagenUrl = "../Imagenes/clases.png" }
                };
            }
            else
            {
                clases = new List<dynamic>
                {
                    new { Nombre = "Matemática Básica - 1", Descripcion = "Alquiler por semana – Matemáticas Básicas", Precio = 5.00, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Historia Universal", Descripcion = "Alquiler por semana – Historia Universal", Precio = 5.00, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Programación Inicial", Descripcion = "Alquiler por semana – Algoritmos básicos", Precio = 5.00, ImagenUrl = "../Imagenes/clases.png" }
                };
            }

            ViewState["CategoriaActual"] = categoria;
            rptClases.DataSource = clases;
            rptClases.DataBind();
        }
        */
        private void CargarClases()
        {
            string palabra = txtBusqueda.Text.Trim();
            string condicion = null; // No aplica aquí
            string subcategoria = ddlSubcategoria.SelectedValue;
            string tamano = null;
            string color = null;

            List<PublicacionDTO> lista = filtroPorCategoriaBO.FiltrarPorCategoria(
                categoria: "Clases Grabadas",
                tipo: "Compra",         // 🔹 Solo compra
                palabraClave: palabra,
                condicion: condicion,
                subcategoria: subcategoria,
                tamano:tamano,
                color:color
            );

            if (lista != null && lista.Count > 0)
            {
                ListaClases = lista;
                lblTotalResultados.Text = $"Se encontraron {lista.Count} resultados.";
                lblSinResultados.Text = "";
                MostrarPagina();
            }
            else
            {
                rptClases.DataSource = null;
                rptClases.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No se encontraron clases grabadas con los filtros seleccionados.";
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            PaginaActual = 0;
            CargarClases();
        }

        protected void rptClases_ItemCommand(object source, RepeaterCommandEventArgs e)
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
                        Tipo = "Compra" // 🔹 Fijo a compra
                    };

                    Session["PaginaAnterior"] = "ClasesGrabadas.aspx";
                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }
        private void MostrarPagina()
        {
            if (ListaClases == null || ListaClases.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaClases.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaClases.Count);

            var pagina = ListaClases.GetRange(inicio, fin - inicio);

            rptClases.DataSource = pagina;
            rptClases.DataBind();

            lblPagina.Text = $"Página {PaginaActual + 1} de {totalPaginas}";
            btnAnterior.Enabled = PaginaActual > 0;
            btnSiguiente.Enabled = PaginaActual < totalPaginas - 1;
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
            int totalPaginas = (int)Math.Ceiling((double)ListaClases.Count / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                MostrarPagina();
            }
        }


    }
}