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
    public partial class Otros : Page
    {
        private FiltroPorCategoriaBO filtroPorCategoriaBO = new FiltroPorCategoriaBO();
        private const int RegistrosPorPagina = 5;

        private List<PublicacionDTO> ListaCursos
        {
            get => ViewState["ListaCursos"] as List<PublicacionDTO>;
            set => ViewState["ListaCursos"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                PaginaActual = 0;
                CargarOtros();
            }
        }


        //SIMULACION
        /*
        private void CargarOtros()
        {
            listaOtros = new List<dynamic>
            {
                new { Nombre = "Mochila universitaria", Descripcion = "Color negro, espaciosa y resistente.", Precio = 45.00, Condicion = "Nuevo", Tamano = "Grande", Color = "Negro", Subcategoria = "Mochila", ImagenUrl = "../Imagenes/productoGeneral.png" },
                new { Nombre = "Estuche de lápices", Descripcion = "Color azul con cierre reforzado.", Precio = 15.00, Condicion = "Nuevo", Tamano = "Chico", Color = "Azul", Subcategoria = "Estuche", ImagenUrl = "../Imagenes/productoGeneral.png" },
                new { Nombre = "Set de material de escritorio", Descripcion = "Incluye plumones, tijeras, regla y más.", Precio = 20.00, Condicion = "Seminuevo", Tamano = "Mediano", Color = "Rojo", Subcategoria = "Material de escritorio", ImagenUrl = "../Imagenes/productoGeneral.png" },
                new { Nombre = "Polo institucional PUCP", Descripcion = "Ropa deportiva para actividades universitarias.", Precio = 35.00, Condicion = "Nuevo", Tamano = "Mediano", Color = "Blanco", Subcategoria = "Ropa", ImagenUrl = "../Imagenes/productoGeneral.png" }
            };

            rptOtros.DataSource = listaOtros;
            rptOtros.DataBind();
        }
        */
        private void CargarOtros()
        {
            string palabra = txtBusqueda.Text.Trim();
            string condicion = ddlCondicion.SelectedValue;
            string subcategoria = ddlSubcategoria.SelectedValue;

            string tamano= ddlTamano.SelectedValue;
            string color= ddlColor.SelectedValue;


            List<PublicacionDTO> lista = filtroPorCategoriaBO.FiltrarPorCategoria(
                categoria: "Cursos",
                tipo: "Compra",
                palabraClave: palabra,
                condicion: condicion,
                subcategoria: subcategoria,
                tamano:tamano,
                color:color
            );

            if (lista != null && lista.Count > 0)
            {
                ListaCursos = lista;
                lblTotalResultados.Text = $"Se encontraron {lista.Count} resultados.";
                lblSinResultados.Text = "";
                MostrarPagina();
            }
            else
            {
                rptOtros.DataSource = null;
                rptOtros.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No se encontraron cursos con los filtros seleccionados.";
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            PaginaActual = 0;
            CargarOtros();
        }

        protected void rptOtros_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string[] datos = e.CommandArgument.ToString().Split('|');

                if (datos.Length >= 4)
                {
                    Session["ProductoSeleccionado"] = new
                    {
                        Nombre = datos[0],
                        Descripcion = datos[1],
                        Precio = datos[2],
                        ImagenUrl = datos[3],
                        Tipo = "Accesorio"
                    };

                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }
        private void MostrarPagina()
        {
            if (ListaCursos == null || ListaCursos.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaCursos.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaCursos.Count);

            var pagina = ListaCursos.GetRange(inicio, fin - inicio);

            rptOtros.DataSource = pagina;
            rptOtros.DataBind();

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
            int totalPaginas = (int)Math.Ceiling((double)ListaCursos.Count / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                MostrarPagina();
            }
        }

        protected void rptCursos_ItemCommand(object source, RepeaterCommandEventArgs e)
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
                        Tipo = "Compra"
                    };

                    Session["PaginaAnterior"] = "Cursos.aspx";
                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }

    }
}