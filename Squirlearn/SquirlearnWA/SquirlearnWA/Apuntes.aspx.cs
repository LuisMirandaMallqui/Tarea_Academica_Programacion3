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
    public partial class Apuntes : Page
    {
        private readonly FiltroPorCategoriaBO filtroPorCategoriaBO = new FiltroPorCategoriaBO();
        private const int RegistrosPorPagina = 6;

        private List<PublicacionDTO> ListaApuntes
        {
            get => ViewState["ListaApuntes"] as List<PublicacionDTO>;
            set => ViewState["ListaApuntes"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 1;
            set => ViewState["PaginaActual"] = value;
        }

        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                PaginaActual = 0;
                CargarApuntes();
            }

        }

        //SIMULACION
        /*
        private void CargarApuntes()
        {
            var apuntes = new List<dynamic>
            {
                new { Nombre = "Apuntes de Cálculo Aplicado", Descripcion = "Conjunto de fórmulas y anotaciones teóricas", Precio = 15.50, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Química 2", Descripcion = "Incluyen imágenes y ejemplos de laboratorio", Precio = 12.00, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Física 1", Descripcion = "Resumen de cinemática y dinámica", Precio = 14.00, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Programación", Descripcion = "Ejercicios resueltos y estructuras comunes en C++", Precio = 18.00, ImagenUrl = "../Imagenes/apuntes.png" }
            };

            rptApuntes.DataSource = apuntes;
            rptApuntes.DataBind();
        }
        */
        private void CargarApuntes()
        {
            string palabra = txtBusqueda.Text.Trim();
            string condicion = null; // No aplica aquí
            string subcategoria = ddlSubcategoria.SelectedValue;
            string tamano = null;
            string color = null;

            List<PublicacionDTO> lista = filtroPorCategoriaBO.FiltrarPorCategoria(
                categoria: "Apuntes",
                tipo: "Compra",          // Solo compra, no alquiler
                palabraClave: palabra,
                condicion: condicion,
                subcategoria: subcategoria,
                tamano: tamano,
                color:color
            );





            if (lista != null && lista.Count > 0)
            {
                ListaApuntes = lista;
                lblTotalResultados.Text = $"Se encontraron {lista.Count} resultados.";
                lblSinResultados.Text = "";
                MostrarPagina();
            }
            else
            {
                rptApuntes.DataSource = null;
                rptApuntes.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No se encontraron apuntes de clase con los filtros seleccionados.";
            }
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
                        Tipo = "Compra" // Fijo a compra
                    };

                    Session["PaginaAnterior"] = "ClasesGrabadas.aspx";
                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }


           protected void btnBuscar_Click(object sender, EventArgs e)
            {
            PaginaActual = 0;
            CargarApuntes();
            }

        private void MostrarPagina()
        {
            if (ListaApuntes == null || ListaApuntes.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaApuntes.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaApuntes.Count);

            var pagina = ListaApuntes.GetRange(inicio, fin - inicio);

            rptApuntes.DataSource = pagina;
            rptApuntes.DataBind();

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
            int totalPaginas = (int)Math.Ceiling((double)ListaApuntes.Count / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                MostrarPagina();
            }
        }

    }

       
    
}