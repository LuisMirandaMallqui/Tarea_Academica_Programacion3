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
    public partial class Cursos : Page
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
                CargarCursos();
            }
        }



        //SIMULACION
        /*
       private void CargarCursos()
       {
           // Datos simulados (luego los reemplazarás con BD)
           var cursos = new List<dynamic>
           {
               new { Nombre = "Programación 2", Descripcion = "Laboratorios y exámenes 2023-1", Precio = 30.50 },
               new { Nombre = "Cálculo Aplicado", Descripcion = "Ejercicios y clases grabadas", Precio = 15.50 },
               new { Nombre = "Historia del Perú", Descripcion = "Contiene lecturas guía", Precio = 10.99 }
           };

           rptCursos.DataSource = cursos;
           rptCursos.DataBind();
       }
        */
        private void CargarCursos()
        {
            string palabra = txtBusqueda.Text.Trim();
            string condicion = null;
            string subcategoria = ddlSubcategoria.SelectedValue;

            string tamano = null;
            string color = null;

            List<PublicacionDTO> lista = filtroPorCategoriaBO.FiltrarPorCategoria(
                categoria: "Cursos",
                tipo: "Compra",
                palabraClave: palabra,
                condicion: condicion,
                subcategoria: subcategoria,
                tamano: tamano,
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
                rptCursos.DataSource = null;
                rptCursos.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No se encontraron cursos con los filtros seleccionados.";
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            // Aquí puedes filtrar la lista
            PaginaActual = 0;
            CargarCursos();
        }
        private void MostrarPagina()
        {
            if (ListaCursos == null || ListaCursos.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaCursos.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaCursos.Count);

            var pagina = ListaCursos.GetRange(inicio, fin - inicio);

            rptCursos.DataSource = pagina;
            rptCursos.DataBind();

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

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            lblCategoria.InnerText = " (Compra)";
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